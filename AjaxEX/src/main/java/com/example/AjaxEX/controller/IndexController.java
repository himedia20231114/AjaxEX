package com.example.AjaxEX.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class IndexController {
	
	// http://localhost:9696/ 
	
	@GetMapping("/")
	public String index() {
		
		return "index"; 
	}
	
	@GetMapping("/ajax-ex-01")
	public String ajax01() {	
		return "ajax-ex-01"; 
	}
	@GetMapping("/ajax-ex-02")
	public String ajax02() {	
		return "ajax-ex-02"; 
	}
	@GetMapping("/ajax-ex-03")
	public String ajax03() {	
		return "ajax-ex-03"; 
	}
	@GetMapping("/ajax-ex-04")
	public String ajax04() {	
		return "ajax-ex-04"; 
	}
	@GetMapping("/ajax-ex-05")
	public String ajax05() {	
		return "ajax-ex-05"; 
	}
	@GetMapping("/ajax-ex-06")
	public String ajax06() {	
		return "ajax-ex-06"; 
	}
	@GetMapping("/ajax-ex-07")
	public String ajax07() {	
		return "ajax-ex-07"; 
	}
	@GetMapping("/ajax-ex-08")
	public String ajax08() {	
		return "ajax-ex-08"; 
	}
	@GetMapping("/ajax-ex-09")
	public String ajax09() {	
		return "ajax-ex-09"; 
	}
	@GetMapping("/ajax-ex-10")
	public String ajax10() {	
		return "ajax-ex-10"; 
	}
	
	@GetMapping("/movie-lab")
	public String movieLab() {
		
		return "movie-lab"; 
	}
	
	

}
