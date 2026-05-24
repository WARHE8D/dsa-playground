package linkedlist.problems;

import javax.management.openmbean.ArrayType;
import java.util.ArrayList;
import java.util.List;

public class CircularQueue {

    static class MyCircularQueue {

        ArrayList<Integer> node;
        int size=0;
        int k;
        public MyCircularQueue(int k) {
            this.node = new ArrayList<>();
            this.k=k;
        }

        public boolean enQueue(int value) {
            if(isFull()) return false;
            node.add(value);
            size++;
            return true;
        }

        public boolean deQueue() {
            if(isEmpty()) return  false;
            node.removeFirst();
            size--;
            return true;
        }

        public int Front() {
            if(isEmpty()) return -1;
            return node.getFirst();
        }

        public int Rear() {
            if(isEmpty()) return -1;
            return node.getLast();
        }

        public boolean isEmpty() {
            return node.isEmpty();
        }

        public boolean isFull() {
            return k == size;
        }
    }

    public static void main(String[] args) {

        MyCircularQueue q = new MyCircularQueue(3);

        System.out.println(q.enQueue(1));
        System.out.println(q.enQueue(2));
        System.out.println(q.enQueue(3));
        System.out.println(q.enQueue(4)); // false

        System.out.println(q.Rear());   // 3
        System.out.println(q.isFull()); // true

        System.out.println(q.deQueue());

        System.out.println(q.enQueue(4));

        System.out.println(q.Rear()); // 4
        System.out.println(q.Front()); // 2
    }
}
