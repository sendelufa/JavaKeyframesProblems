package leetcode.p0019;

import utils.ListNode;
import utils.Utils;

public class Solution {

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3)));
        Utils.printNodeList(head);
        Utils.printNodeList(removeNthFromEnd(head, 1));
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode left = head, right = head;
        int position = 1;

        while (right.next != null) {
            position++;
            right = right.next;
            if (position > n + 1) left = left.next;
        }

        if (position == n) return head.next;
        left.next = left.next.next;
        return head;
    }

}
