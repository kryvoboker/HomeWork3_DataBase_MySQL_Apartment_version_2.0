package ru.live.kamaz_cs;

public class Flat extends Building {

    public Flat() {
        super();
    }

    public Flat(String district, String adress, double area, int rooms, int price) {
        super(district, adress, area, rooms, price);
    }

    @Override
    public String getDistrict() {
        return super.getDistrict();
    }

    @Override
    public void setDistrict(String district) {
        super.setDistrict(district);
    }

    @Override
    public String getAdress() {
        return super.getAdress();
    }

    @Override
    public void setAdress(String adress) {
        super.setAdress(adress);
    }

    @Override
    public double getArea() {
        return super.getArea();
    }

    @Override
    public void setArea(double area) {
        super.setArea(area);
    }

    @Override
    public int getRooms() {
        return super.getRooms();
    }

    @Override
    public void setRooms(int rooms) {
        super.setRooms(rooms);
    }

    @Override
    public int getPrice() {
        return super.getPrice();
    }

    @Override
    public void setPrice(int price) {
        super.setPrice(price);
    }

}
