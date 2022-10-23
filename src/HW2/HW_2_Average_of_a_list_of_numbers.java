package HW2;
public class HW_2_Average_of_a_list_of_numbers {
    public static void main(String[] args) {

        int [] array3 = new int[] {3, 5, 17, 25, 11};
        int averange = 0;
        for (int i:array3){
            averange += i;
        }
        System.out.println((double)averange / array3.length);
    }
}