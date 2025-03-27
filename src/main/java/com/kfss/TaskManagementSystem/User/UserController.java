package com.kfss.TaskManagementSystem.User;

import com.kfss.TaskManagementSystem.User.dto.LoginDTO;
import com.kfss.TaskManagementSystem.User.dto.RegisterDTO;
import com.kfss.TaskManagementSystem.security.JwtUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/auth")
public class UserController {

	private final UserService userService;
	private final JwtUtil jwtUtil;
	private final AuthenticationManager authenticationManager;

	// Injeção via construtor para facilitar testes e evitar @Autowired em atributos
	public UserController(UserService userService, JwtUtil jwtUtil, AuthenticationManager authenticationManager) {
		this.userService = userService;
		this.jwtUtil = jwtUtil;
		this.authenticationManager = authenticationManager;
	}

	@PostMapping("/register")
	@ResponseStatus(HttpStatus.CREATED)
	public String registerUser(@Valid @RequestBody RegisterDTO registerDTO) {
		userService.registerUser(registerDTO);
		return "Usuário registrado com sucesso!";
	}

	@PostMapping("/login")
	public ResponseEntity<String> loginUser(@Valid @RequestBody LoginDTO loginDTO) {
		try {
			Authentication authentication = authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getEmail(), loginDTO.getPassword()));

			String token = jwtUtil.generateToken(authentication.getName());
			return ResponseEntity.ok("Bearer " + token);

		} catch (AuthenticationException e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais inválidas.");
		}
	}

	// o spring ja converte automaticamente o retorno para Json. Evitar
	// responseEntity desnecessario
	@GetMapping("/users")
	public List<User> getAllUsers() {
		return userService.getAllUser();
	}

	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUserById(@PathVariable Long id) {
		return ResponseEntity.ok(userService.getUserById(id));
	}

	@PutMapping("/users/{id}")
	public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userDetails) {
		return ResponseEntity.ok(userService.updateUser(id, userDetails));
	}

	@DeleteMapping("/users/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);
	}
}