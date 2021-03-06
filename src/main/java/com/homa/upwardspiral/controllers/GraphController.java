package com.homa.upwardspiral.controllers;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.homa.upwardspiral.models.Goal;
import com.homa.upwardspiral.models.Mark;
import com.homa.upwardspiral.services.GoalService;
import com.homa.upwardspiral.services.MarkService;


@Controller
public class GraphController {
	
	@Autowired
	MarkService markService;
	@Autowired
	GoalService goalService;
	
	//View for graph
	@RequestMapping("user/graph")
	public String showGraph (@RequestParam(name = "id") long id, ModelMap map) {
		Optional<Goal> goal = goalService.getGoalById(id);
		List<Mark> markList = markService.GetMarkByGoal(goal);
		Map<String,Integer> graphMap = new LinkedHashMap<>();
			int i;
			for(i=0; markList.size()>i; i++) {
				graphMap.put("Day "+(1 + i), markList.get(i).getMark());
			}
		map.addAttribute("graphMap", graphMap);		
		return "user/graph";
	}
}
