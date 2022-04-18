package com.dm.hellohuman;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HumanController {
		
    @RequestMapping("/")
    public String index(@RequestParam(value="q", required=false) String searchQuery, String lastName, Integer times) {
        if(searchQuery == null) {
        	return "Hello Human"; 
        }
        else if (lastName == null){
        	return "Hello " + searchQuery;
        }
        else if (times == null) {
        	return (" Hello " + searchQuery + " " +  lastName);
        }
        else {
        	return (" Hello " + searchQuery + " " +  lastName).repeat(times);
        }
    }
    @RequestMapping("/m/{track}/{module}/{lesson}")
    public String showLesson(@PathVariable("track") String track, @PathVariable("module") String module, @PathVariable("lesson") String lesson) {
    	return "Track: " + track + ", Module: " + module + ", Lesson: " + lesson;
    }
}
