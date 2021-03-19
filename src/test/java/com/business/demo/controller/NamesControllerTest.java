package com.business.demo.controller;

import com.business.demo.service.NamesService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class NamesControllerTest {

    @Mock
    NamesService namesService;

    @Test
    void returnNames() throws FileNotFoundException {
        //given
        String name = "female";
        when(namesService.getFemaleNames()).thenReturn(name);
        NamesController namesController = new NamesController(namesService);
        //when
        String female = namesController.returnNames("female");
        //then
        assertEquals(female, name);
    }


    @Test
    void checkSexForAllNames() {
    }
}