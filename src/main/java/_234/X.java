package _234;

public class X {

    public static void main(String[] args) {
        System.out.println(
                new Solution().isPalindrome(new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))))));
    }

    static class Solution {
        public boolean isPalindrome(ListNode head) {
            if (head == null) {
                return true;
            }
            if (head.next == null) {
                return true;
            }
            ListNode fast = head;
            ListNode slow = head;

            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            // 1221
            //Rverseing slow
            ListNode curr = slow;
            ListNode prev = null;
            while (curr != null) {
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }
            //comparing each value
            while (prev != null) {
                if (prev.val != head.val) {
                    return false;
                }
                prev = prev.next;
                head = head.next;
            }
            return true;
        }
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
}
