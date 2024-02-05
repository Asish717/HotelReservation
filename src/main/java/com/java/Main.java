package com.java;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args){
        Hotel hotel1 = new Hotel("Lakewood");
        hotel1.addRates(LocalDate.of(2023, 12, 1), 560);
        hotel1.addRates(LocalDate.of(2023, 12, 2), 570);
        hotel1.setRating(5);

        Hotel hotel2 = new Hotel("Bridgewood");
        hotel2.addRates(LocalDate.of(2023, 12, 1), 600);
        hotel2.addRates(LocalDate.of(2023, 12, 2), 600);
        hotel2.setRating(5);

        Hotel hotel3 = new Hotel("Redwood");
        hotel3.addRates(LocalDate.of(2023, 12, 1), 520);
        hotel3.addRates(LocalDate.of(2023, 12, 2), 530);
        hotel3.setRating(4);

        HotelReservation hotelReservation = new HotelReservation();

        hotelReservation.addHotel(hotel1);
        hotelReservation.addHotel(hotel2);
        hotelReservation.addHotel(hotel3);

        System.out.println(hotelReservation.findBestRatedHotel(LocalDate.of(2023, 12, 1), LocalDate.of(2023, 12, 2)));
    }
}
