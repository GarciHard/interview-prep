package com.garcihard.data_structures.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongestSubstringWithoutRepeatingCharactersTest {

    private final LongestSubstringWithoutRepeatingCharacters solution =
            new LongestSubstringWithoutRepeatingCharacters();

    @Test
    void slidingWindowWithRepeats() {
        // "abc" is the longest substring without repeating characters
        assertEquals(3, solution.lengthOfLongestSubstring("abcabcbb"));
    }

    @Test
    void allSameCharacters() {
        // Every character is 'b', so the longest is 1
        assertEquals(1, solution.lengthOfLongestSubstring("bbbbb"));
    }

    @Test
    void repeatAfterGap() {
        // "wke" is the longest substring without repeating characters
        assertEquals(3, solution.lengthOfLongestSubstring("pwwkew"));
    }

    @Test
    void emptyString() {
        assertEquals(0, solution.lengthOfLongestSubstring(""));
    }

    @Test
    void singleCharacter() {
        assertEquals(1, solution.lengthOfLongestSubstring("a"));
    }

    @Test
    void allUniqueCharacters() {
        assertEquals(5, solution.lengthOfLongestSubstring("abcde"));
    }

    @Test
    void twoCharactersAlternating() {
        // "ab" repeats, longest unique window is 2
        assertEquals(2, solution.lengthOfLongestSubstring("ababab"));
    }

    @Test
    void repeatAtEnd() {
        assertEquals(3, solution.lengthOfLongestSubstring("abca"));
    }

    @Test
    void longestWindowInMiddle() {
        // "abcd" in the middle is the longest
        assertEquals(4, solution.lengthOfLongestSubstring("aabcdd"));
    }

    @Test
    void stringWithSpacesAndSymbols() {
        // "a b" has 3 unique characters (including the space)
        assertEquals(3, solution.lengthOfLongestSubstring("a b a"));
    }

    @Test
    void stringWithDigits() {
        assertEquals(10, solution.lengthOfLongestSubstring("1234567890"));
    }
}
