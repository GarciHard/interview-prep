package com.garcihard.data_structures.array;

public class ContainerWithMostWater {
    public static int maxArea(int[] height) {

        int l = 0, r = height.length - 1, max = 0;

        while (l < r) {
            int h = (r - l)*Math.min(height[l], height[r]);
            max = Math.max(h, max);

            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }

        return max;
    }
}
