package Avto;

public class CarOwner extends Owner{

    @Override
    public void hello() {
        System.out.println("Hello CarOwner, how are you?");
    }

    public void printCarOwner(){
        System.out.println("Firstname: " + firstName + "\n" + "Lastname: " + lastName + "\n" + "Age: " + age);
    }
}
