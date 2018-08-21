package com.homa.upwardspiral.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.homa.upwardspiral.models.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByEmail(String email);

	User findByName(String name);

}
