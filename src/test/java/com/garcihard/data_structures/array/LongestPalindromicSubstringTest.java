package com.garcihard.data_structures.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LongestPalindromicSubstringTest {

    private final LongestPalindromicSubstring solver = new LongestPalindromicSubstring();

    @Test
    public void oddLengthPalindrome() {
        // "bab" or "aba" are both valid
        String result = solver.longestPalindrome("babad");
        assertTrue(result.equals("bab") || result.equals("aba"));
    }

    @Test
    public void evenLengthPalindrome() {
        assertEquals("bb", solver.longestPalindrome("cbbd"));
    }

    @Test
    public void singleCharacter() {
        assertEquals("a", solver.longestPalindrome("a"));
    }

    @Test
    public void twoIdenticalCharacters() {
        assertEquals("aa", solver.longestPalindrome("aa"));
    }

    @Test
    public void entireStringIsPalindrome() {
        assertEquals("racecar", solver.longestPalindrome("racecar"));
    }

    @Test
    public void allSameCharacters() {
        assertEquals("aaaa", solver.longestPalindrome("aaaa"));
    }

    @Test
    public void noRepeatingCharacters() {
        // Any single character is valid
        String result = solver.longestPalindrome("abcde");
        assertEquals(1, result.length());
    }

    @Test
    public void palindromeAtEnd() {
        assertEquals("abcba", solver.longestPalindrome("xyzabcba"));
    }

    @Test
    public void palindromeAtStart() {
        assertEquals("abcba", solver.longestPalindrome("abcbaxyz"));
    }

    @Test
    public void longEvenPalindrome() {
        assertEquals("abccba", solver.longestPalindrome("xabccbay"));
    }

    @Test
    public void emptyString() {
        assertEquals("", solver.longestPalindrome(""));
    }

    @Test
    public void twoDistinctCharacters() {
        // No multi-char palindrome; any single char is valid
        String result = solver.longestPalindrome("ab");
        assertEquals(1, result.length());
    }
}
