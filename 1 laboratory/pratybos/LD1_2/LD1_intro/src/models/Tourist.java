package models;

public class Tourist implements Comparable<Tourist> {
    String lastName;

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    String firstName;

    public int getNights() {
        return nights;
    }

    public void setNights(int nights) {
        this.nights = nights;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    String hotelName;
    String roomType;
    int nights;

    public double getCount() {
        return count;
    }

    public void setCount(double count) {
        this.count = count;
    }

    double count;

    public Tourist(String line, String s, String line1, int i){}

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Tourist(String lastName, String firstName, String hotelName, String roomType, int nights){
        this.lastName = lastName;
        this.firstName = firstName;
        this.hotelName = hotelName;
        this.roomType = roomType;
        this.nights = nights;
    }

    @Override
    public String toString(){
        return String.format("%s %s %s %s nights: %d",lastName, firstName, hotelName, roomType, nights);
    }

    @Override
    public boolean equals(Object tourist) {
        return ((Tourist) tourist).firstName.equals(this.firstName) && ((Tourist) tourist).lastName.equals(this.lastName);
    }
    @Override
    public int compareTo(Tourist tourist)
    {
        if (tourist.lastName.compareTo(this.lastName) > 0)
        {
            return -1;
        }
        else if(tourist.firstName.compareTo(this.firstName) < 0)
        {
            return 1;
        }
        return 0;
    }
}
