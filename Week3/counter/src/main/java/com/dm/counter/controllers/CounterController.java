package com.dm.counter.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller 
public class CounterController {

	@RequestMapping("/")
	public String index(HttpSession session) {
		if (session.getAttribute("count") == null) {
			//use setAttribute to initialize the count in session. 
			System.out.println("Count is null");
			session.setAttribute("count", 0);
			Integer currentCount = (Integer) session.getAttribute("count");
		}
		else {
			Integer currentCount = (Integer) session.getAttribute("count");
			System.out.println("Count is not null");
			session.setAttribute("count", currentCount + 1);
			// increment the count by 1 using getAttribute and setAttribute.
		}
		return "index.jsp";
	}
	
	@RequestMapping("/by2")
	public String index2(HttpSession session) {
		if (session.getAttribute("count") == null) {
			//use setAttribute to initialize the count in session. 
			System.out.println("Count is null");
			session.setAttribute("count", 0);
			Integer currentCount = (Integer) session.getAttribute("count");
		}
		else {
			Integer currentCount = (Integer) session.getAttribute("count");
			System.out.println("Count is not null");
			session.setAttribute("count", currentCount + 2);
			// increment the count by 1 using getAttribute and setAttribute.
		}
		return "index2.jsp";
	}
	
	@RequestMapping("/counter")
	public String showCount(HttpSession session, Model model) {
			Integer currentCount = (Integer) session.getAttribute("count");
			model.addAttribute("countToShow", currentCount);
			return "showCount.jsp";
	}
	
	@RequestMapping("/reset")
	public String resetCount(HttpSession session, Model model) {
			session.setAttribute("count", 0);
			Integer currentCount = (Integer) session.getAttribute("count");
			model.addAttribute("countToShow", currentCount);
			return "showCount.jsp";
	}
	

}
