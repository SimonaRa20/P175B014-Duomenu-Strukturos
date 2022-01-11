package com.company;

import models.Hotel;
import models.Tourist;
import utils.DataReader;
import utils.LinkedList;
import utils.List;
import utils.Task;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        String filePathTourists ="U17a.txt";
        String filePathHotels ="U17b.txt";


        LinkedList<Tourist> tourists_arr = new LinkedList<Tourist>();
        LinkedList<Hotel> hotels_arr = new LinkedList<Hotel>();

        DataReader.readFromFileTourist(filePathTourists, tourists_arr);
        DataReader.readFromFileHotel(filePathHotels, hotels_arr);

        System.out.println("============Starting data============");
        System.out.println();
        performTourist(tourists_arr);
        System.out.println();
        performHotel(hotels_arr);

        System.out.println();
        System.out.println("==============Result data============");
        System.out.println();
        LinkedList<Hotel> selectedHotels = utils.Task.filteredSelectedHotels(tourists_arr,hotels_arr);
        selectedHotels.filterDuplicate();
        performSelectedHotel(selectedHotels);

        System.out.println();
        LinkedList<Hotel> nonSelectedHotels = utils.Task.filterNonSelectedHotels(hotels_arr, selectedHotels);
        nonSelectedHotels.filterDuplicate();
        performNonSelectedHotel(nonSelectedHotels);

        System.out.println();
        LinkedList<Tourist> spendMaxNightsTouristsList = utils.Task.filteredTourists(tourists_arr);
        performMaxNightsTourists(spendMaxNightsTouristsList);

        System.out.println();
        System.out.println("Enter the price for hotel:");
        Scanner scanner = new Scanner(System.in);
        double price = scanner.nextDouble();
        Task.addHolidayAmountInTouristsInfo(tourists_arr,hotels_arr);
        LinkedList<Tourist> filterByPrice = Task.listOfTouristsWhoPaidLess(tourists_arr,price);
        filterByPrice.sort();
        performByPriceTourists(filterByPrice);
    }

    private static void performTourist(List<Tourist> tourists) {
        System.out.println("Starting tourist list:");

        for(Tourist tourist: tourists){
            System.out.println(tourist);
        }
    }

    private static void performHotel(List<Hotel> hotels) {
        System.out.println("Starting hotel list:");

        for(Hotel hotel: hotels){
            System.out.println(hotel);
        }
    }

    private static void performSelectedHotel(List<Hotel> hotels) {
        System.out.println("Selected hotel list:");

        for(Hotel hotel: hotels){
            System.out.println(hotel);
        }
    }

    private static void performNonSelectedHotel(List<Hotel> hotels) {
        System.out.println("Non selected hotel list:");

        for(Hotel hotel: hotels){
            System.out.println(hotel);
        }
    }

    private static void performMaxNightsTourists(List<Tourist> tourists) {
        System.out.println("Max nights spend tourists:");

        for(Tourist tourist: tourists){
            System.out.println(tourist);
        }
    }
    private static void performByPriceTourists(List<Tourist> tourists) {
        System.out.println("By spend money tourists:");

        for(Tourist tourist: tourists){
            System.out.println(tourist);
        }
    }
}
