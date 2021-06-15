package io.pantheon.interview.question.madlibsdemo;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.pantheon.interview.question.madlibsdemo.services.MadlibsService;

@RestController
public class MadlibsController {
	
	@CrossOrigin(origins = "*", maxAge = 3600)
	@GetMapping(value = {"/"})
	public String index() {
		return "Welcome to Pantheon MadLibs!";
	}
	
	@CrossOrigin(origins = "*", maxAge = 3600)
	@GetMapping(value = {"/madlib"})
	public String getMatlib() {
		MadlibsService service = new MadlibsService();
		return service.getSentence();
	}

}
