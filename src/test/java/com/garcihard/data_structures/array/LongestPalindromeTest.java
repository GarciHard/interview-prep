package com.garcihard.data_structures.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongestPalindromeTest {

    private final LongestPalindrome lp = new LongestPalindrome();

    @Test
    void allCharsPaired() {
        // "aabb" -> "abba" (length 4)
        assertEquals(4, lp.longestPalindrome("aabb"));
    }

    @Test
    void singleOddCharacterCanBeCenter() {
        // "abccccdd" -> e.g. "dccaccd" (length 7)
        assertEquals(7, lp.longestPalindrome("abccccdd"));
    }

    @Test
    void singleCharacter() {
        assertEquals(1, lp.longestPalindrome("a"));
    }

    @Test
    void allSameCharacters() {
        // "aaaa" -> "aaaa" (length 4)
        assertEquals(4, lp.longestPalindrome("aaaa"));
    }

    @Test
    void allUniqueCharacters() {
        // "abcdef" -> any single char as palindrome (length 1)
        assertEquals(1, lp.longestPalindrome("abcdef"));
    }

    @Test
    void mixedCaseSensitivity() {
        // 'A' and 'a' are different characters
        // "Aa" -> only 1 pair-able + 1 center = 1
        assertEquals(1, lp.longestPalindrome("Aa"));
    }

    @Test
    void twoCharactersSame() {
        assertEquals(2, lp.longestPalindrome("bb"));
    }

    @Test
    void twoCharactersDifferent() {
        assertEquals(1, lp.longestPalindrome("ab"));
    }

    @Test
    void oddCountsWithPairedPortions() {
        // "ccc" -> "ccc" (length 3: 2 paired + 1 center)
        assertEquals(3, lp.longestPalindrome("ccc"));
    }

    @Test
    void leetcodeExample() {
        // Classic LeetCode 409 example
        assertEquals(7, lp.longestPalindrome("abccccdd"));
    }

    @Test
    void entireStringIsPalindrome() {
        // "racecar" has r:2, a:2, c:2, e:1 -> 6 paired + 1 center = 7
        assertEquals(7, lp.longestPalindrome("racecar"));
    }

    @Test
    void longRepeatedString() {
        // "aaabbbccc" -> a:3, b:3, c:3 -> 2+2+2 paired + 1 center = 7
        assertEquals(7, lp.longestPalindrome("aaabbbccc"));
    }
}
