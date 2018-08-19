package com.homa.upwardspiral.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homa.upwardspiral.models.Goal;
import com.homa.upwardspiral.models.Mark;
import com.homa.upwardspiral.repositories.MarkRepository;

@Service
public class MarkServiceImp implements MarkService {

	@Autowired 
	private MarkRepository markRepository;

	@Override
	public Mark saveMark(Mark mark) {
		return markRepository.save(mark);
	}

	@Override
	public Mark GetMarkByGoal(Goal goal) {
		return markRepository.findByGoal(goal);
	}

	@Override
	public List<Mark> GetAllMarks() {
		return markRepository.findAll();
	}

	@Override
	public List<Mark> GetMarkByGoal(Optional<Goal> goal) {
		return markRepository.findByGoal(goal);
	}	
}
