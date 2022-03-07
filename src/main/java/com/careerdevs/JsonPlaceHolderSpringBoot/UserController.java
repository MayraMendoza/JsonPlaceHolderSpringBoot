package com.careerdevs.JsonPlaceHolderSpringBoot;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping ("/user") // this will allow you to take out user from each method path because it will always indicate the same path.
public class UserController {
    @GetMapping  //("/") if you add this then you will always have to add it to your url but if you dont it will work without it or with it.
    public String getUser(){
        return "Getting Route";
    }



    @GetMapping("/{id}")
    // make requests outside this api- rest templet
    public Object jphUsers (RestTemplate restTemplate, @PathVariable("id") String userId ){
        Object requestData = restTemplate.getForObject("https://jsonplaceholder.typicode.com/users/"+ userId, Object.class);
        return requestData;

    }

    @PostMapping
    public Object create (RestTemplate restTemplate,
                          @RequestParam(value = "name", defaultValue = "_____") String name,
                          @RequestParam("email") String email,
                          @RequestParam("username") String username,
                          @RequestParam("phone") String phone )
            {
        System.out.println("\n\n\nUser: \n"+ "\nname: "+ name +"\nemail: "+ email + "\nusername: "+ username + "\nphone: "+ phone );
//        Object requestData = restTemplate.getForObject("https://jsonplaceholder.typicode.com/users/"+ userId, Object.class);
        return "Creating user failed ";

    }

    // this is the path- the url that you need to request in order to get specific method to run/
    // the route is both the path and the method combined (@getmapping & "/ping")
//    @GetMapping ("/ping")
//    public String pong(){
//        return "pong";
//    }


//    // @request Mapping will allow you to use (Get, Post, Request, Delete) WE DONT REALLY WANT TO USE THIS
//    @RequestMapping("/ping")
//    public String pong(){
//        return "pong";
//    }


    // when you make it an object its a good way to broadly(data type) receive /send data.
    //by working with objects it doesnt specify data types.
//    @GetMapping("/jsonplaceholder")
//    // make requests outside this api- rest templet
//    public Object jphUsers (RestTemplate restTemplate){
//        Object requestData = restTemplate.getForObject("https://jsonplaceholder.typicode.com/users/", Object.class);
//        return requestData;
//
//    }

}
