package com.garcihard.data_structures.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TwoSumTest {

    @Test
    public void twoSum() {
        int[] array1 = { 2, 7, 11, 15 };
        int[] array2 = { 3, 2, 4 };
        int[] array3 = { 3, 3 };

        int target1 = 9;
        int target2 = 6;
        int target3 = 6;

        int[] output1 = { 0, 1 };
        int[] output2 = { 1, 2 };
        int[] output3 = { 0, 1 };

        assertArrayEquals(output1, TwoSum.twoSum(array1, target1));
        assertArrayEquals(output2, TwoSum.twoSum(array2, target2));
        assertArrayEquals(output3, TwoSum.twoSum(array3, target3));
    }

}
