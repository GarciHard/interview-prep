package com.garcihard.data_structures.array;

import java.util.HashMap;

public class ValidAnagram {
    public static boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> mapAnagram = new HashMap<>();

        if ( s.length() != t.length() ) return false;

        for (char character : s.toCharArray()) {
//            if (!mapAnagram.containsKey(character)) {
//                mapAnagram.put(character, 1);
//            } else {
//                mapAnagram.put(character, mapAnagram.get(character) + 1);
//            }
            mapAnagram.put(character, mapAnagram.getOrDefault(character, 0) + 1);
        }

        for (char aux : t.toCharArray()) {
            if ( !mapAnagram.containsKey(aux) ) {
                return false;
            } else {
                if ( mapAnagram.get(aux) <= 0 )
                    return false;
            }
            mapAnagram.put(aux, mapAnagram.get(aux) - 1);
        }

        return true;
    }
}
