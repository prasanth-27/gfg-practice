package September_2025.potdSept_5_2025;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

public class potdSept_5_2025 {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(2);
        head.next.next.next = new Node(1);
        head.next.next.next.next = new Node(2);
        head.next.next.next.next.next = new Node(0);
        head.next.next.next.next.next.next = new Node(2);
        head.next.next.next.next.next.next.next = new Node(2);

        printll(head);
        head = segregate(head);
        printll(head);

        head = new Node(1);
        head.next = new Node(0);
        head.next.next = new Node(0);

        printll(head);
        head = segregate(head);
        printll(head);
    }

    private static void printll(Node head) {
        while (head != null) {
            System.out.print(head.data);
            if(head.next != null){
                System.out.print(" -> ");
            }
            head = head.next;
        }
        System.out.println();
    }

    private static Node segregate(Node head){

        if(head == null || head.next==null) return head;

        Node curr=head;

        Node next=null, zh=null,zt=null, oh=null,ot=null,th=null,tt=null;

        while (curr!=null){

            next=curr.next;

            switch (curr.data){
                case 0:
                    if(zh==null) zh=curr;

                    if(zt!=null)
                        zt.next = curr;

                    zt=curr;
                    break;
                case 1:
                    if(oh==null) oh=curr;

                    if(ot!=null)
                        ot.next = curr;

                    ot=curr;
                    break;
                case 2:
                    if(th==null) th=curr;

                    if(tt!=null)
                        tt.next = curr;

                    tt=curr;
                    break;
            }
            curr = next;
        }

        if(zt!=null) zt.next= (oh!=null?oh:th);
        if(ot!=null) ot.next=th;
        if(tt!=null) tt.next=null;

        return zh!=null ? zh : (oh!=null ? oh : th);
    }
}
