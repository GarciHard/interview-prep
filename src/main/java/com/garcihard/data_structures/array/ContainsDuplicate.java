package com.garcihard.data_structures.array;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> noDuplicates = new HashSet<>();

        for (int element : nums) {
            if ( noDuplicates.contains(element) ) {
                return true;
            }
            noDuplicates.add(element);
        }
        return false;
    }
}
