package katachi.spring.exercise.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import katachi.spring.exercise.model.InputForm;


@Controller
@RequestMapping("/input")
public class InputController {

	@GetMapping
	public String show(
			@ModelAttribute
			InputForm form,
			Model model
	) {
		String[] radioGender = {"男性", "女性", "その他"};
		model.addAttribute("radioGender", radioGender);

		String[] selectBlood = {"A型", "B型", "AB型", "O型", "不明"};
		model.addAttribute("selectBlood", selectBlood);

		String[] checkSubject = {"JAVA", "PHP", "HTML", "デザイン", "その他"};
		model.addAttribute("checkSubject", checkSubject);

		return "input";
	}

	@PostMapping
	public String submit(@ModelAttribute InputForm form, Model model) {
		return "profile";
	}
}
