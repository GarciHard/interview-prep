package com.garcihard.data_structures.array;

public class MergeTwoSortedLists {
    public ListNode mergeTwoList(ListNode list1, ListNode list2) {
        //ListNode L1c = list1, L2c = list2, Laux;
        /*
        while ( L1c != null ) {
            if ( L1c.val == L2c.val ) {
                Laux = new ListNode(L1c.val, list2.next);
                L2c.next = Laux;
            } else if ( L1c.val > L2c.val ) {
                if ( L1c.val <= L2c.next.val ) {
                    Laux = new ListNode(L1c.val, L2c.next);
                    L2c.next = Laux;
                } else {
                    Laux = new ListNode(L1c.val, L2c.next.next);
                    L2c.next.next = Laux;
                }

            }
            L1c = L1c.next;
            L2c = L2c.next;
        }
        */
        ListNode fakeNode = new ListNode(-1);
        ListNode mergedNode = fakeNode;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                mergedNode.next = list1;
                list1 = list1.next;
            } else {
                mergedNode.next = list2;
                list2 = list2.next;
            }
            mergedNode = mergedNode.next;
        }

        mergedNode.next = (list1 == null) ? list2 : list1;

        return fakeNode.next;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
