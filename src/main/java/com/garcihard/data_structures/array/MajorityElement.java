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
// 2 2 1 1 1 2 2
    public static int majorElement(int [] person) {

        int candidate = -1;
        int counter = 0;

        for ( int x : person ) {
            if ( candidate == -1 ) {
                candidate = x;
                counter++;
            } else if ( x != candidate ) {
                counter--;
                if ( counter <= 0 ) {
                    candidate = x;
                    counter++;
                }
            } else {
                counter++;
            }
        }

        return candidate;
    }
}
