package HW7;

import java.util.HashMap;
import java.util.Map;

public class NumberCount {
    public static void main(String[] args) {
        MainString str = new MainString();
        HashMap<Character, Integer> hashMap = new HashMap<>();
        char[] CharArray = str.toCharArray();
        int count = 0;

        for (char ch : CharArray) {
            if (ch == '0' || ch == '1' || ch == '2' || ch == '3' || ch == '4' || ch == '5' || ch == '6' || ch == '7' || ch == '8' || ch == '9') {
                count += 1;
                if (hashMap.containsKey(ch)) {
                    hashMap.put(ch, hashMap.get(ch) + 1);
                } else {
                    hashMap.put(ch, 1);
                }
            }
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            System.out.println("Number in the text " + entry.getKey() + " = " + entry.getValue());
        }
        System.out.println("Sum of punktuations marks = " + count);
    }
}