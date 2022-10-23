package HW1;
public class Homework1 {
    public static void main(String[] args) {
        byte a = 25;
        byte b = 35;
        byte resByte = (byte) (a + b); // 8-bit byte from -128 to 127

        short c = 11254;
        short d = 15145;
        short resShort = (short) (d - c); // 16-bit short from -32,768 to 32,767

        int e = 124;
        int f = 15;
        int resInt = e * f; // 32-bit int from -2,147,483,648 to 2,147,483,647

        long g =2125478987465447l;
        long h =5545874545478987l;
        long resLong = (long) (g + h); // 64-bit long from -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807

        float i = 125.5f;
        float j = 35.5f;
        float resFloat = i / j; // 32-bit recommend for byte and short

        double k = 1225.232548778789;
        double l = 1125.232545587889;
        double resDouble = k * l;

        System.out.println("byte: " + resByte);
        System.out.println("short: " + resShort);
        System.out.println("int: " + resInt);
        System.out.println("long: " + resLong);
        System.out.println("float: " + resFloat);
        System.out.println("double: " + resDouble);
    }
}
