package psu.edu.Final.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/")
    public String showHome() {
    	
        return "home";
    }
    @GetMapping("AddEmployee")
    public String getAddForm() {
    	return "empAdd";
    }
	
}
