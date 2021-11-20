package katachi.spring.exercise.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/input")
public class InputController {

	@GetMapping
	public String getInput(@RequestParam(name="name", required=false) String name, Model model) {

		model.addAttribute("name", name);

		return "input";
	}
}
