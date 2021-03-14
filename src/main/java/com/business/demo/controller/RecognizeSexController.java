package com.business.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class RecognizeSexController {

@GetMapping("/check")
    public String checkSex (@RequestParam String name) {

    return null;
    }

}
