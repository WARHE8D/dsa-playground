package linkedlist.problems;

//Given the head of a linked list and an integer val,
// remove all the nodes of the linked list that
// has Node.val == val, and return the new head.
public class RemoveElements {
    public static class Node{
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
    public static Node arrayToList(int[] arr){
        Node n = new Node(arr[0]);
        Node temp = n;
        for(int i=1;i<arr.length;i++){
            temp.next = new Node(arr[i]);
            temp = temp.next;
        }
        return n;
    }

    public static void traverseLL(Node n){
        if(n==null) return;
        StringBuilder sb = new StringBuilder();
        while(n!=null){
            sb.append(n.data).append(" ");
            n=n.next;//impt
        }
        System.out.println(sb);
    }

    private static Node removeElement(Node n, int i) {

        if(n==null) return null;
        while(n!=null && n.data==i){
            n=n.next;//removes head if = i
        }

        Node current = n;
        Node prev = null;
        while(current!=null){

            if(current.data == i){
                prev.next = current.next;
            }else{
                prev = current;
            }
            current = current.next;
        }

        return n;
    }


    public static void main(String[] args) {

        int[] arr = {1,2,2,2,4,3,4,6,3,12,1,4};
        Node n = arrayToList(arr);
        traverseLL(n);
        Node rmEl = removeElement(n,2);
        traverseLL(rmEl);
    }

}
