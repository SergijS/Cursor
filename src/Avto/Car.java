package Avto;

public class Car implements NameInfo {
    private String carBrand;
    private String color;
    private double maxSpeed;

    public void getNameInfo() {
        System.out.println("Car brand is " + this.carBrand);
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public String getColor() {
        return color;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

   public void hello(FirmsWorkers firmsWorkers) {
        System.out.println("Hello firmsWorkers, how are you?");
    }

    public void hello(Shareholders shareholders) {
        System.out.println("Hello shareholders, how are you?");
    }

    @Override
    public String toString() {
        return "Car{" +
                "carBrand='" + carBrand + '\'' +
                ", color='" + color + '\'' +
                ", maxSpeed=" + maxSpeed + '}';
    }
}