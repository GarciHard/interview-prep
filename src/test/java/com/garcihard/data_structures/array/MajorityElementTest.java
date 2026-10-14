package com.garcihard.data_structures.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MajorityElementTest {

    @Test
    void majorityElementTest() {
        int[] arr1 = {3, 2, 3};
        int[] arr2 = {2, 2, 1, 1, 1, 2, 2};

        int target1 = 3;
        int target2 = 2;

        assertEquals(target1, MajorityElement.majorityElement(arr1));
        assertEquals(target2, MajorityElement.majorityElement(arr2));
    }
}
