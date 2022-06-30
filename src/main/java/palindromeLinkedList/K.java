package palindromeLinkedList;

public class K {
    class Solution {
        public boolean isPalindrome(ListNode head) {
            if (head.next == null) {
                return true;
            }

            var str = new StringBuilder();

            while (head != null) {
                str.append(head.val);
                head = head.next;
            }

            for (int i = 0; i < str.length() / 2; i++) {
                if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
                    return false;
                }
            }
            return true;
        }
    }

    public class ListNode {
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
