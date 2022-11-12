package Avto;

public class FirmsWorkers extends Owner {
    private String position;

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public void hello() {
        System.out.println("Hello FirmsWorker!" + '\n' +
                "Position: " + position + '\n' +
                "FirstName: " + firstName + '\n' +
                "LastName: " + lastName + '\n' +
                "Age:" + age);
    }
}