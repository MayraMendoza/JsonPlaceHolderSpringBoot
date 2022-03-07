package com.careerdevs.JsonPlaceHolderSpringBoot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TodoController {
    //http://localhost:3000/todo
    @GetMapping
    //("/") if you add this then you will always have to add it to your url but if you dont it will work without it or with it.
    public String getTodo(){
        return "Todo Route";
    }


    //http://localhost:3000/todo/{id}
    @GetMapping("/{id}")
    // make requests outside this api- rest templet
    public Object getTodo (RestTemplate restTemplate, @PathVariable("id") String todoId ){
        Object requestData = restTemplate.getForObject("https://jsonplaceholder.typicode.com/users/"+ todoId, Object.class);
        return requestData;

    }
}
