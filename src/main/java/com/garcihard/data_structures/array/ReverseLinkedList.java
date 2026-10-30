package com.garcihard.data_structures.array;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null, curr = head, next = null;

        while ( curr != null ) {
            next = curr.next;
            curr.next = pre;

            pre = curr;
            curr = next;
        }
        //return pre;
        head = pre;
        return head;
    }
}
