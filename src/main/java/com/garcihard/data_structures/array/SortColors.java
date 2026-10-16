package com.garcihard.data_structures.array;

public class SortColors {
    public static void sortColors(int[] nums) {

        int l = 0, r = nums.length-1;

        while( l < r) {
            while(r > l) {
                if ( nums[l] > nums[r] ) {
                    int aux = nums[r];
                    nums[r] = nums[l];
                    nums[l] = aux;
                }
                r--;
            }
            r = nums.length-1;
            l++;
        }
    }
}
