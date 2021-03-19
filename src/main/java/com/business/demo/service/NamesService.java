package com.business.demo.service;

import com.business.demo.names_DB.NamesDB;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;

@Service
public class NamesService {

    private final NamesDB namesDB;

    public NamesService(NamesDB namesDB) {
        this.namesDB = namesDB;
    }

    public String getFemaleNames() throws FileNotFoundException {
        return namesDB.getFemaleNames();
    }

    public String getMaleNames() throws FileNotFoundException {
        return namesDB.getMaleNames();
    }
}
