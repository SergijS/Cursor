package HW7;

import java.util.HashMap;
import java.util.Map;

public class CountOccurrences {
    public static void main(String[] args) {
        MainString str = new MainString();
        HashMap<Character, Integer> hashMap = new HashMap<>();
        char[] CharArray = str.toCharArray();
        int count = 0;

        for (char ch : CharArray) {
            if (ch != ' ' && ch != '.' && ch != ',' && ch != '\n' && ch != '“' && ch != '!' && ch != ':') {
                if (hashMap.containsKey(ch)) {
                    hashMap.put(ch, hashMap.get(ch) + 1);
                } else {
                    hashMap.put(ch, 1);
                }
            }
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            System.out.println("Occurrences of " + entry.getKey() + " = " + entry.getValue());
        }
    }
}