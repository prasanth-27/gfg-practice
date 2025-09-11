package September_2025.potdSept_8_2025;

class Node {
    int data;
    Node next;

    Node(int key) {
        data = key;
        next = null;
    }
}

public class potdSept_8_2025 {
    public static void main(String[] args) {
        Node head = new Node(9);
        head.next = new Node(8);
        head.next.next = new Node(5);
        head.next.next.next = new Node(2);

        head = mergeSort(head);

        Node curr = head;
        while(curr!=null){
            System.out.print(curr.data);
            curr = curr.next;
            if(curr!=null){
                System.out.print("->");
            }
        }
    }

    private static Node mergeSort(Node head){

        if(head == null || head.next == null){
             return head;
        }

        Node secondHalf = split(head);

        head = mergeSort(head);
        secondHalf = mergeSort(secondHalf);

        return merge(head,secondHalf);

    }

    private static Node split(Node head){
        Node slow=head,fast=head;

        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            if(fast!=null){
                slow = slow.next;
            }
        }

        Node temp = slow.next;
        slow.next = null;

        return temp;
    }

    private static Node merge(Node first, Node second){
        if(first==null){
            return second;
        }
        if(second == null){
            return first;
        }

        if(first.data<second.data){
            first.next = merge(first.next, second);
            return first;
        }else{
            second.next = merge(first, second.next);
            return second;
        }
    }
}
