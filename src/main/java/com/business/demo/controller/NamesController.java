package com.business.demo.controller;

import com.business.demo.service.NamesService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.util.Objects;

@RestController
public class NamesController {

    private final NamesService namesService;

    public NamesController(NamesService namesService) {
        this.namesService = namesService;
    }

    @GetMapping("/names")
    public String returnNames(@RequestParam(required = false) String type) throws FileNotFoundException {
        try {
            if (Objects.equals(type, "1")) {
                return namesService.getFemaleNames();
            } else if (Objects.equals(type, "2")) {
                return namesService.getMaleNames();
            } else
                return ("Female are: " + namesService.getFemaleNames() +
                        "\nMale are: " + namesService.getMaleNames());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw e;
        }
    }
}
