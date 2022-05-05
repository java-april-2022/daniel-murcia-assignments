package com.dm.authentication.repositories;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.dm.authentication.models.User;

@Repository
public interface UserRepository {
	Optional<User> findByEmail(String email);
}
