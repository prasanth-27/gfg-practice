package September_2025.potdSept_4_2025;

class Node{
    int data;
    Node next;

    Node(int x){
        data=x;
        next=null;
    }
}

public class potdSept_4_2025 {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        printList(head);
        head = reverseKGroup(head, 3);
        printList(head);
    }

    static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data);
            if(curr.next != null){
                System.out.print(" -> ");
            }
            curr = curr.next;
        }
        System.out.println();
    }

    private static Node reverseKGroup(Node head, int k){

        Node curr = head;

        Node tail=null,next=null,prev=null;
        Node start = curr;

        while(curr!=null){

            int count = 0;

            //Reverse the group of k
            while(curr!=null && count<k ){

                count++;

                next=curr.next;
                curr.next=prev;
                prev=curr;
                curr=next;
            }

            //First group
            if(tail==null){

                tail=head;
                head=prev;

            }else{//next groups

                tail.next=prev;
                tail=start;

            }

            start = curr;
            prev = null;

        }


        return head;
    }

}
