package com.java;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

interface HotelReservationInterface {
    void addHotel(Hotel hotel);
    String findCheapestHotel(LocalDate startDate, LocalDate endDate);
    String findCheapestHotelByRating(LocalDate startDate, LocalDate endDate);
    Hotel findBestRatedHotel(LocalDate startDate, LocalDate endDate);

    String findCheapestBestRatedHotelForRewardCustomer(LocalDate startDate, LocalDate endDate);

}
public class HotelReservation implements HotelReservationInterface{
    private List<Hotel> hotels;

    public HotelReservation() {
        this.hotels = new ArrayList<>();
    }

    @Override
    public void addHotel(Hotel hotel) {
        hotels.add(hotel);
    }

    @Override

    public String findCheapestHotel(LocalDate startDate, LocalDate endDate) {
        return hotels.stream()
                .map(hotel -> hotel.getName() + ", Total Rates: $" +
                        calculateTotalHotelCost(hotel, startDate, endDate))
                .min(Comparator.comparingInt(s -> Integer.parseInt(s.split("Total Rates: \\$")[1])))
                .orElse("No Hotels Available");
    }

    @Override
    public String findCheapestHotelByRating(LocalDate startDate, LocalDate endDate) {
        return hotels.stream()
                .max(Comparator.comparing(Hotel::getRating).thenComparingInt(hotel -> calculateTotalHotelCost(hotel, startDate, endDate)))
                .map(hotel -> hotel.getName()+", Total Rates: $"+calculateTotalHotelCost(hotel, startDate, endDate))
                .orElse("No Hotels Available");
    }

    @Override
    public Hotel findBestRatedHotel(LocalDate startDate, LocalDate endDate) {
        return hotels.stream()
                .max(Comparator.comparing(hotel -> hotel.getRating()))
                .orElse(null);
    }

    @Override
    public String findCheapestBestRatedHotelForRewardCustomer(LocalDate startDate, LocalDate endDate){
        return hotels.stream()
                .max(Comparator.comparing(Hotel::getRating).thenComparingInt(hotel -> calculateTotalHotelCostForRewardCustomer(hotel, startDate, endDate)))
                .map(hotel -> hotel.getName()+" Total Rates: $"+calculateTotalHotelCostForRewardCustomer(hotel, startDate, endDate))
                .orElse("No Hotels Available");
    }

    private int calculateTotalHotelCost(Hotel hotel, LocalDate startDate, LocalDate endDate) {
        if (hotel == null) {
            return 0;
        }

        return (int) startDate.datesUntil(endDate.plusDays(1))
                .map(date -> hotel.getRates(date))
                .filter(Objects::nonNull)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public int calculateTotalHotelCostForRewardCustomer(Hotel hotel, LocalDate startDate, LocalDate endDate) {
        return (int) startDate.datesUntil(endDate.plusDays(1))
                .mapToInt(date -> hotel.getSpecialRates(date))
                .sum();
    }
}
