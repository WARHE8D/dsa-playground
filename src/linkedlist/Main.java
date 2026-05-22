package linkedlist;

public class Main {

    //To create Node Object
    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
        Node(int data,Node next){
            this.data = data;
            this.next = next;
        }
    }

    public static Node ArrayToLinkedList(int[] arr){
        if(arr.length == 0) return null;
        Node head = new Node(arr[0]);
        Node ptr = head;
        for(int i =1; i<arr.length;i++){
            ptr.next = new Node(arr[i]);
        }
        return head;
    }


//    public static void printLinkedList(Node node){
//        while(node.next==null){
//            System.out.println(node.data);
//        }
//    }




    public static void main(String[] args) {
        System.out.println("test");
        Node firstNode = new Node(12);
        Node secondNode = new Node(13,firstNode);
        System.out.println(secondNode.data+" "+secondNode.next.data);

        //array to LL
        int[] arr = {1,5,3,6,3,4,6};
        Node n = ArrayToLinkedList(arr);
        System.out.println(n != null ? n.data : null);
    }
}
