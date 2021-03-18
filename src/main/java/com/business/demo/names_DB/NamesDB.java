package com.business.demo.names_DB;

import com.business.demo.Sex;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

@Data
@Component
@Slf4j
public class NamesDB {

    public String getFemaleNames () throws FileNotFoundException {
            Scanner scanner = new Scanner(
                    new FileInputStream("src/main/resources/female.txt"), "UTF-8");
        return getNames(scanner);
    }

    public String getMaleNames () throws FileNotFoundException {
        Scanner scanner = new Scanner(
                new FileInputStream("src/main/resources/male.txt"), "UTF-8");
        return getNames(scanner);
    }

    String getNames(Scanner scanner) {
        StringBuilder femaleNames = new StringBuilder();
        while (scanner.hasNextLine()) {
            femaleNames
                    .append(scanner.nextLine())
                    .append(", ");
            }
        return femaleNames.toString();
    }

    public Sex getSex(String inputName) {
        if (isMaleName(inputName)) {
            log.info(inputName + " is male");
            return Sex.MALE;
        } else if (isFemaleName(inputName)) {
            log.info(inputName + " is female");
            return Sex.FEMALE;
        } else {
            log.info(inputName + " is inconclusive");
            return Sex.INCONCLUSIVE;
        }
    }

    boolean isFemaleName(String name) {
        try {
            FileInputStream inputStream = new FileInputStream("src/main/resources/female.txt");
            if (isInFile(name, inputStream)) return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //TODO inputstreem close?
        return false;
    }

    boolean isMaleName(String name) {
        try {
            FileInputStream inputStream = new FileInputStream("src/main/resources/male.txt");
            if (isInFile(name, inputStream)) return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    boolean isInFile(String name, FileInputStream inputStream) {
        Scanner scanner = new Scanner(inputStream, "UTF-8");
        while (scanner.hasNextLine()) {
            if (name.equalsIgnoreCase(scanner.nextLine())) {
                return true;
            }
        }
            scanner.close();
        return false;
    }
}
