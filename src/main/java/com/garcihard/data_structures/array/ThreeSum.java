package com.garcihard.data_structures.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> sum = new ArrayList<>();


        /*if ( nums.length == 3 &&
                nums[i] + nums[i + 1] + nums[i + 2] == 0 ) {
            sum.add(Arrays.stream(nums).boxed().toList());
            return sum;
        } else {*/
//            while ( i <= nums.length - 2 ) {
//                int j = i + 1, k = j + 1;
//                while ( k <= nums.length - 1 ) {
//                    if ( (i != j && i != k && j != k)
//                    && nums[i] + nums[j] + nums[k] == 0) {
//                        int[] aux = {nums[i], nums[j], nums[k]};
//                        List<Integer> tmp = Arrays.stream(aux).sorted().boxed().toList();
//                        if ( !sum.contains(tmp) ) {
//                            sum.add(tmp);
//                        }
//                    }
//                    j++; k++;
//                }
//                i++;
//            }
        //}
        // [-4, -1, -1, 0, 1, 2]
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                int res = nums[i] + nums[j] + nums[k];
                if (res == 0) {
                    sum.add(Arrays.asList(nums[i], nums[j], nums[k]));

                    while (j < k && nums[j] == nums[j + 1]) j++;

                    while (j < k && nums[k] == nums[k - 1]) k--;

                    j++;
                    k--;
                } else if (res < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return sum;
    }
}
