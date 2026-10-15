package com.garcihard.data_structures.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValidAnagramTest {

    @Test
    void validAnagramTestScenarios() {
        String str1 = "anagram";
        String aux1 = "nagaram";
        boolean out1 = true;

        String str2 = "rat";
        String aux2 = "car";
        boolean out2 = false;

        assertEquals(out1, ValidAnagram.isAnagram(str1, aux1));
        assertEquals(out2, ValidAnagram.isAnagram(str2, aux2));
    }
}
