package com.example.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author raindew
 * @Date 2019/9/2
 */
@Controller
public class ExampleController {
	@RequestMapping("/if")
	public String ifunless(ModelMap map) {
		map.addAttribute("flag", "yes");
		return "if";
	}

	@RequestMapping("/eq")
	public String eq(ModelMap map) {
		map.addAttribute("name", "neo");
		map.addAttribute("age", 30);
		map.addAttribute("flag", "yes");
		return "eq";
	}
}
