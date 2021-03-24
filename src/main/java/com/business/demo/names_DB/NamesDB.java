package com.business.demo.names_DB;

import com.business.demo.Sex;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.InputStreamReader;
import java.util.Scanner;

@Data
@Component
@Slf4j
public class NamesDB {

    public String getFemaleNames() {
        try {
            Scanner scanner = new Scanner(
                    new InputStreamReader(getClass().getResourceAsStream("/female.txt")));
            return getNames(scanner);
        } catch (Exception e) {
            log.error("Problem with female.txt");
            e.printStackTrace();
            return "Problem with female.txt";
        }
    }

    public String getMaleNames() {
        try {
            Scanner scanner = new Scanner(
                    new InputStreamReader(getClass().getResourceAsStream("/male.txt")));
            return getNames(scanner);
        } catch (Exception e) {
            log.error("Problem with male.txt");
            e.printStackTrace();
            return "Problem with male.txt";
        }
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
            return Sex.MALE;
        } else if (isFemaleName(inputName)) {
            return Sex.FEMALE;
        } else {
            return Sex.INCONCLUSIVE;
        }
    }

    boolean isFemaleName(String name) {
        try {
            InputStreamReader inputStream = new InputStreamReader(getClass().getResourceAsStream("/female.txt"));
            if (isInFile(name, inputStream)) return true;
        } catch (Exception e) {
            log.error("Problem with female.txt");
            e.printStackTrace();
        }
        return false;
    }

    boolean isMaleName(String name) {
        try {
            InputStreamReader inputStream = new InputStreamReader(getClass().getResourceAsStream("/male.txt"));
            if (isInFile(name, inputStream)) return true;
        } catch (Exception e) {
            log.error("Problem with male.txt");
            e.printStackTrace();
        }
        return false;
    }

    boolean isInFile(String name, InputStreamReader inputStream) {
        Scanner scanner = new Scanner(inputStream);
        while (scanner.hasNextLine()) {
            if (name.equalsIgnoreCase(scanner.nextLine())) {
                return true;
            }
        }
        scanner.close();
        return false;
    }
}
