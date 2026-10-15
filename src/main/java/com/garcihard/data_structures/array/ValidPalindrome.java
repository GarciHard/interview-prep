package com.garcihard.data_structures.array;

public class ValidPalindrome {

    public static boolean isPalindrome(String palindrome) {
        String aux = palindrome.replaceAll("[^a-zA-Z0-9]", "").toLowerCase().trim();
        int l = 0, r = aux.length() - 1;

        while ( l <= r ) {
            if ( aux.charAt(l) != aux.charAt(r) ) return false;
            l++; r--;
        }

        return true;
    }
}
