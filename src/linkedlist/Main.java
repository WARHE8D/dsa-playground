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
            Node element = new Node(arr[i]);
            ptr.next = element;
            ptr = element;
        }
        return head;
    }


//    public static void printLinkedList(Node node){
//        while(node.next==null){
//            System.out.println(node.data);
//        }
//    }

    public static void TraverseLL(Node n){
        if(n==null) return;
        StringBuilder sb = new StringBuilder();
        while(n.next!=null){
            sb.append(n.data).append(" ");
            n=n.next;//impt
        }
        System.out.println(sb);
    }


    public static Node SearchLL(Node n, int target){
        if(n==null) return null;

        while(n.next!=null){
            if(n.data==target) return n;
            n=n.next;
        }
        return null;
    }


    public static void main(String[] args) {
        System.out.println("test");
        Node firstNode = new Node(12);
        Node secondNode = new Node(13,firstNode);
        System.out.println(secondNode.data+" "+secondNode.next.data);

        //array to LL
        int[] arr = {1,5,3,6,3,4,6};
        Node n = ArrayToLinkedList(arr);
        System.out.println(n != null ? n.data : null);

//        TraverseLL(n);
        Node target = SearchLL(n,4);
        System.out.println(target != null ? "Search: "+target.data : 0);
    }
}
