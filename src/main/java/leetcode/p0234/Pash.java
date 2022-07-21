package leetcode.p0234;

public class Pash {

    public boolean isPalindrome(leetcode.p0234.Aleks.ListNode head) {

        StringBuilder sb = new StringBuilder();
        while (head.next != null) {
            sb.append(head.val);
            head = head.next;
        }

        return sb.toString().equals(sb.reverse().toString());
    }
}

class ListNode {
    int val;
    leetcode.p0234.Aleks.ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, leetcode.p0234.Aleks.ListNode next) {
        this.val = val;
        this.next = next;
    }
}
