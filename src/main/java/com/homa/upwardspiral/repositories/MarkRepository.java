package com.homa.upwardspiral.repositories;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.homa.upwardspiral.models.Goal;
import com.homa.upwardspiral.models.Mark;

public interface MarkRepository extends JpaRepository<Mark, Long> {

	Mark findByGoal(Goal goal);

	List<Mark> findByGoal(Optional<Goal> goal);

}
