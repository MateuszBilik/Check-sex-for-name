package com.business.demo.names_DB;

import org.junit.jupiter.api.Test;

import javax.naming.Name;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class NamesDBTest {

    @Test
    void getFemaleNames() throws FileNotFoundException {
//        //when
//        FileInputStream fileInputStream = mock(FileInputStream.class);
//        when(new Scanner(fileInputStream)).thenReturn(new Scanner("src/test/java/com/business/demo/names_DB/female.txt"));
//        NamesDB nameDB = new NamesDB();
////TODO
//        assertEquals(nameDB.getFemaleNames(), "msm");
    }

    @Test
    void getMaleNames() {
    }

    @Test
    void getNames() {
    }

    @Test
    void getSex() {
    }

    @Test
    void isFemaleName() {
    }

    @Test
    void isMaleName() {
    }

    @Test
    void isInFile() {
    }
}