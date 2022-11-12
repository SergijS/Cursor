package Avto;

public class Main {
    public static void main(String[] args) {

        FirmsWorkers firmsWorkers = new FirmsWorkers();
        firmsWorkers.firstName = "Sam";
        firmsWorkers.lastName = "Braxton";
        firmsWorkers.setPosition("Seller");
        firmsWorkers.age = 43;

        Shareholders shareholders = new Shareholders();
        shareholders.firstName = "Alex";
        shareholders.lastName = "Bevs";
        shareholders.setEquityShare(34.72);

        Car car = new Car();
        car.setCarBrand("Suzuki");
        car.setColor("Red");
        car.setMaxSpeed(450.50);

        Car car2 = new Car();
        car.setCarBrand("Mazda");
        car.setColor("Grey");
        car.setMaxSpeed(490.40);

        firmsWorkers.hello();
        shareholders.hello();

    }
}