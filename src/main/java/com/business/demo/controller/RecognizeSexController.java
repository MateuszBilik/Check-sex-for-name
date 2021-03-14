package com.business.demo.controller;

import com.business.demo.Sex;
import com.business.demo.service.CheckSex;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecognizeSexController {

    private final CheckSex checkSex;

    public RecognizeSexController(CheckSex checkSex) {
        this.checkSex = checkSex;
    }

    @GetMapping("/check")
    public Sex checkSex (@RequestParam String name) {
    return checkSex.checkSexByFirstName(name);
    }

}
