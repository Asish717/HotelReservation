package com.java;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Hotel {
    public String name;
    public int rating;
    public Map<LocalDate, Integer> weekdayRate= new HashMap<>();
    public Map<LocalDate, Integer> regularRates= new HashMap<>();
    public Map<LocalDate, Integer> weekendRate= new HashMap<>();
    public Map<LocalDate, Integer> specialWeekDayRate= new HashMap<>();
    public Map<LocalDate, Integer> specialWeekendRate= new HashMap<>();

    public Hotel(String name) {
        this.name = name;
        this.rating = 0;
    }

    public void addRates(LocalDate date, int rate) {

        boolean isWeekend = date.getDayOfWeek() == DayOfWeek.SUNDAY || date.getDayOfWeek() == DayOfWeek.SATURDAY;
        if (isWeekend) {
            weekendRate.put(date, rate);
        } else {
            weekdayRate.put(date, rate);
        }
    }

    public void addRates(LocalDate date, int rate, boolean isSpecial){
        boolean isWeekend = date.getDayOfWeek() == DayOfWeek.SUNDAY || date.getDayOfWeek() == DayOfWeek.SATURDAY;
        if(isWeekend){
            (isSpecial? specialWeekendRate: weekendRate).put(date, rate);
        }
        else{
            (isSpecial? specialWeekDayRate: weekdayRate).put(date, rate);
        }
    }

    public void addSpecialRates(LocalDate date, int rate){
        addRates(date, rate, true);
    }

    public int getRates(LocalDate date) {
        boolean isWeekend = date.getDayOfWeek() == DayOfWeek.SUNDAY || date.getDayOfWeek() == DayOfWeek.SATURDAY;
        Map<LocalDate, Integer> rates = isWeekend? weekendRate: weekdayRate;
        return rates.get(date);
    }

    public int getSpecialRates(LocalDate date) {
        boolean isWeekend = date.getDayOfWeek() == DayOfWeek.SUNDAY || date.getDayOfWeek() == DayOfWeek.SATURDAY;
        Map<LocalDate, Integer> rates = isWeekend? specialWeekendRate: specialWeekDayRate;
        return rates.get(date);
    }

    public void addRegularRates(LocalDate date, int rate) {
        regularRates.put(date, rate);
    }

    public int getRegularRates(LocalDate date) {
        return regularRates.get(date);
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = Math.max(1, Math.min(5, rating));
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "name='" + name + '\'' +
                ", rating=" + rating +
                '}';
    }
}
