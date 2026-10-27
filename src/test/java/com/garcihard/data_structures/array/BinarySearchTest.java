package com.garcihard.data_structures.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinarySearchTest {

    private final BinarySearch binarySearch = new BinarySearch();

    // --- Target found ---

    @Test
    public void targetAtBeginning() {
        int[] nums = {1, 3, 5, 7, 9};
        assertEquals(0, binarySearch.search(nums, 1));
    }

    @Test
    public void targetAtEnd() {
        int[] nums = {1, 3, 5, 7, 9};
        assertEquals(4, binarySearch.search(nums, 9));
    }

    @Test
    public void targetInMiddle() {
        int[] nums = {1, 3, 5, 7, 9};
        assertEquals(2, binarySearch.search(nums, 5));
    }

    @Test
    public void targetInLeftHalf() {
        int[] nums = {1, 3, 5, 7, 9, 11};
        assertEquals(1, binarySearch.search(nums, 3));
    }

    @Test
    public void targetInRightHalf() {
        int[] nums = {1, 3, 5, 7, 9, 11};
        assertEquals(4, binarySearch.search(nums, 9));
    }

    // --- Target not found ---

    @Test
    public void targetSmallerThanAll() {
        int[] nums = {2, 4, 6, 8, 10};
        assertEquals(-1, binarySearch.search(nums, 1));
    }

    @Test
    public void targetLargerThanAll() {
        int[] nums = {2, 4, 6, 8, 10};
        assertEquals(-1, binarySearch.search(nums, 12));
    }

    @Test
    public void targetBetweenElements() {
        int[] nums = {1, 3, 5, 7, 9};
        assertEquals(-1, binarySearch.search(nums, 4));
    }

    // --- Edge cases ---

    @Test
    public void singleElementFound() {
        int[] nums = {42};
        assertEquals(0, binarySearch.search(nums, 42));
    }

    @Test
    public void singleElementNotFound() {
        int[] nums = {42};
        assertEquals(-1, binarySearch.search(nums, 10));
    }

    @Test
    public void twoElementsFoundFirst() {
        int[] nums = {1, 3};
        assertEquals(0, binarySearch.search(nums, 1));
    }

    @Test
    public void twoElementsFoundSecond() {
        int[] nums = {1, 3};
        assertEquals(1, binarySearch.search(nums, 3));
    }

    @Test
    public void twoElementsNotFound() {
        int[] nums = {1, 3};
        assertEquals(-1, binarySearch.search(nums, 2));
    }

    @Test
    public void emptyArray() {
        int[] nums = {};
        assertEquals(-1, binarySearch.search(nums, 5));
    }

    // --- Negative numbers ---

    @Test
    public void negativeNumbers() {
        int[] nums = {-10, -5, -3, -1, 0, 2, 4};
        assertEquals(1, binarySearch.search(nums, -5));
    }

    @Test
    public void negativeTargetNotFound() {
        int[] nums = {-10, -5, -3, -1, 0, 2, 4};
        assertEquals(-1, binarySearch.search(nums, -7));
    }

    // --- Larger array ---

    @Test
    public void largerArrayEvenLength() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        assertEquals(6, binarySearch.search(nums, 7));
    }

    @Test
    public void largerArrayOddLength() {
        int[] nums = {10, 20, 30, 40, 50, 60, 70, 80, 90};
        assertEquals(8, binarySearch.search(nums, 90));
    }
}
