package com.kfss.TaskManagementSystem.User;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	// Método para buscar usuário pelo nome
	Optional<User> findByName(String name);


	// Verifica se existe algum usuário com o nome
	boolean existsByName(String name);

}
