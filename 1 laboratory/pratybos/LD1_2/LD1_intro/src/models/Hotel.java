package models;

public class Hotel implements Comparable<Hotel> {
    String titleName;

    public String getTitleName() {
        return titleName;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    String roomType;
    double price;

    public Hotel(){}

    public Hotel(String titleName, String roomType, double price){
        this.titleName = titleName;
        this.roomType = roomType;
        this.price = price;
    }

    @Override
    public String toString(){
        return String.format("%s %s price: %4.2f", titleName, roomType, price);
    }

    @Override
    public boolean equals(Object hotel) {
        return ((Hotel) hotel).titleName.equals(this.titleName);
    }

    @Override
    public int compareTo(Hotel o) {
        return o.titleName.compareTo(this.titleName);
    }
}
