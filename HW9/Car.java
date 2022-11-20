package HW9;

import java.util.*;

public class Car {

    private UUID id;
    private Brand brand;
    private int year;
    private int mileage;
    private int price;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Car(UUID id, Brand brand, int year, int mileage, int price) {
        this.id = id;
        this.brand = brand;
        this.year = year;
        this.mileage = mileage;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", brand=" + brand +
                ", year=" + year +
                ", mileage=" + mileage +
                ", price=" + price +
                '}' + "\n";
    }

    public enum Brand {
        TESLA, AUDI, BMW, TOYOTA, NISSAN;

        public static Brand randomCarGenerator() {
            return values()[(int) (Math.random() * values().length)];
        }
    }

    public static int randomCarYear() {
        int year1 = 2000;
        int year2 = 2022;
        return year1 + (int) Math.round(Math.random() * (year2 - year1));
    }

    public static int randomCarMileage() {
        int mileage1 = 15000;
        int mileage2 = 350000;
        return mileage1 + (int) Math.round(Math.random() * (mileage2 - mileage1));
    }

    public static int randomCarPrice() {
        int price1 = 350000;
        int price2 = 2100000;
        return price1 + (int) Math.round(Math.random() * (price2 - price1));
    }
}