package com.homa.upwardspiral.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.homa.upwardspiral.models.Goal;
import com.homa.upwardspiral.models.User;

public interface GoalRepository extends JpaRepository<Goal, Long>{
	
	Goal findByUser(User user);
}
