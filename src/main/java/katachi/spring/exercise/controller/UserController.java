package katachi.spring.exercise.controller;

import java.util.List;
import java.util.Locale;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import katachi.spring.exercise.domain.model.Team;
import katachi.spring.exercise.domain.model.User;
import katachi.spring.exercise.domain.service.UserService;
import katachi.spring.exercise.form.UserAddForm;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	@Autowired
	ModelMapper modelMapper;

	@Autowired
	private MessageSource messageSource;

	@GetMapping
	public String getUser(Model model) {

		List<User> users = userService.getUsers();
		log.info(users.toString());
		model.addAttribute("users", users);

		return "list";
	}

	@GetMapping("/add")
	public String getAdd(@ModelAttribute UserAddForm form, Model model) {

		List<Team> teams = userService.getTeams();
		log.info(teams.toString());
		model.addAttribute("teams", teams);

		return "add";
	}

	@PostMapping("/add")
	public String postAdd(@ModelAttribute @Validated UserAddForm form,
			BindingResult bindingResult, Model model, Locale locale) {

		log.debug(form.toString());
		if (!userService.isExist(form.getName())) {
			bindingResult.addError(new FieldError("userAddForm",
					"name", messageSource.getMessage("nameDuplicate", null, locale)));
		}
		if (bindingResult.hasErrors()) {
			return getAdd(form, model);
		}

		// form を User クラスに変換
		User user = modelMapper.map(form,  User.class);
		log.debug(user.toString());

		// ユーザー追加
		userService.register(user);

		return "redirect:/user";
	}

	@GetMapping("/del/{id}")
	public String getDelete(@PathVariable int id) {

		// ユーザー削除
		userService.delete(id);

		return "redirect:/user";
	}
}
