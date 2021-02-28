package com.example.lauraleisu

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/test")
class HelloWorldController {

    @GetMapping
    fun helloWorld(): String {
        System.out.println("End Point hit");
        return "Hello, this is a REST endpoint!"
    }
}

