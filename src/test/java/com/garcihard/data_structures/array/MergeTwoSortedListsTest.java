package com.garcihard.data_structures.array;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MergeTwoSortedListsTest {

    private MergeTwoSortedLists merger;

    @BeforeEach
    void setUp() {
        merger = new MergeTwoSortedLists();
    }

    // ── Helper utilities ────────────────────────────────────────────────

    /**
     * Builds a linked list from the given values.
     * Example: buildList(1, 2, 4) → 1 → 2 → 4 → null
     */
    private ListNode buildList(int... values) {
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        for (int val : values) {
            current.next = new ListNode(val);
            current = current.next;
        }
        return dummy.next;
    }

    /**
     * Converts a linked list to an int array for easy assertion.
     */
    private int[] toArray(ListNode head) {
        // First pass: count nodes
        int count = 0;
        ListNode current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        // Second pass: populate array
        int[] result = new int[count];
        current = head;
        for (int i = 0; i < count; i++) {
            result[i] = current.val;
            current = current.next;
        }
        return result;
    }

    // ── Both lists are null ─────────────────────────────────────────────

    @Nested
    @DisplayName("Both lists null")
    class BothNull {

        @Test
        @DisplayName("should return null when both lists are null")
        void bothNull_returnsNull() {
            ListNode result = merger.mergeTwoList(null, null);
            assertNull(result);
        }
    }

    // ── One list is null ────────────────────────────────────────────────

    @Nested
    @DisplayName("One list null")
    class OneNull {

        @Test
        @DisplayName("should return list2 when list1 is null")
        void list1Null_returnsList2() {
            ListNode list2 = buildList(1, 3, 5);

            ListNode result = merger.mergeTwoList(null, list2);

            assertArrayEquals(new int[]{1, 3, 5}, toArray(result));
        }

        @Test
        @DisplayName("should return list1 when list2 is null")
        void list2Null_returnsList1() {
            ListNode list1 = buildList(2, 4, 6);

            ListNode result = merger.mergeTwoList(list1, null);

            assertArrayEquals(new int[]{2, 4, 6}, toArray(result));
        }
    }

    // ── Standard merge scenarios ────────────────────────────────────────

    @Nested
    @DisplayName("Standard merges")
    class StandardMerge {

        @Test
        @DisplayName("merge [1,2,4] and [1,3,4] → [1,1,2,3,4,4]")
        void classicLeetCodeExample() {
            ListNode list1 = buildList(1, 2, 4);
            ListNode list2 = buildList(1, 3, 4);

            ListNode result = merger.mergeTwoList(list1, list2);

            assertArrayEquals(new int[]{1, 1, 2, 3, 4, 4}, toArray(result));
        }

        @Test
        @DisplayName("merge [1,3,5] and [2,4,6] → [1,2,3,4,5,6]")
        void interleavedLists() {
            ListNode list1 = buildList(1, 3, 5);
            ListNode list2 = buildList(2, 4, 6);

            ListNode result = merger.mergeTwoList(list1, list2);

            assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6}, toArray(result));
        }

        @Test
        @DisplayName("merge [1,2,3] and [4,5,6] → [1,2,3,4,5,6] (non-overlapping)")
        void nonOverlapping_list1AllSmaller() {
            ListNode list1 = buildList(1, 2, 3);
            ListNode list2 = buildList(4, 5, 6);

            ListNode result = merger.mergeTwoList(list1, list2);

            assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6}, toArray(result));
        }

        @Test
        @DisplayName("merge [4,5,6] and [1,2,3] → [1,2,3,4,5,6] (non-overlapping reversed)")
        void nonOverlapping_list2AllSmaller() {
            ListNode list1 = buildList(4, 5, 6);
            ListNode list2 = buildList(1, 2, 3);

            ListNode result = merger.mergeTwoList(list1, list2);

            assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6}, toArray(result));
        }
    }

    // ── Different-length lists ──────────────────────────────────────────

    @Nested
    @DisplayName("Different-length lists")
    class DifferentLengths {

        @Test
        @DisplayName("merge [1] and [2,3,4,5] → [1,2,3,4,5]")
        void shortList1_longList2() {
            ListNode list1 = buildList(1);
            ListNode list2 = buildList(2, 3, 4, 5);

            ListNode result = merger.mergeTwoList(list1, list2);

            assertArrayEquals(new int[]{1, 2, 3, 4, 5}, toArray(result));
        }

        @Test
        @DisplayName("merge [1,2,3,4] and [5] → [1,2,3,4,5]")
        void longList1_shortList2() {
            ListNode list1 = buildList(1, 2, 3, 4);
            ListNode list2 = buildList(5);

            ListNode result = merger.mergeTwoList(list1, list2);

            assertArrayEquals(new int[]{1, 2, 3, 4, 5}, toArray(result));
        }
    }

    // ── Single-element lists ────────────────────────────────────────────

    @Nested
    @DisplayName("Single-element lists")
    class SingleElement {

        @Test
        @DisplayName("merge [1] and [2] → [1,2]")
        void singleElements_inOrder() {
            ListNode list1 = buildList(1);
            ListNode list2 = buildList(2);

            ListNode result = merger.mergeTwoList(list1, list2);

            assertArrayEquals(new int[]{1, 2}, toArray(result));
        }

        @Test
        @DisplayName("merge [2] and [1] → [1,2]")
        void singleElements_reversed() {
            ListNode list1 = buildList(2);
            ListNode list2 = buildList(1);

            ListNode result = merger.mergeTwoList(list1, list2);

            assertArrayEquals(new int[]{1, 2}, toArray(result));
        }

        @Test
        @DisplayName("merge [1] and [1] → [1,1]")
        void singleElements_equal() {
            ListNode list1 = buildList(1);
            ListNode list2 = buildList(1);

            ListNode result = merger.mergeTwoList(list1, list2);

            assertArrayEquals(new int[]{1, 1}, toArray(result));
        }
    }

    // ── Duplicate values ────────────────────────────────────────────────

    @Nested
    @DisplayName("Duplicate values")
    class Duplicates {

        @Test
        @DisplayName("merge [1,1,1] and [1,1,1] → [1,1,1,1,1,1]")
        void allSameValues() {
            ListNode list1 = buildList(1, 1, 1);
            ListNode list2 = buildList(1, 1, 1);

            ListNode result = merger.mergeTwoList(list1, list2);

            assertArrayEquals(new int[]{1, 1, 1, 1, 1, 1}, toArray(result));
        }

        @Test
        @DisplayName("merge [1,2,2] and [2,3,3] → [1,2,2,2,3,3]")
        void overlappingDuplicates() {
            ListNode list1 = buildList(1, 2, 2);
            ListNode list2 = buildList(2, 3, 3);

            ListNode result = merger.mergeTwoList(list1, list2);

            assertArrayEquals(new int[]{1, 2, 2, 2, 3, 3}, toArray(result));
        }
    }

    // ── Negative values ─────────────────────────────────────────────────

    @Nested
    @DisplayName("Negative values")
    class NegativeValues {

        @Test
        @DisplayName("merge [-3,-1,0] and [-2,1,2] → [-3,-2,-1,0,1,2]")
        void mixedNegativeAndPositive() {
            ListNode list1 = buildList(-3, -1, 0);
            ListNode list2 = buildList(-2, 1, 2);

            ListNode result = merger.mergeTwoList(list1, list2);

            assertArrayEquals(new int[]{-3, -2, -1, 0, 1, 2}, toArray(result));
        }

        @Test
        @DisplayName("merge [-5,-3,-1] and [-4,-2,0] → [-5,-4,-3,-2,-1,0]")
        void allNegative() {
            ListNode list1 = buildList(-5, -3, -1);
            ListNode list2 = buildList(-4, -2, 0);

            ListNode result = merger.mergeTwoList(list1, list2);

            assertArrayEquals(new int[]{-5, -4, -3, -2, -1, 0}, toArray(result));
        }
    }

    // ── Empty lists ([] + []) ───────────────────────────────────────────

    @Nested
    @DisplayName("Empty lists")
    class EmptyLists {

        @Test
        @DisplayName("merge [] and [] → []")
        void bothEmpty_returnsNull() {
            // Both empty means both are null linked lists
            ListNode result = merger.mergeTwoList(null, null);
            assertNull(result);
        }

        @Test
        @DisplayName("merge [] and [0] → [0]")
        void emptyAndSingleZero() {
            ListNode list2 = buildList(0);

            ListNode result = merger.mergeTwoList(null, list2);

            assertArrayEquals(new int[]{0}, toArray(result));
        }
    }

    // ── Result list integrity ───────────────────────────────────────────

    @Nested
    @DisplayName("Result list integrity")
    class ResultIntegrity {

        @Test
        @DisplayName("merged list has correct length")
        void mergedLengthIsSum() {
            ListNode list1 = buildList(1, 3, 5, 7);
            ListNode list2 = buildList(2, 4, 6);

            ListNode result = merger.mergeTwoList(list1, list2);

            assertEquals(7, toArray(result).length);
        }

        @Test
        @DisplayName("merged list is sorted in non-decreasing order")
        void mergedListIsSorted() {
            ListNode list1 = buildList(1, 5, 10, 15);
            ListNode list2 = buildList(2, 3, 8, 20);

            ListNode result = merger.mergeTwoList(list1, list2);
            int[] arr = toArray(result);

            for (int i = 1; i < arr.length; i++) {
                assertTrue(arr[i - 1] <= arr[i],
                        "Element at index " + (i - 1) + " (" + arr[i - 1] +
                                ") should be <= element at index " + i + " (" + arr[i] + ")");
            }
        }

        @Test
        @DisplayName("merged list terminates (last node's next is null)")
        void mergedListTerminates() {
            ListNode list1 = buildList(1, 2);
            ListNode list2 = buildList(3, 4);

            ListNode result = merger.mergeTwoList(list1, list2);

            ListNode current = result;
            while (current.next != null) {
                current = current.next;
            }
            assertNull(current.next);
        }
    }
}
