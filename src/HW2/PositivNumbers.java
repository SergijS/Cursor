package HW2;

public class PositivNumbers {
    public static void main(String[] args) {

        int[] array2 = new int[]{5, 7, -14, 18, 3, -4, 21};
        int sum = 0;

        for (int i : array2) {
            if (array2.length == 0) {
                System.out.println(sum);
            } else if (i > 0) {
                sum += i;
            }
        }
        System.out.println(sum);
    }
}