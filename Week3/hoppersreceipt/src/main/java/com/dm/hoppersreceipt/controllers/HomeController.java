package com.dm.hoppersreceipt.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	// class definition and imports here...
    @RequestMapping("/")
    public String index(Model model) {
        
        String name = "Grace Virginia Hopper";
        String itemName = "Copper wire";
        double price = 5.25;
        String description = "Metal strips, also an illustration of nanoseconds.";
        String vendor = "Tiny Things Corner Store";
    
    	// Your code here! Add values to the view model to be rendered
        model.addAttribute("name", name);
		model.addAttribute("item", itemName);
		model.addAttribute("price", price);
		model.addAttribute("description", description);
		model.addAttribute("vendor", vendor);
		
        return "index.jsp";
    }
    
    @RequestMapping("/dojos")
    public String index2(Model model) {
    	ArrayList<String> dojos = new ArrayList<String>();
    	dojos.add("Burbank");
    	dojos.add("Chicago");
    	dojos.add("Bellevue");
    	model.addAttribute("dojosFromMyController", dojos);
    	return "index.jsp";
    	
    }
	

	
	
}
