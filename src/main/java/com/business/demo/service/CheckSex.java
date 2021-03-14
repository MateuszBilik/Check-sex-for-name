package com.business.demo.service;

import com.business.demo.Sex;
import com.business.demo.nameLists.NameLists;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CheckSex {

    private final NameLists nameLists;

    public CheckSex(NameLists nameLists) {
        this.nameLists = nameLists;
    }

    public Sex checkSexByFirstName(String wholeName) {
        List<String> names = Arrays.asList(wholeName.split(" "));
        String mainName = names.get(0);
        if (checkName(mainName)){
            return checkSex(mainName);
        }
        return Sex.INCONCLUSIVE;
    }

    boolean checkName(String name) {
        for (int i = 0; i < name.length(); i++) {
            if ((!Character.isLetter(name.charAt(i)))) {
                return false;
            }
        }
        return true;
    }

    Sex checkSex(String mainName) {
        if (Arrays.stream(nameLists.getMaleNames())
                .anyMatch(name -> name.equalsIgnoreCase(mainName))) {
            return Sex.MALE;
        } else if (Arrays.stream(nameLists.getFemaleNames())
                .anyMatch(name -> name.equalsIgnoreCase(mainName))) {
            return Sex.FEMALE;
        } else {
            return Sex.INCONCLUSIVE;
        }
    }
}
