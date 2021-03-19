package com.business.demo.controller;

import com.business.demo.service.NamesService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.web.client.HttpClientErrorException;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class NamesControllerTest {

    @Mock
    NamesService namesService;

    @Test
    void returnNames_whenFemale() throws FileNotFoundException {
        //given
        String name = "femaleName";
        when(namesService.getFemaleNames()).thenReturn(name);
        NamesController namesController = new NamesController(namesService);
        //when
        String female = namesController.returnNames("female");
        //then
        assertEquals(name, female);
    }

    @Test
    void returnNames_whenMale() throws FileNotFoundException {
        //given
        String name = "maleName";
        when(namesService.getMaleNames()).thenReturn(name);
        NamesController namesController = new NamesController(namesService);
        //when
        String male = namesController.returnNames("male");
        //then
        assertEquals(name, male);
    }

    @Test
    void returnNames_whenNothing() throws FileNotFoundException {
        //given
        String maleName = "maleName";
        String femaleName = "femaleName";
        when(namesService.getMaleNames()).thenReturn(maleName);
        when(namesService.getFemaleNames()).thenReturn(femaleName);
        NamesController namesController = new NamesController(namesService);
        String response = "Female: " + femaleName + "\nMale: " + maleName;
        //when
        String both = namesController.returnNames("");
        //then
        assertEquals(response, both);
    }

    @Test
    void returnNames_whenAnything() throws FileNotFoundException {
        //given
        String maleName = "maleName";
        String femaleName = "femaleName";
        when(namesService.getMaleNames()).thenReturn(maleName);
        when(namesService.getFemaleNames()).thenReturn(femaleName);
        NamesController namesController = new NamesController(namesService);
        String response = "Female: " + femaleName + "\nMale: " + maleName;
        //when
        String both = namesController.returnNames("a3w4tb");
        //then
        assertEquals(response, both);
    }

    @Test
    void returnNames_whenException() throws FileNotFoundException {
        //given
        when(namesService.getMaleNames()).thenThrow(new FileNotFoundException());
        NamesController namesController = new NamesController(namesService);
        //when
        String both = namesController.returnNames("a3w4tb");
        //then
        assertEquals(both, "Problem with file");
    }
}
