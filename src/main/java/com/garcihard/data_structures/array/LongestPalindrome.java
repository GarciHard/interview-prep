package com.garcihard.data_structures.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class LongestPalindrome {

    public int longestPalindrome(String s) {
        HashMap<Character, Integer> mapa = new HashMap<>();
        //Stack<Character> substr = new Stack<>();
        //int start = 0, end = s.length() - 1;
        int res = 0;

        for ( char c : s.toCharArray() ) {
            mapa.put(c, mapa.getOrDefault(c, 0) + 1);
        }

        for ( char c : mapa.keySet() ) {
            int v = mapa.get(c);
            if ( v % 2 == 1 ) {
                v -= 1;
            }
            res += v;
        }

        if ( res < s.length() ) {
            res += 1;
        }

        return res;
    /*
        while ( start < end ) {

            if ( s.charAt(start) == s.charAt(end) ) {
                int aux = start - 1;
                while ( start < end ) {
                    if ( s.charAt(start) == s.charAt(end) ) {
                        substr.push(s.charAt(start));
                        substr.push(s.charAt(end));
                    }
                    start++;
                    end--;
                }
                end = aux;
                start = 0;
            }
                start++;

        }

        if ( substr.size() < s.length() ) {
            return substr.size() + 1;
        }

         return substr.size();
    */
    }
}
