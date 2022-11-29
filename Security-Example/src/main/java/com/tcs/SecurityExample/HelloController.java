package com.tcs.SecurityExample;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/hello")
	public ResponseEntity getHello() {
		return new ResponseEntity("Hello", HttpStatus.OK);
	}
}
