package HW5;
public class MainForMyList {
    public static void main(String[] args) {

        MyList<Integer> list = new MyList<>();

            list.add(11);
            list.add(142);
            list.add(17);
            list.add(-7);
            list.add(34);
            list.add(18);
            list.add(41);

        System.out.println(list);
        System.out.println("The largest array's element is " + list.largest());
        System.out.println("The smallest array's element is " + list.smallest());
    }
}