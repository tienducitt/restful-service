package com.eventgate.backend.service.controller;

import com.eventgate.backend.service.dto.JsonInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @PostMapping
    public void post(@RequestBody JsonInfo body) {
        System.out.println(body);
    }
}
