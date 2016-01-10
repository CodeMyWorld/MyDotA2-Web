package alex.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.portlet.ModelAndView;
import alex.model.User;
import alex.service.IUserService;


@Controller
@RequestMapping("/user")
public class UserController {

	@Resource(name = "userService")
	private IUserService userService;

	@RequestMapping(value="/register", method=RequestMethod.GET)
	public ModelAndView getRegister(){
		ModelAndView mView = new ModelAndView();
		mView.setViewName("user/register");
		return mView;
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String add(@ModelAttribute("user") User user){
		userService.create(user);
		return "redirect:/user/register";
	}
}
