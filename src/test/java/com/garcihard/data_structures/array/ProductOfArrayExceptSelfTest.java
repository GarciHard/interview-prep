package com.garcihard.data_structures.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ProductOfArrayExceptSelfTest {

    @Test
    void productExceptSelfTest() {
        int[] arr1 = {1,2,3,4};
        int[] res1 = {24, 12, 8, 6};

        int[] arr2 = {-1, 1, 0, -3, 3};
        int[] res2 = {0, 0, 9, 0, 0};

        assertArrayEquals(res1, ProductOfArrayExceptSelf.productExceptSelf(arr1));
        assertArrayEquals(res2, ProductOfArrayExceptSelf.productExceptSelf(arr2));
    }
}
