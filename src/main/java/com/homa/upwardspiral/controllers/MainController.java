package com.homa.upwardspiral.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import com.homa.upwardspiral.models.Goal;
import com.homa.upwardspiral.models.Mark;
import com.homa.upwardspiral.models.User;
import com.homa.upwardspiral.services.GoalService;
import com.homa.upwardspiral.services.MarkService;
import com.homa.upwardspiral.services.UserService;

@Controller
public class MainController {
	@Autowired
	private GoalService goalService;
	@Autowired
	private UserService userService;
	@Autowired
	private MarkService markService;
	
	//Provides current logged in user.
	private User getAuthenticatedUser() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		return user;
	}
	//Provides list of goals belonging to logged in user.
	private List<Goal> userGoalsList() {
		List<Goal> goals = goalService.getAllGoals();
		List<Goal> ListGoals = goals.stream().filter(p -> p.getUser().equals(getAuthenticatedUser())).collect(Collectors.toList());
		return ListGoals;
	}
	//Saves goal. Forbid creating empty goals. Return Success message to the view.
	@RequestMapping("user/saveGoal")
	public String saveGoal(@ModelAttribute("goal") Goal goal, ModelMap modelMap) {
		if(goal.getName().length()>0) {
		Goal goalSaved = goal;
		goalSaved.setUser(getAuthenticatedUser());
		goalService.saveGoal(goalSaved);
		String msg = "Goal saved with id: " + goalSaved.getName();
		modelMap.addAttribute("msg", msg);
		}
		return "user/setgoal";
	}
	//Delete goal with his marks (specified in Goal Model).
	@RequestMapping(value = "user/deleteGoal", method = RequestMethod.GET)
	public String deleteGoal(@RequestParam(name = "id") int id) {
		Optional<Goal> goalOptional = goalService.getGoalById(id);
		if (goalOptional.isPresent()) {
			Goal goal = goalOptional.get();
			goalService.deleatGoal(goal);
		}
		return "redirect:/user/displayGoals";
	}
	//View mapping for displayGoals
	@RequestMapping("user/displayGoals")
	public String displayGoals(ModelMap modelMap) {
		modelMap.addAttribute("Goals", userGoalsList());
		return "user/displayGoals";
	}
	//View for editing a goal also forbids access to other users goals by changing the id in url.
	@RequestMapping(value = "user/showUpdate", method = RequestMethod.GET)
	public String editGoal(@RequestParam(name = "id") long id, ModelMap modelMap) {
		Optional<Goal> goalOptional = goalService.getGoalById(id);
		if (goalOptional.isPresent() && goalOptional.get().getUser().equals(getAuthenticatedUser())) {
			modelMap.addAttribute("Id", goalOptional.get().getId());
			modelMap.addAttribute("Name", goalOptional.get().getName());
			modelMap.addAttribute("Goal", goalOptional.get().getDescription());
			modelMap.addAttribute("User", goalOptional.get().getUser().getId());
			return "user/updateGoal";
		}else {
		return "user/access-denied";
		}
	}
	//Saves edited goal.
	@RequestMapping(value = "user/updateGoal", method = RequestMethod.GET)
	public String updateGoal(@ModelAttribute("goal") Goal goal, ModelMap modelMap) {
		if(goal.getName().length()>0) {
		goalService.updateGoal(goal);
		}
		modelMap.addAttribute("Goals", userGoalsList());
		return "user/displayGoals";
	}
	//View for choosing goals to mark.
	@RequestMapping("user/chooseGoalToMark")
	public String chooseGoalToMark(ModelMap modelMap) {
		modelMap.addAttribute("Goal", userGoalsList());
		return "user/chooseGoalToMark";
	}
	//View for a specific goal to mark with the radio buttons list to choose your mark from.
	@RequestMapping(value= "user/markIt", method = RequestMethod.GET)
	public String markIt(@RequestParam(name = "id") int id, ModelMap modelMap) {
		Optional<Goal> goal = goalService.getGoalById(id);
		if(goal.get().getUser().equals(getAuthenticatedUser())) {
		modelMap.addAttribute("Goal", goal.get().getId());
		modelMap.addAttribute("Name", goal.get().getName());
		return "user/markIt";
		}else {
			return "user/access-denied";
		}
	}
	//Saves the mark.
	@RequestMapping("user/saveMark")
	public String saveMark(@ModelAttribute("goal") Goal goal, @RequestParam("mark") int markMark) {
			Mark mark = new Mark();
			mark.setMark(markMark);
			mark.setGoal(goal);
			markService.saveMark(mark);
		return "redirect:../user/chooseGoalToMark";
	}
	

}
