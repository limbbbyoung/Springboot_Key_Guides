package com.springboot.api.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/delete-api")
public class DeleteController {

    // @PathVariable을 활용한 DELETE Method
    @DeleteMapping(value = "/{variable}")
    public String DeleteVariable(@PathVariable String variable) {
        return variable;
    }

    // @RequestParam을 활용한 DELETE Method
    @DeleteMapping(value = "/request1")
    public String getRequestParam1(@RequestParam String email) {
        return "e-mail : " + email;
    }
}
