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

import br.com.fiap.GsWebApp.model.Healthy;
import br.com.fiap.GsWebApp.repository.GsRepository;

@Controller
public class HealthyController {
	
	@Autowired
	private GsRepository repository;
	
	@Autowired
	private MessageSource messages;
	
	@GetMapping("/healthy")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView("healthys");
		List<Healthy> healthys = repository.findAll();
		modelAndView.addObject("healthys", healthys);
		return modelAndView;
	}
	
	@RequestMapping("/healthy/new")
	public String create(Healthy healthy) {
		return "healthy-form";
	}
	
	@PostMapping("/healthy")
	public String save(@Valid Healthy healthy, BindingResult result, RedirectAttributes redirect) {
		if(result.hasErrors()) return "healthy-form";
		repository.save(healthy);
		redirect.addFlashAttribute("message", messages.getMessage("message.success.newhealthy", null, LocaleContextHolder.getLocale()));
		return "redirect:healthy";
	}
	

}

