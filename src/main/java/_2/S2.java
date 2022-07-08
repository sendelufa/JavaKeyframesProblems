package _2;

/**
 * recommend solution
 */
public class S2 {
    public Solution.ListNode addTwoNumbers(Solution.ListNode l1, Solution.ListNode l2) {
        Solution.ListNode dummyHead = new Solution.ListNode(0);
        Solution.ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new Solution.ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new Solution.ListNode(carry);
        }
        return dummyHead.next;
    }

}
