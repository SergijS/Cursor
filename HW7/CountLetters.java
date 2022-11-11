package HW7;

public class CountLetters {
    public static void main(String[] args) {
        MainString str = new MainString();
        int count = 0;

        char[] CharArray = str.toCharArray();

        for (char ch : CharArray) {
            if (ch != ' ' && ch != '.' && ch != ',' && ch != '\n' && ch != '“' && ch != '!' && ch != ':') {
                count += 1;
            }
        }
        System.out.println(count + " letters in the text");
    }
}