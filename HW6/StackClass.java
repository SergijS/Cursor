package HW6;
import javax.swing.text.TabStop;
import java.util.List;
import java.util.Stack;
public class StackClass {
    public static void main(String[] args) {

        Stack<String> stack_str = new Stack<>();

// Method Empty
        System.out.println("Stack stack_str is Empty: " + stack_str.empty()); // result is true

// Method push
        stack_str.push("push_1");
        stack_str.push("push_2");
        stack_str.push("push_3");

        System.out.println("Stack stack_str with added elements: " + stack_str); // result is [push_1, push_2, push_3]

// Method pop
        System.out.println("Stack stack_str Removes the object at the top of this stack (LIFO): ");
        while(!stack_str.isEmpty()) {
            System.out.println(stack_str.pop() + " ");
        }// result is [push_3, push_2, push_1]

// Method size
        System.out.println("Stack length is: " + stack_str.size()); // result is 2
    }
}