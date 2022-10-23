package HW2;

public class HW_2_Replace_all_duplicated_values {
    public static void main(String[] args) {

        int [] array4 = new int [] {5, 5, 6, 7, 7, 8, 9, 8};

        for (int i = 0; i < array4.length; i++){
            for (int j = i + 1; j < array4.length; j++){
                if (array4[i] == array4[j]){
                    array4[j] = 0;
                }
            }
            System.out.print(array4[i] + " ");
        }
    }
}