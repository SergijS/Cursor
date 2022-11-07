package HW6;
import java.util.*;
public class QueueClass {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();

// Method isEmpty
        System.out.println("Queue queue is Empty: " + queue.isEmpty()); // result is true

// Method enqueue
        queue.add("queue_1");
        queue.add("queue_2");
        queue.add("queue_3");

        System.out.println(queue); // result is [queue_1, queue_2, queue_3]
// Method size
        System.out.println("Size of queue is: " + queue.size() + " elements"); // result is 3
// Method dequeue
        System.out.println("Removed objects (Princip FIFO): ");
        while (!queue.isEmpty()) {
            System.out.println(queue.remove() + " "); // result is queue_1, queue_2, queue_3
        }
    }
}