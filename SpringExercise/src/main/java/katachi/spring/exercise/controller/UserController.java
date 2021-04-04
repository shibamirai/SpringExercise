package katachi.spring.exercise.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import katachi.spring.exercise.model.User;
import katachi.spring.exercise.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping
	public String list(Model model) {
		List<User> userList = userService.getUserList();
		model.addAttribute("userList", userList);
		return "list";
	}
}
