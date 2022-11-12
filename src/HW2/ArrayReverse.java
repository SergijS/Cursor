package HW2;

import java.util.Arrays;
import java.util.Collections;

public class ArrayReverse {
    public static void main(String[] args) {

        Integer[] array = new Integer[]{2, 3, 1, 7, 11};
        Arrays.sort(array, Collections.reverseOrder());

        System.out.print(Arrays.toString(array));
    }
}