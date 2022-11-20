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
                new Car(UUID.randomUUID(), Car.Brand.randomCarGenerator(), Car.randomCarYear(), Car.randomCarMileage(), Car.randomCarPrice()),
                new Car(UUID.randomUUID(), Car.Brand.randomCarGenerator(), Car.randomCarYear(), Car.randomCarMileage(), Car.randomCarPrice()),
                new Car(UUID.randomUUID(), Car.Brand.randomCarGenerator(), Car.randomCarYear(), Car.randomCarMileage(), Car.randomCarPrice()),
                new Car(UUID.randomUUID(), Car.Brand.randomCarGenerator(), Car.randomCarYear(), Car.randomCarMileage(), Car.randomCarPrice()),
                new Car(UUID.randomUUID(), Car.Brand.randomCarGenerator(), Car.randomCarYear(), Car.randomCarMileage(), Car.randomCarPrice())
        );


        List<Car> filterTeslaAudi = cars.stream()
                .filter(car -> car.getBrand().equals(TESLA) || car.getBrand().equals(AUDI))
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