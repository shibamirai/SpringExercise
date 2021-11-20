package katachi.spring.exercise.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import katachi.spring.exercise.domain.model.User;
import katachi.spring.exercise.domain.service.UserService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping
	public String getUser(Model model) {

		List<User> users = userService.getUsers();
		log.info(users.toString());
		model.addAttribute("users", users);

		return "list";
	}
}
