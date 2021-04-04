package katachi.spring.exercise.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import katachi.spring.exercise.model.AddForm;
import katachi.spring.exercise.model.Team;
import katachi.spring.exercise.model.User;
import katachi.spring.exercise.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	@Autowired
	MessageSource messageSource;

	@GetMapping
	public String list(Model model) {
		List<User> userList = userService.getUserList();
		model.addAttribute("userList", userList);
		return "list";
	}

	@GetMapping("/add")
	public String getAdd(@ModelAttribute AddForm form, Model model) {
		List<Team> teamList = userService.getTeamList();
		model.addAttribute("teamList", teamList);
		return "add";
	}

	@PostMapping("/add")
	public String postAdd(@ModelAttribute @Validated AddForm form, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return getAdd(form, model);
		}

		// 名前の重複チェック
		if (userService.isExistUser(form.getName())) {
			// バリデーションエラーに組み込む
			bindingResult.rejectValue("name", "nameDuplicate");
			return getAdd(form, model);
		}

		// 登録
		if (!userService.register(form.toUser())) {
			model.addAttribute("message", messageSource.getMessage(
					"register.error",
					new String[] {},
					Locale.getDefault()));
			return getAdd(form, model);
		}
		return "redirect:/user";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") int id) {
		System.out.println("id=" + id);
		userService.delete(id);
		return "redirect:/user";
	}

	@ExceptionHandler(DataAccessException.class)
	public String dataAccessExceptionHandler(DataAccessException e, Model model) {
		model.addAttribute("message", messageSource.getMessage(
				"exception.at",
				new String[] {"UserController", e.getClass().toString()},
				Locale.getDefault()));
		model.addAttribute("description", e.getLocalizedMessage());
		model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR);

		return "error";
	}
}
