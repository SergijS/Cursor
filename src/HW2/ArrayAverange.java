package HW2;

public class ArrayAverange {
    public static void main(String[] args) {

        int[] array3 = new int[]{3, 5, 17, 25, 11};
        int averange = 0;
        for (int i : array3) {
            averange += i;
        }
        System.out.println((double) averange / array3.length);
    }
}