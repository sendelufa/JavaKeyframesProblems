package PalindromeLinkedList;

public class Pash {

    public boolean isPalindrome(PalindromeLinkedList.Aleks.ListNode head) {

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
    PalindromeLinkedList.Aleks.ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, PalindromeLinkedList.Aleks.ListNode next) {
        this.val = val;
        this.next = next;
    }
}
