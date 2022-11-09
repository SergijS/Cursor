package HW2;

import java.util.Arrays;

public class ArrayReverse {
    public static void main(String[] args) {

        int[] array = new int[]{2, 3, 1, 7, 11};

        Arrays.sort(array);
        Arrays.toString(array);

        for (int i = array.length - 1; i >= 0; i--) {
            System.out.print(array[i] + " ");
        }
    }
}