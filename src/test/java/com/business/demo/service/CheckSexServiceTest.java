package com.business.demo.service;

import com.business.demo.Sex;
import com.business.demo.names_DB.NamesDB;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class CheckSexServiceTest {

    CheckSexService checkSexService = new CheckSexService(new NamesDB());

    @Test
    void whenGivenNames_checkSexByFirstName_returnSexOnlyForFirst() {
        // given
        String femaleName = "Karolina Jan";
        String maleName = "Jan Karolina Renata";
        String otherName = "123 Karolina Renata";
        String emptyName = "";

        //when
        Sex responseFemale = checkSexService.checkSexByFirstName(femaleName);
        Sex responseMale = checkSexService.checkSexByFirstName(maleName);
        Sex responseOther = checkSexService.checkSexByFirstName(otherName);
        Sex responseEmpty = checkSexService.checkSexByFirstName(emptyName);

        //then
        Assertions.assertEquals(responseFemale, Sex.FEMALE);
        Assertions.assertEquals(responseMale, Sex.MALE);
        Assertions.assertEquals(responseOther, Sex.INCONCLUSIVE);
        Assertions.assertEquals(responseEmpty, Sex.INCONCLUSIVE);
    }

    @Test
    void checkSexByAllNames() {
        // given
        String femaleAndMaleNames = "Karolina Jan";
        String MoreFemaleNames = "Jan Karolina Anna";
        String MoreMaleNames = "Jan Jan Anna";
        String ThreeDifferentNames = "123 Jan Renata";
        String twoFemaleAndOneOfTheOthersNames = "123 Jan Renata Anna";
        String twoMaleAndOneOfTheOthersNames = "123 Jan Mateusz Anna";
        String emptyName = "";

        //when
        Sex responseFemaleAndMale = checkSexService.checkSexByAllNames(femaleAndMaleNames);
        Sex responseMoreFemaleNames = checkSexService.checkSexByAllNames(MoreFemaleNames);
        Sex responseMoreMaleNames = checkSexService.checkSexByAllNames(MoreMaleNames);
        Sex responseThreeDifferentNames = checkSexService.checkSexByAllNames(ThreeDifferentNames);
        Sex responseTwoFemaleAndOneOfTheOthers = checkSexService.checkSexByAllNames(twoFemaleAndOneOfTheOthersNames);
        Sex responseTwoMaleAndOneOfTheOthers = checkSexService.checkSexByAllNames(twoMaleAndOneOfTheOthersNames);
        Sex responseEmpty = checkSexService.checkSexByAllNames(emptyName);

        //then
        Assertions.assertEquals(responseFemaleAndMale, Sex.INCONCLUSIVE);
        Assertions.assertEquals(responseMoreFemaleNames, Sex.FEMALE);
        Assertions.assertEquals(responseMoreMaleNames, Sex.MALE);
        Assertions.assertEquals(responseThreeDifferentNames, Sex.INCONCLUSIVE);
        Assertions.assertEquals(responseTwoFemaleAndOneOfTheOthers, Sex.INCONCLUSIVE);
        Assertions.assertEquals(responseTwoMaleAndOneOfTheOthers, Sex.INCONCLUSIVE);
        Assertions.assertEquals(responseEmpty, Sex.INCONCLUSIVE);
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