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

    @GetMapping(value = "/check", params = "name")
    public Sex checkSex (@RequestParam String name) {
    return checkSexService.checkSexByFirstName(name);
    }

    @GetMapping(value = "/check", params = "names")
    public Sex checkSexForAllNames (@RequestParam String names) {
        return checkSexService.checkSexByAllNames(names);
    }
}
