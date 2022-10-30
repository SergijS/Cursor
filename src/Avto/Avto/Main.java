package Avto;

public class Main {
    public static void main(String[] args) {

        FirmsWorkers firmsWorkers = new FirmsWorkers();
        firmsWorkers.firstName = "Sam";
        firmsWorkers.setPosition("Seller");
        firmsWorkers.age = 43;

        Shareholders shareholders = new Shareholders();
        shareholders.firstName = "Alex";
        shareholders.lastName = "Bevs";
        shareholders.setEquityShare(34.72);

        CarOwner owner = new CarOwner();
        owner.firstName = "Max";
        owner.lastName = "Staton";
        owner.age = 25;
        owner.printCarOwner();

        Car car = new Car();
        car.setCarBrand("Suzuki");
        car.setColor("Red");
        car.setMaxSpeed(450.50);

        Car car2 = new Car();
        car.setCarBrand("Mazda");
        car.setColor("Grey");
        car.setMaxSpeed(490.40);

        car.carOwner(owner);
        car2.carOwner(owner);

        owner.hello();

        System.out.println("Owner has "+ Car.ownerHasCars + " cars");
    }
}