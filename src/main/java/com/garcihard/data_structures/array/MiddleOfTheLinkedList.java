package com.garcihard.data_structures.array;

public class MiddleOfTheLinkedList {
    public ListNode middleNode( ListNode head ) {
        ListNode slow = head, fast = head;

        while ( fast != null && fast.next != null ) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
