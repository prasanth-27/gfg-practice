package September_2025.potdSept_2_2025;

class Node{
    int data;
    Node next;

    Node(int x){
        data=x;
        next=null;
    }
}

public class potdSept_2_2025 {

    public static void main(String[] args) {
        Node head = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);

        head.next=two;
        two.next=three;
        three.next=four;
        four.next=five;

        swapKth(head, 1);

        Node i=head;
        while(i.next!=null){
            System.out.println(i.data + "->");
            i=i.next;
        }

    }

    private static Node swapKth(Node head, int k) {
        // code here
        int size=1;
        Node i=head;
        while(i.next != null){
            i=i.next;
            size++;
        }

        if(k>size){
            return head;
        }

        i=head;
        Node j= head;

        int count=1;
        while(count<k){
            i=i.next;
            count++;
        }

        count=1;
        while(count<(size-k+1)){
            j=j.next;
            count++;
        }

        if(j!=null){
            int temp=i.data;
            i.data=j.data;
            j.data=temp;
        }

        return head;
    }

}
