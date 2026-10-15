package com.garcihard.data_structures.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValidPalindromeTest {

    @Test
    void validPalindromeTest() {
        String str1 = "A man, a plan, a canal: Panama";
        String str2 = "race a car";
        String str3 = " ";
        String str4 = "0P";

        boolean res1 = true;
        boolean res2 = false;
        boolean res3 = true;
        boolean res4 = false;

        assertEquals(res1, ValidPalindrome.isPalindrome(str1));
        assertEquals(res2, ValidPalindrome.isPalindrome(str2));
        assertEquals(res3, ValidPalindrome.isPalindrome(str3));
        assertEquals(res4, ValidPalindrome.isPalindrome(str4));
    }
}
