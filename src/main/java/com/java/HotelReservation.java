package com.java;

import java.util.ArrayList;
import java.util.List;

public class HotelReservation {
    public List<Hotel>hotels=new ArrayList<>();
    public void addHotel(Hotel hotel) {
        hotels.add(hotel);
    }
    public List<Hotel>getHotel(){
        return hotels;
    }
}
