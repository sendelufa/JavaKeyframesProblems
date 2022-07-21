package _0206;

public class Solution {

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode node = head;
        ListNode next;
        while (node != null) {
            next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        return prev;
    }

}

//NEXT: 2      3      null
//
//CURR: 1  ->  2  ->  3  -> null
//      |      |      |
//PREV: null   1      2    3

//  ((1) 2) -> ((2) null) )   =   ((2) 1) -> ((1) null)
//
// 1. ((1) 2)          next: ((2) null)
//                     prev: null
// 2. ((1) null) <- prev
// 3.                  prev: ((1) null)
// 4. ((2) null)
//
// 1. ((2) null)        next: null
// 2. ((2) 1)
// 3.                   prev: ((2) 1)
// 4. null
//
// выход ->
