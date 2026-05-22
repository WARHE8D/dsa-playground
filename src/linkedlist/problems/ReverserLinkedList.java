package linkedlist.problems;

//Given the beginning of a singly linked list head, reverse the list,
//and return the new beginning of the list.

public class ReverserLinkedList {

    public static class Node{
        int data;
        Node next;

        public Node(int data, Node next) {
            this.data = data;                      
            this.next = next;                      
        }                      
        public Node(int data){                      
            this.data = data;
            this.next = null;
        }
    }

    public static Node arrayToLL(int[] arr){
        if(arr==null || arr.length==0) return null;
        Node n = new Node(arr[0]);
        Node temp = n;
        for(int i=1; i<arr.length;i++){
            temp.next = new Node(arr[i]);
            temp = temp.next;
        }
        return n;
    }

    public static void TraverseLL(Node n){
        if(n==null) return;
        StringBuilder sb = new StringBuilder();
        while(n!=null){
            sb.append(n.data).append(" ");
            n=n.next;//impt
        }
        System.out.println(sb);
    }

    public static void main(String[] args){

        int[] arr = {1,2,4,5,21,12};
        Node n = arrayToLL(arr);
        TraverseLL(n);

        Node rev = reverseLL(n);
        TraverseLL(rev);
    }

    private static Node reverseLL(Node n) {
        if(n==null) return null;
        if(n.next==null) return n;

        Node current = n;
        Node prev = null;

        //think i got an extra curve on my brain
        while(current!=null){
            Node temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        return prev;
    }
}
