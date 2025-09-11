package September_2025.potdSept_6_2025;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

public class potdSept_6_2025 {
    public static void main(String[] args) {

    }

    private static int lengthOfLoop(Node head){
        Node fast=head,slow=head;

        while (slow != null && fast != null
                && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            // if slow and fast meet at
            // some point then there is a loop
            if (slow == fast)
                return countNodes(slow);
        }

        return 0;
    }

    static int countNodes(Node node) {
        int res = 1;
        Node curr = node;
        while (curr.next != node) {
            res++;
            curr = curr.next;
        }
        return res;
    }
}
