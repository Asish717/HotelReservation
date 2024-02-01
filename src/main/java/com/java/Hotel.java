package com.java;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Hotel {
    public String name;
    public Map<LocalDate, Integer> regularRates=new HashMap<>();
    public Hotel(String name) {
        this.name = name;
    }
    public void addRegularRates(LocalDate date, int rate) {
        regularRates.put(date, rate);
    }
    public int getRegularRates(LocalDate date) {
        return regularRates.get(date);
    }
    public String getName() {
        return name;
    }
}
