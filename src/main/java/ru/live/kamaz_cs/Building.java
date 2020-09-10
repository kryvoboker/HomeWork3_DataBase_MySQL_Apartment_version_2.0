package ru.live.kamaz_cs;

public class Building {

    private String district;
    private String adress;
    private double area;
    private int rooms;
    private int price;

    public Building() {
    }

    public Building(String district, String adress, double area, int rooms, int price) {
        this.district = district;
        this.adress = adress;
        this.area = area;
        this.rooms = rooms;
        this.price = price;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
