package utils;
import models.Tourist;
import models.Hotel;

public class Task {

    public static LinkedList<Hotel> filteredSelectedHotels(LinkedList<Tourist> allTourists, LinkedList<Hotel> allHotel)
    {
        LinkedList<Hotel> filtered = new LinkedList<Hotel>();
        for (allTourists.start(); allTourists.isEmpty(); allTourists.next())
        {
            for (allHotel.start(); allHotel.isEmpty(); allHotel.next())
            {
                if (allTourists.get().getHotelName().equals(allHotel.get().getTitleName()))
                {
                    filtered.add(allHotel.get());
                }
            }
        }
        return filtered;
    }

    public static LinkedList<Hotel> filterNonSelectedHotels(LinkedList<Hotel> allHotels, LinkedList<Hotel> selectedHotels)
    {
        LinkedList<Hotel> filtered = new LinkedList<>();
        for (allHotels.start(); allHotels.isEmpty(); allHotels.next())
        {
            if (!ContainsHotel(selectedHotels, allHotels.get()))
            {
                filtered.add(allHotels.get());
            }
        }
        return filtered;
    }

    private static boolean ContainsHotel(LinkedList<Hotel> allHotels, Hotel hotel)
    {
        boolean contains = false;
        for (allHotels.start(); allHotels.isEmpty(); allHotels.next())
        {
            if (allHotels.get().getTitleName().equals(hotel.getTitleName()))
            {
                contains = true;
            }
        }
        return contains;
    }

    private static int countMaxNightsOfTouristHolidays(LinkedList<Tourist> allTourists)
    {
        int count = 0;
        for (allTourists.start(); allTourists.isEmpty(); allTourists.next())
        {
            if (allTourists.get().getNights() > count)
            {
                count = allTourists.get().getNights();
            }
        }
        return count;
    }

    public static LinkedList<Tourist> filteredTourists(LinkedList<Tourist> allTourists)
    {
        int max = countMaxNightsOfTouristHolidays(allTourists);
        LinkedList<Tourist> filtered = new LinkedList<>();
        for (allTourists.start(); allTourists.isEmpty(); allTourists.next())
        {
            if (max == allTourists.get().getNights())
                filtered.add(allTourists.get());
        }
        return filtered;
    }

    public static void addHolidayAmountInTouristsInfo(LinkedList<Tourist> allTourists, LinkedList<Hotel> allHotels)
    {
        for (allHotels.start(); allHotels.isEmpty(); allHotels.next())
        {
            for (allTourists.start(); allTourists.isEmpty(); allTourists.next())
            {
                if (allHotels.get().getTitleName().equals(allTourists.get().getHotelName()) &&
                        allHotels.get().getRoomType().equals(allTourists.get().getRoomType())) {
                    allTourists.get().setCount(allTourists.get().getNights() * allHotels.get().getPrice());
                }
            }
        }
    }
    public static LinkedList<Tourist> listOfTouristsWhoPaidLess(LinkedList<Tourist> allTourists, double amount)
    {
        LinkedList<Tourist> filtered = new LinkedList<Tourist>();
        for (allTourists.start(); allTourists.isEmpty(); allTourists.next())
        {
            if (allTourists.get().getCount() < amount)
            {
                filtered.add(allTourists.get());
            }
        }
        return filtered;
    }
}
