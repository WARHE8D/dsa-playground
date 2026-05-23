package linkedlist.problems;

public class CircularQueue {

    public static class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
        }
    }

    public static class MyCircularQueue {

        Node left = new Node(-1);   // dummy head
        Node right = new Node(-1);  // dummy tail

        int size = 0;
        int k;

        public MyCircularQueue(int k) {
            this.k = k;

            left.next = right;
            right.prev = left;
        }

        boolean enQueue(int data) {

            if (isFull()) return false;

            Node newN = new Node(data);

            Node last = right.prev;

            last.next = newN;
            newN.prev = last;

            newN.next = right;
            right.prev = newN;

            size++;
            return true;
        }

        boolean deQueue() {

            if (isEmpty()) return false;

            Node first = left.next;

            left.next = first.next;
            first.next.prev = left;

            first.next = null;
            first.prev = null;

            size--;
            return true;
        }

        int Front() {
            if (isEmpty()) return -1;
            return left.next.data;
        }

        int Rear() {
            if (isEmpty()) return -1;
            return right.prev.data;
        }

        boolean isEmpty() {
            return size == 0;
        }

        boolean isFull() {
            return size == k;
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
