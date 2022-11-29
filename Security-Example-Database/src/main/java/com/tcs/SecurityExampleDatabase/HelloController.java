package com.tcs.SecurityExampleDatabase;

import java.security.Principal;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HelloController {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/hello")
	public ResponseEntity getHello() {
		return new ResponseEntity("Hello", HttpStatus.OK);
	}
	
	@GetMapping("/")
	  public ModelAndView home(Principal principal) {
	     return (new ModelAndView("home")).addObject("principal", principal);
	  }
	  @GetMapping("/login")
	  public ModelAndView login() {
	     return new ModelAndView("login");
	  }
}
