package com.kfss.TaskManagementSystem.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private UserDetailsServiceImpl userDetailsService;

	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		// Obter o cabeçalho Authorization
		String authHeader = request.getHeader("Authorization");
		String token = null;
		String username = null;

		// Extrair o token JWT do cabeçalho
		if (authHeader != null && authHeader.startsWith("Bearer ")) {
			token = authHeader.substring(7); // Remove "Bearer " do token.
			username = jwtUtil.extractUsername(token); // Extrai o nome do usuário do token.
		}

		// Validar o token e autenticar o usuário
		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			UserDetails userDetails = userDetailsService.loadUserByUsername(username);

			// Verifica se o token é válido
			if (jwtUtil.validateToken(token)) {
				// Cria o objeto de autenticação e o adiciona no SecurityContext
				UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails,
						null, userDetails.getAuthorities());
				SecurityContextHolder.getContext().setAuthentication(authToken);
			}
		}

		// Continua o processamento do filtro
		filterChain.doFilter(request, response);
	}

	@Override
	protected void doFilterInternal(jakarta.servlet.http.HttpServletRequest request,
			jakarta.servlet.http.HttpServletResponse response, jakarta.servlet.FilterChain filterChain)
			throws jakarta.servlet.ServletException, IOException {
		// TODO Auto-generated method stub
		
	}
}
