package com.business.demo.nameLists;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class NameLists {

    private String[] maleNames = {"Mateusz", "Karol", "Jan"};
    private String[] femaleNames = {"Karolina", "Maria"};
}
