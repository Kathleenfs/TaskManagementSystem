package com.kfss.TaskManagementSystem.security;

import com.kfss.TaskManagementSystem.User.User;
import com.kfss.TaskManagementSystem.User.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	private final UserRepository userRepository;

	public UserDetailsServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByName(username)
				.orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado: " + username));

		return org.springframework.security.core.userdetails.User.withUsername(user.getName())
				.password(user.getPassword()).roles("USER") // Modifique conforme necessário
				.build();
		}
}