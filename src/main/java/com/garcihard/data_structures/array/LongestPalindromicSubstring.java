package com.garcihard.data_structures.array;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        String res = "";

        for ( int i = 0; i < s.length(); i++ ) {
//            String tmp = s.length() % 2 == 0 ?
//                    expandStr(s, i, i + 1) : expandStr(s, i, i);
            String even = expandStr(s, i, i + 1);
            String odd = expandStr(s, i, i);

            String tmp = even.length() > odd.length() ? even : odd;

            if ( tmp.length() > res.length() ) res = tmp;
        }

        return res;
    }

    private String expandStr(String str, int left, int right) {
        while ( left >= 0 && right < str.length()
                && str.charAt(left) == str.charAt(right)) {
            left--; right++;
        }

        return str.substring(left + 1, right);
    }
}
