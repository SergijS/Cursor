package HW9;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static HW9.Car.Brand.AUDI;
import static HW9.Car.Brand.TESLA;

public class MainCar {
    public static void main(String[] args) {
        List<Car> cars = Arrays.asList(
                new Car(UUID.randomUUID(), Car.Brand.RandomCarGenerator(), 2018, 122547, 301125),
                new Car(UUID.randomUUID(), Car.Brand.RandomCarGenerator(), 2015, 39878, 456987),
                new Car(UUID.randomUUID(), Car.Brand.RandomCarGenerator(), 2021, 38054, 521454),
                new Car(UUID.randomUUID(), Car.Brand.RandomCarGenerator(), 2022, 25400, 787454),
                new Car(UUID.randomUUID(), Car.Brand.RandomCarGenerator(), 2014, 225478, 311254)
        );

        List<Car> filterTeslaAudi = cars.stream()
                .filter(car -> car.getBrand() == TESLA || car.getBrand() == AUDI)
                .collect(Collectors.toList());
        System.out.println("Only TESLA and AUDI cars");
        System.out.println(filterTeslaAudi);

        List<Car> carsYounger2018 = cars.stream()
                .filter(car -> car.getYear() > 2018)
                .collect(Collectors.toList());
        System.out.println("Cars younger 2018");
        System.out.println(carsYounger2018);

        List<Car> mileageLess = cars.stream()
                .filter(car -> car.getMileage() < 40000)
                .collect(Collectors.toList());
        System.out.println("Mileage less than 40000");
        System.out.println(mileageLess);

        List<Car> sortInReverseOrder = cars.stream()
                .sorted(Comparator.comparing(Car::getPrice).reversed())
                .collect(Collectors.toList());
        System.out.println("Sorted by price");
        System.out.println(sortInReverseOrder);

        Map<UUID, Car> newMap = cars.stream()
                .sorted(Comparator.comparing(Car::getPrice))
                .limit(3)
                .collect(Collectors.toMap(Car::getId, Function.identity()));
        System.out.println("Three cheepest avto (Map)");
        System.out.println(newMap);
    }
}