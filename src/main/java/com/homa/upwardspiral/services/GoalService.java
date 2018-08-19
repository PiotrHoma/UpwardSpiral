package com.homa.upwardspiral.services;

import java.util.List;
import java.util.Optional;

import com.homa.upwardspiral.models.Goal;
import com.homa.upwardspiral.models.User;

public interface GoalService {
	Goal saveGoal(Goal goal);

	Goal updateGoal(Goal goal);

	void deleatGoal(Goal goal);
	
	Optional<Goal> getGoalById(long id);

	List<Goal> getAllGoals();
	
	Goal getGoalByUser(User user);

}
