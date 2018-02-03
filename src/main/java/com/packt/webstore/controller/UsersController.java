package com.packt.webstore.controller;
		import javax.servlet.http.HttpServletRequest;
		import org.springframework.stereotype.Controller;
		import org.springframework.ui.Model;
		import org.springframework.web.bind.annotation.PathVariable;
		import org.springframework.web.bind.annotation.RequestMapping;
		import org.springframework.web.bind.annotation.RequestMethod;
@Controller
@RequestMapping(value = "/user")
public class UsersController {
	@RequestMapping
	public String get(HttpServletRequest request) {
		return "redirect:/user/"+request.getSession(true).getId();
	}
	@RequestMapping(value = "/{userId}", method = RequestMethod.GET)
	public String getUser(@PathVariable(value = "userId") String userId,
						  Model model) {
		model.addAttribute("userId",userId);
		return "user";
	}
}


