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
        return new Random().nextInt(2000, 2022);
    }

    public static int randomCarMileage() {
        return new Random().nextInt(15000, 350000);
    }

    public static int randomCarPrice() {
        return new Random().nextInt(350000, 2100000);
    }
}