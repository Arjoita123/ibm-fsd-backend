package com.examples.spring.boot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
@GetMapping("/")
public String print() {
	return "hello";
	
}


}
