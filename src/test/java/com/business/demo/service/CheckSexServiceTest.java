package com.business.demo.service;

import com.business.demo.Sex;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

//@RunWith(SpringRunner.class)
//@SpringBootTest
//@ContextConfiguration
class CheckSexServiceTest {

    private final CheckSexService checkSexService = new CheckSexService();

    @Test
    void whenGivenBadFirstName_checkSexByFirstName_returnInconclusive() {
        // given
        String wholeNameAsNumber = "123 Jan Karolina";
        String wholeNameWithNumber = "Karolina1 Jan Karolina";
        String wholeNameWithSymbol = "K@rolina Jan Karolina";

        //when


        //then

    }

    @Test
    void checkSexByAllNames() {
        // given

        //when

        //then
    }

    @Test
    void whenGivenTheSameNumberMaleAsOther_chooseSex_getInconclusive() {
        // given
        int female = 1;
        int male = 2;
        int other = 1;

        //when
        Sex sex = checkSexService.chooseSex(female, male, other);

        //then
        Assertions.assertEquals(sex, Sex.INCONCLUSIVE);
    }

    @Test
    void whenGivenMoreNumberMaleAsOther_chooseSex_getMale() {
        // given
        int female = 1;
        int male = 3;
        int other = 1;

        //when
        Sex sex = checkSexService.chooseSex(female, male, other);

        //then
        Assertions.assertEquals(sex, Sex.MALE);
    }

    @Test
    void whenGivenAllTheSame_chooseSex_getInconclusive() {
        // given
        int female = 1;
        int male = 1;
        int other = 1;

        //when
        Sex sex = checkSexService.chooseSex(female, male, other);

        //then
        Assertions.assertEquals(sex, Sex.INCONCLUSIVE);
    }

    @Test
    void whenGivenOnluFemale_chooseSex_returnFemale() {
        // given
        int female = 1;
        int male = 0;
        int other = 0;

        //when
        Sex sex = checkSexService.chooseSex(female, male, other);

        //then
        Assertions.assertEquals(sex, Sex.FEMALE);
    }

    @Test
    void namesToList() {
        // given
        String names = "Mateusz Kuba";
        String name = "Mateusz";
        List<String> namesList = Arrays.asList("Mateusz", "Kuba");
        List<String> nameList = Arrays.asList("Mateusz");
        //when then
        Assertions.assertEquals(namesList, checkSexService.namesToList(names));
        Assertions.assertEquals(nameList, checkSexService.namesToList(name));
    }

    @Test
    void whenGivenNoWord_isWord_ReturnFalse() {
        // given
        String nameAsNumber = "123";
        String nameWithNumber = "Karolina1";
        String nameWithSymbol = "K@rolina";
        String nameEmpty = "";

        //when
        boolean responseAsNumber = checkSexService.isWord(nameAsNumber);
        boolean responseWithNumber = checkSexService.isWord(nameWithNumber);
        boolean responseWithSymbol = checkSexService.isWord(nameWithSymbol);
        boolean responseEmpty = checkSexService.isWord(nameEmpty);

        //then
        Assertions.assertFalse(responseAsNumber);
        Assertions.assertFalse(responseWithNumber);
        Assertions.assertFalse(responseWithSymbol);
        Assertions.assertFalse(responseEmpty);
    }

    @Test
    void whenGivenGoodWord_isWord_ReturnFalse() {
        // given
        String nameUpperCase = "JAN";
        String name = "Karolina";
        String nameLowerCase = "mateusz";

        //when
        boolean responseUpperCase = checkSexService.isWord(nameUpperCase);
        boolean responseName = checkSexService.isWord(name);
        boolean responseLowerCase = checkSexService.isWord(nameLowerCase);

        //then
        Assertions.assertTrue(responseUpperCase);
        Assertions.assertTrue(responseName);
        Assertions.assertTrue(responseLowerCase);
    }
}