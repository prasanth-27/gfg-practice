package leetcode;

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class LC2_AddTwoNumbers {

    public static void main(String[] args) {

        ListNode h = new ListNode(1);
        h.next = new ListNode(2);
        h.next.next = new ListNode(3);

        ListNode h2 = new ListNode(1);
        h2.next = new ListNode(2);
        h2.next.next = new ListNode(3);

        ListNode k =h;
        while(k!=null){
            System.out.println(k.val);
            k=k.next;
        }

        ListNode ans = sum(h,h2);
        while(ans!=null){
            System.out.println(ans.val);
            ans=ans.next;
        }

    }

    private static ListNode sum(ListNode h1, ListNode h2){
        ListNode answer = new ListNode(0);
        ListNode ah = answer;
        int carry = 0;

        //ListNode h1=l1;
        //ListNode h2=l2;

        while(h1!=null || h2!=null || carry!=0){
            int d1 = h1!=null ? h1.val : 0;
            int d2 = h2!=null ? h2.val : 0;

            int sum = d1+d2+carry;
            carry = sum/10;
            sum = sum%10;

            ListNode node = new ListNode(sum);
            ah.next = node;
            ah = ah.next;

            h1 = h1!=null ? h1.next : null;
            h2 = h2!=null ? h2.next : null;

        }

        return answer.next;
    }

}
