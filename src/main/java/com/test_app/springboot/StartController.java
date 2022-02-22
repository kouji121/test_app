package com.test_app.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import com.test_app.springboot.repositories.StartDataRepository;


@Controller
public class StartController {
	
	@Autowired
	StartDataRepository repository;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView index(ModelAndView mav) {
		mav.setViewName("index");
		Iterable<StartData> list = repository.findAll();
		mav.addObject("data",list);
		return mav;
	}
	@RequestMapping("/other")
	public String other() {
		return "redirect:/";
	}
	@RequestMapping("/{id}")
	public ModelAndView index(@PathVariable int id, ModelAndView mav) {
		mav.setViewName("index");
		mav.addObject("id", id);
		mav.addObject("check", id % 2 == 0);
		mav.addObject("trueVal", "Even number!");
		mav.addObject("falseVal", "Odd number...");
		return mav;
	}
	@RequestMapping(value="/", method=RequestMethod.POST)
	public ModelAndView send(@RequestParam("text1")String str, ModelAndView mav) {
		mav.addObject("msg","こんにちは、"+str+"さん！");
		mav.addObject("msg",str);
		mav.setViewName("index");
		return mav;
	}
}
