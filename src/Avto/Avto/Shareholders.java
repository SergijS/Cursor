package Avto;

public class Shareholders extends Owner{
    private double equityShare;

    public double getEquityShare() {
        return equityShare;
    }
    public void setEquityShare(double equityShare) {
        this.equityShare = equityShare;
    }
    @Override
    public void hello() {
       System.out.println("Hello Shareholders, how are you?");
    }
}