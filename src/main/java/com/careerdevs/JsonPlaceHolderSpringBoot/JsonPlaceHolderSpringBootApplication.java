package com.careerdevs.JsonPlaceHolderSpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication // this allows class to be the starting point of our server. we will only use it once,
// and it will be the main file from were our application starts.


// annotations - if you want a particular class to handle requests add rest controller.
// allows us to give a method, a class or a field some ability... to inject that code to any method, field or class we are using
// without adding spring boot we would not have acces to rest control.
@RestController

public class JsonPlaceHolderSpringBootApplication {

	// @request Mapping will allow you to use (Get, Post, Request, Delete) WE DONT REALLY WANT TO USE THIS
	@RequestMapping("/ping")
	public String pong(){
		return "pong";
	}

	// this is what is determining the different methods we are going to be using.
	// this will be the route handler
	@GetMapping ("/")
	public String rootRoute(){
		// return will be what we want to respond the user with.
		return "You are Home";
	}



	public static void main(String[] args) {
		// this is making our program run
		SpringApplication.run(JsonPlaceHolderSpringBootApplication.class, args);
	}

}
