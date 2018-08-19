package com.homa.upwardspiral.services;

import java.util.List;
import java.util.Optional;

import com.homa.upwardspiral.models.Goal;
import com.homa.upwardspiral.models.Mark;

public interface MarkService {
	
	Mark saveMark (Mark mark);	
	Mark GetMarkByGoal (Goal goal);
	List<Mark> GetAllMarks();
	List<Mark> GetMarkByGoal(Optional<Goal> goal);
}
