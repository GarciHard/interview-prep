package com.garcihard.data_structures.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContainsDuplicateTest {

    @Test
    void containsDuplicateTest() {
        int[] arr1 = { 1, 2, 3, 1 };
        int[] arr2 = { 1, 2, 3, 4 };
        int[] arr3 = { 1, 1, 1, 3, 3, 4, 3, 2, 4, 2 };

        boolean target1 = true;
        boolean target2 = false;
        boolean target3 = true;

        assertEquals(target1, ContainsDuplicate.containsDuplicate(arr1));
        assertEquals(target2, ContainsDuplicate.containsDuplicate(arr2));
        assertEquals(target3, ContainsDuplicate.containsDuplicate(arr3));
    }
}
