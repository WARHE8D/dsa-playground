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
        while(n!=null){
            sb.append(n.data).append(" ");
            n=n.next;//impt
        }
        System.out.println(sb);
    }

    public static int LLSize(Node n){
        int count = 0;
        while(n!=null){
            n=n.next;//impt
            count++;
        }
        return count;
    }


    public static Node SearchLL(Node n, int target){
        if(n==null) return null;

        while(n.next!=null){
            if(n.data==target) return n;
            n=n.next;
        }
        return null;
    }

    //Insert Head
    public static Node InsertHead(Node n,int val){
        return new Node(val,n);//new Node(new value, ptr to next node)
    }

    public static Node InsertTail(Node n,int val){
        if(n==null) return null;
        Node mover = n;
        while(mover.next!=null){
            mover = mover.next;
        }
        mover.next = new Node(val);
        return n;
    }


    //Delete LL Head
    // returning n.next moves the head to the second node,
    // making the first node unreachable and eligible for 'garbage collection'
    public static Node DeleteHead(Node n){
        if(n==null || n.next==null) return null;
        return n.next;
    }

    //delete tail
    public static Node DeleteTail(Node n){
        if(n==null || n.next == null) return null;

        // mover is used only for traversal so the head pointer 'n' remains unchanged
        Node mover = n;
        while(mover.next.next != null){// scans until second last node
            mover=mover.next;
        }
        mover.next = null;//moves and nulls the Node n
        return n;
    }

    public static Node DeleteVal(Node n,int value){
        if(n==null || n.next == null) return n;
        if(n.data == value) return DeleteHead(n);
        Node temp =  n;
        Node prev = n;
        while(temp!=null){
            if(temp.data==value){
                prev.next = temp.next;
                return n;
            }
            prev = temp;
            temp=temp.next;
        }
        return n;
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

        //insert
//        Node insert = InsertLL(n,new Node(12),-1);

        TraverseLL(n);
//        TraverseLL(insert);

//        delete element
        Node deletedVal = DeleteVal(n,3);
        System.out.println("Delete Value:");
        TraverseLL(deletedVal);
        //delete Head
        Node deleteHead = DeleteHead(n);
        System.out.println("Delete Head:");
        TraverseLL(deleteHead);


        //delete Tail
        Node deleteTail = DeleteTail(n);
        System.out.println("Delete Tail:");
        TraverseLL(deleteTail);

        //insert val head
//        Node insertHead
        Node insertHead = InsertHead(n,9);
        System.out.println("Insert Head Val:");
        TraverseLL(insertHead);
        //Node insertTail
        Node insertTail = InsertTail(n,19);
        System.out.println("Insert Tail Val:");
        TraverseLL(insertTail);
    }
}
