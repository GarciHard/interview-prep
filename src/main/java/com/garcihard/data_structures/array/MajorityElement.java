package com.garcihard.data_structures.array;

import java.util.HashMap;

public class MajorityElement {

    public static int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map =  new HashMap<>();
        int max = -1;

        for (int keyElement : nums) {
            if ( !map.containsKey(keyElement) ) {
                map.put(keyElement, 1);
            } else {
                map.put( keyElement, map.get(keyElement) +1 );
            }
        }

        for (int key : map.keySet()) {
            if ( max == -1 ) {
                max = key;
            } else {
                if ( map.get(key) > map.get(max) ) {
                    max = key;
                }
            }
        }

        return max;
    }
}
