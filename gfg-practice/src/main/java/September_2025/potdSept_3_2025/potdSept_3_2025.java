package September_2025.potdSept_3_2025;

class Node{
    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

public class potdSept_3_2025 {
    public static void main(String[] args) {
        Node head = new Node(1);
        Node two  = new Node(2);
        Node three = new Node(3);

        head.next=two;
        two.prev=head;
        two.next=three;
        three.prev=two;

        reverse(head);

        Node i=head;
        while(i.next!=null){
            System.out.println(i.data);
            i=i.next;
        }

    }

    private static Node reverse(Node head){

        Node tail=head;

        while(true){
            if(tail.next!=null){
                tail=tail.next;
            }else{
                break;
            }
        }

        Node i = head;
        Node j = tail;

        while(i.prev!=j && i!=j){
            i.data+=j.data;
            j.data=i.data-j.data;
            i.data=i.data-j.data;
            i=i.next;
            j=j.prev;
        }


        return head;
    }
}
