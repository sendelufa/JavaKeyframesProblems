package addTwoNumbers;

public class Solution {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(9, new ListNode(9, new ListNode(1)));
        ListNode n2 = new ListNode(1);
        printList(n1);
        printList(n2);
        printList(new Solution().addTwoNumbers(n1, n2));

        ListNode zero = new ListNode(0);
        printList(zero);
        printList(zero);
        printList(new Solution().addTwoNumbers(zero, zero));

        n1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));
        n2 = new ListNode(9, new ListNode(9));
        printList(n1);
        printList(n2);
        printList(new Solution().addTwoNumbers(n1, n2));

        n1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3))));
        n2 = new ListNode(4, new ListNode(4));
        printList(n1);
        printList(n2);
        printList(new Solution().addTwoNumbers(n1, n2));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        boolean hasDigitInMind = false;
        ListNode cursor = new ListNode();
        ListNode result = cursor;
        int sum = 0;

        while (l1 != null && l2 != null) {
            sum = l1.val + l2.val + (hasDigitInMind ? 1: 0);
            hasDigitInMind = sum > 9 ;
            cursor.next = new ListNode(sum % 10);
            cursor = cursor.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        cursor.next = l1 == null ? l2 : l1;

        if (!hasDigitInMind) {
            return result.next;
        }

        l1 = cursor.next;
        while (l1 != null && hasDigitInMind) {
            sum = ++l1.val;
            hasDigitInMind = sum > 9;
            cursor.next = new ListNode(sum % 10);
            cursor = cursor.next;
            l1 = l1.next;
        }

        if (cursor.next == null && hasDigitInMind) {
            cursor.next = new ListNode(1);
            return result.next;
        }

        cursor.next = l1;
        return result.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    private static void printList(ListNode result) {
        var currentNode = result;

        StringBuilder sb = new StringBuilder();
        while (currentNode != null) {
            sb.append(currentNode.val);
            currentNode = currentNode.next;
        }
        System.out.println(sb);
    }
}
