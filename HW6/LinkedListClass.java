package HW6;
import java.util.LinkedList;
public class LinkedListClass {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();

// Method siEmpty
        System.out.println("LinkedList list is Empty: " + list.isEmpty()); // result is true

        list.add("add1");
        list.add("add2");
        list.add("add3");
        System.out.println("LinkedList list has elements: " + list); // result is [add1, add2, add3]
//  Method addFirst
        list.addFirst("add0");
        System.out.println("New first element at list is: " + list); // result is [add0, add1, add2, add3]

//  Method addLast
        list.addLast("last element");
        System.out.println("New last element at list is: + " + list); // result is [add0, add1, add2, add3, last element]

//  Method add(index)
        list.add(2, "new element");
        System.out.println("New element at list at index number 2 is: " + list); // result is [add0, add1, new element, add2, add3, last element]

//  Method size
        System.out.println("The size of list is: " + list.size()); // result is 6
    }
}