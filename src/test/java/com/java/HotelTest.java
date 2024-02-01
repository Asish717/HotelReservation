package com.java;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class HotelTest {
    @Test
    public void testHotelName(){
        Hotel hotel1 = new Hotel("Lakewood");
        Assert.assertEquals("Lakewood", hotel1.getName());
    }
    @Test
    public void testRate(){
        Hotel hotel1 = new Hotel("Lakewood");
        hotel1.addRegularRates(LocalDate.of(2023, 12, 5), 560);
        Assert.assertEquals(560, hotel1.getRegularRates(LocalDate.of(2023, 12,5)));
    }
    @Test
    public void testHotels(){
        Hotel hotel1 = new Hotel("Lakewood");
        Hotel hotel2 = new Hotel("Redwood");
        HotelReservation hotelReservation = new HotelReservation();
        hotelReservation.addHotel(hotel1);
        hotelReservation.addHotel(hotel2);
        Assert.assertEquals(2, hotelReservation.getHotel().size());
    }
}
