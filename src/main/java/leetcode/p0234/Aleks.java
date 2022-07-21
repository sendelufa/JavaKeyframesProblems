package leetcode.p0234;

import java.util.ArrayList;

public class Aleks {

    class Solution {
        public boolean isPalindrome(ListNode head) {
            ArrayList<Integer> list = new ArrayList<>();
            while (head != null) {
                list.add(head.val);
                head = head.next;
            }
            Integer[] arr = (Integer[]) list.toArray();
            int left = 0;
            int right = arr.length - 1;
            while (left <= right) {
                if (!arr[left].equals(arr[right])) {
                    return false;
                }
                left++;
                right--;
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
