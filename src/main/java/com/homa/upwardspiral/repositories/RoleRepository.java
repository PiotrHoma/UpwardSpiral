package com.homa.upwardspiral.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.homa.upwardspiral.models.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
	Role findByRole(String role);
}
