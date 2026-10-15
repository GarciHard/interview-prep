package com.garcihard.data_structures.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContainerWithMostWaterTest {

    @Test
    void maxAreaOfContainer() {
        int[] arr1 = {1,8,6,2,5,4,8,3,7};
        int res1 = 49;

        int[] arr2 = {1,1};
        int res2 = 1;

        int[] arr3 = {1,2,1};
        int res3 = 2;

        int[] arr4 = {1,2};
        int res4 = 1;

        assertEquals(res1, ContainerWithMostWater.maxArea(arr1));
        assertEquals(res2, ContainerWithMostWater.maxArea(arr2));
        assertEquals(res3, ContainerWithMostWater.maxArea(arr3));
        assertEquals(res4, ContainerWithMostWater.maxArea(arr4));
    }
}
