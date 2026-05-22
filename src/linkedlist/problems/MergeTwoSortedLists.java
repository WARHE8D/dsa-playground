package linkedlist.problems;

public class MergeTwoSortedLists {

    public static class Node{
        int data;
        Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node arrayToLL(int[] arr){
        if(arr==null || arr.length==0) return null;

        Node n = new Node(arr[0]);
        Node temp = n;
        for(int i=1;i<arr.length;i++){
            temp.next = new Node(arr[i]);
            temp=temp.next;
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

    public static void main (String[] args){
        int[] arr1 = {1,2,4,6};
        int[] arr2 = {1,4,5,7,8};
        Node n1 = arrayToLL(arr1);
        TraverseLL(n1);

        Node n2 = arrayToLL(arr2);
        TraverseLL(n2);

        Node mergeSortLL = mergeSortedLinkedLists(n1,n2);
        TraverseLL(mergeSortLL);
    }

    private static Node mergeSortedLinkedLists(Node n1, Node n2) {
        if(n1==null) return n2;//n2 already sorted
        if(n2==null) return n1;//n1 already sorted

        Node dump = new Node(0);
        Node mover = dump;
        while(n1!=null && n2!=null){
            if(n1.data<n2.data){
                mover.next = n1;
                n1=n1.next;
            }else{
                mover.next = n2;
                n2 = n2.next;
            }
            mover=mover.next;
        }
        //merge the left out list
        if(n1!=null){
            mover.next = n1;
        }else mover.next = n2;

        return dump.next;
    }
}
