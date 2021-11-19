package br.com.fiap.GsWebApp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.fiap.GsWebApp.model.User;
import br.com.fiap.GsWebApp.repository.UserRepository;


@Controller
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private MessageSource messages;
	
	@GetMapping
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView("user");
		List<User> user = repository.findAll();
		modelAndView.addObject("user", user);
		System.out.println(user);
		return modelAndView;
	}
	
	@RequestMapping("new")
	public String create(User user) {
		return "user-form";
	}
	
	@PostMapping
	public String save(@Valid User user, BindingResult result, RedirectAttributes redirect) {
		if(result.hasErrors()) return "user-form";
		repository.save(user);
		redirect.addFlashAttribute("message", messages.getMessage("message.success.newuser", null, LocaleContextHolder.getLocale()));
		return "redirect:user";
	}

}