package com.garcihard.data_structures.array;

import java.util.HashMap;

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int aux = target - nums[i];

            if (map.containsKey(aux))
                return new int[]{ map.get(aux), i };

            map.put(nums[i], i);
        }

        return new int[]{};
    }
}
