package Avto;

public abstract class Owner implements NameInfo{
    public String firstName;
    public String lastName;
    public int age;

    public void getNameInfo(){
        System.out.println("Firstname is " + this.firstName);
    }
    public abstract void hello();






}
