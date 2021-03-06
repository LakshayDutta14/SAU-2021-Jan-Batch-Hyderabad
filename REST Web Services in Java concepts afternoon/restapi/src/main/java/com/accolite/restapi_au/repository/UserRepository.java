package com.accolite.restapi_au.repository;


import com.accolite.restapi_au.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
	public Optional<User> findByEmailId(String email);
}
