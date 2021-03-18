package com.business.demo.service;

import com.business.demo.Sex;
import com.business.demo.names_DB.NamesDB;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
public class CheckSexService {

    private final NamesDB namesDB;

    public CheckSexService(NamesDB namesDB) {
        this.namesDB = namesDB;
    }

    public Sex checkSexByFirstName(String wholeName) {
        List<String> names = namesToList(wholeName);
        String mainName = names.get(0);
        if (isWord(mainName)) {
            return namesDB.getSex(mainName);
        }
        return Sex.INCONCLUSIVE;
    }

    public Sex checkSexByAllNames(String wholeName) {
        List<String> names = namesToList(wholeName);

        int femaleCount = 0;
        int maleCount = 0;
        int otherCount = 0;
        for (String name : names) {
            if (isWord(name)) {
                if (namesDB.getSex(name) == Sex.MALE) {
                    maleCount++;
                } else if (namesDB.getSex(name) == Sex.FEMALE) {
                    femaleCount++;
                }
            } else {
                otherCount++;
            }
        }
        log.info(names.toString());
        log.info("female: " +  femaleCount + ", male: " +  maleCount + ", other: " + otherCount);
        return chooseSex(femaleCount, maleCount, otherCount);
    }

    Sex chooseSex(int femaleCount, int maleCount, int otherCount) {
        if (femaleCount > (maleCount + otherCount)) {
            return Sex.FEMALE;
        } else if (maleCount > (femaleCount + otherCount)) {
            return Sex.MALE;
        } else {
            return Sex.INCONCLUSIVE;
        }
    }

    List<String> namesToList(String wholeName) {
        return Arrays.asList(wholeName.split(" "));
    }

    boolean isWord(String name) {
        for (int i = 0; i < name.length(); i++) {
            if ((!Character.isLetter(name.charAt(i)))) {
                log.info(name + " is not name");
                return false;
            }
        }
        return true;
    }
}
