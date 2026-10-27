package com.garcihard.data_structures.array;

public class BinarySearch {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1, mid = 0;

        while ( left <= right ) {
            mid = (left + right) / 2;

            if ( nums[mid] == target ) {
                return mid;
            } else if ( nums[mid] < target ) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}

/*
l       m l   m     r
 \      |  \  |    /
[-1][0][3][5][9][12]

m = (l + r) / 2
l = 3, r = 5
m = (3 + 5) / 2 = 4 -> 4
m = 4

nums[m] == target
    y -> return m;

elif nums[m] < target
    y -> left = m + 1;
el
    -> right = m - 1;

*/
