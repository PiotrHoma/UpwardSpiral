package com.homa.upwardspiral.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homa.upwardspiral.models.Goal;
import com.homa.upwardspiral.models.User;
import com.homa.upwardspiral.repositories.GoalRepository;
@Service
public class GoalServiceImp implements GoalService {

	@Autowired
	private
	GoalRepository goalrepository;
	
	@Override
	public Goal saveGoal(Goal goal) {
		return goalrepository.save(goal);
	}


	@Override
	public Goal updateGoal(Goal goal) {
		return goalrepository.save(goal);
	}

	@Override
	public void deleatGoal(Goal goal) {
		goalrepository.delete(goal);

	}

	@Override
	public Optional<Goal> getGoalById(long id) {
		return goalrepository.findById(id);
	}

	@Override
	public List<Goal> getAllGoals() {
		return goalrepository.findAll();
	}
	public GoalRepository getGoalrepository() {
		return goalrepository;
	}

	public void setGoalrepository(GoalRepository goalrepository) {
		this.goalrepository = goalrepository;
	}

	@Override
	public Goal getGoalByUser(User user) {
		return goalrepository.findByUser(user);
	}

}
