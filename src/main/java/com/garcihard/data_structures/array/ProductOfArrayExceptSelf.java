package com.garcihard.data_structures.array;

public class ProductOfArrayExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
//        int arrSize = nums.length, selfPos = 0;
//        int[] product = new int[arrSize];
//
//        while ( selfPos < arrSize ) {
//            int l = 0;
//            int auxProd = 1;
//            while (l < arrSize) {
//                if (l != selfPos) {
//                    auxProd *= nums[l];
//                }
//                l++;
//            }
//            product[selfPos] = auxProd;
//            selfPos++;
//        }
//        return product;

        int arrSize = nums.length - 1, acc = 1;
        int[] product = new int[nums.length];

        for (int self = 0; self <= arrSize; self++) {
            product[self] = acc;
            acc *= nums[self];
        }
// 1,2,3,4
// 1,1,2,6
//24,12,8,6
        acc = 1;
        for (int self = arrSize; self >= 0; self--) {
            //int auxNums = nums[self];
            product[self] *= acc;
            //nums[self] = acc * product[self];
            acc *= nums[self];
        }

        return product;
    }
}
