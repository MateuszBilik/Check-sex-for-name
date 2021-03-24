package com.business.demo.controller;

import com.business.demo.Sex;
import com.business.demo.service.CheckSexService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CheckSexController {

    private final CheckSexService checkSexService;

    public CheckSexController(CheckSexService checkSexService) {
        this.checkSexService = checkSexService;
    }

    @GetMapping(value = "/check", params = "firstNameOnly")
    public Sex checkSex (@RequestParam String firstNameOnly) {
    return checkSexService.checkSexByFirstName(firstNameOnly);
    }

    @GetMapping(value = "/check", params = "allNames")
    public Sex checkSexForAllNames (@RequestParam String allNames) {
        return checkSexService.checkSexByAllNames(allNames);
    }
}
