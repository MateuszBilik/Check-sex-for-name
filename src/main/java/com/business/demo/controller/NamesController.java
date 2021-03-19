package com.business.demo.controller;

import com.business.demo.service.NamesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.util.Objects;

@Slf4j
@RestController
public class NamesController {

    private final NamesService namesService;

    public NamesController(NamesService namesService) {
        this.namesService = namesService;
    }

    @GetMapping("/names")
    public String returnNames(@RequestParam(required = false) String type) {
        try {
            if (Objects.equals(type, "male")) {
                log.info("Return male list");
                return namesService.getMaleNames();
            } else if (Objects.equals(type, "female")) {
                log.info("Return female list");
                return namesService.getFemaleNames();
            } else
                log.info("Return male and female list");
                return ("Female: " + namesService.getFemaleNames() +
                        "\nMale: " + namesService.getMaleNames());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return "Problem with file";
        }
    }
}
