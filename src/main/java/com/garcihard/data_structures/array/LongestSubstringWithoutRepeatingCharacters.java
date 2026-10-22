package com.garcihard.data_structures.array;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        Set<Character> substring =  new HashSet<>();
        int start = 0, max = 0;

        for ( int end = 0; end < s.length(); end++ ) {

            while ( substring.contains(s.charAt(end)) ) {
                substring.remove(s.charAt(start));
                start++;
            }

            substring.add(s.charAt(end));

            if ( substring.size() > max )
                max = substring.size();
            // we can use Math.max(max, end - start + 1);
        }

        return max;
    }
}

/*
s = 7
e = 7

{ , , , , b}

                      s    e
                      \   /
    [a][b][c][a][b][c][b][b]
    [0][1][2][3][4][5][6][7]

    1. get max length = 3
    2. delete from substring character at start
    4. increase start by 1
    3. add end to substring


 */