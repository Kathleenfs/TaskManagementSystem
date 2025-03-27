package com.kfss.TaskManagementSystem.User;

import java.util.List;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kfss.TaskManagementSystem.User.dto.RegisterDTO;
import com.kfss.TaskManagementSystem.util.*;

import jakarta.validation.Valid;

@Service
public class UserService {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;

	public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	@Transactional
	public void registerUser(@Valid RegisterDTO registerDTO) {
		if (userRepository.existsByName(registerDTO.getName())) {
			throw new UserAlreadyExistsException("Usuário já cadastrado com este nome.");
		}

		User user = new User();
		user.setName(registerDTO.getName());
		user.setPassword(passwordEncoder.encode(registerDTO.getPassword()));

		userRepository.save(user);
	}

	public List<User> getAllUser() {
		return userRepository.findAll();
	}

	public User getUserById(Long id) {
		return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("Usuário não encontrado."));
	}

	@Transactional
	public User updateUser(Long id, User userDetails) {
		User existingUser = getUserById(id);
		existingUser.setName(userDetails.getName());
		existingUser.setPassword(passwordEncoder.encode(userDetails.getPassword()));
		return userRepository.save(existingUser);
	}

	@Transactional
	public void deleteUser(Long id) {
		User user = getUserById(id);
		userRepository.delete(user);
	}

}
