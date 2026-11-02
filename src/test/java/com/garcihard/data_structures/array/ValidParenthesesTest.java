package com.garcihard.data_structures.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidParenthesesTest {

    private final ValidParentheses validParentheses = new ValidParentheses();

    // --- Valid cases ---

    @Test
    void emptyStringIsValid() {
        assertTrue(validParentheses.isValid(""));
    }

    @Test
    void singlePairParentheses() {
        assertTrue(validParentheses.isValid("()"));
    }

    @Test
    void singlePairBrackets() {
        assertTrue(validParentheses.isValid("[]"));
    }

    @Test
    void singlePairBraces() {
        assertTrue(validParentheses.isValid("{}"));
    }

    @Test
    void nestedBrackets() {
        assertTrue(validParentheses.isValid("{[()]}"));
    }

    @Test
    void consecutivePairs() {
        assertTrue(validParentheses.isValid("()[]{}"));
    }

    @Test
    void complexNestedValid() {
        assertTrue(validParentheses.isValid("[{()}](){}"));
    }

    // --- Invalid cases ---

    @Test
    void singleOpeningBracket() {
        assertFalse(validParentheses.isValid("("));
    }

    @Test
    void singleClosingBracket() {
        assertFalse(validParentheses.isValid(")"));
    }

    @Test
    void mismatchedTypes() {
        assertFalse(validParentheses.isValid("(]"));
    }

    @Test
    void wrongClosingOrder() {
        assertFalse(validParentheses.isValid("([)]"));
    }

    @Test
    void extraClosingBracket() {
        assertFalse(validParentheses.isValid("())"));
    }

    @Test
    void extraOpeningBracket() {
        assertFalse(validParentheses.isValid("(()"));
    }

    @Test
    void closingBeforeOpening() {
        assertFalse(validParentheses.isValid("}{"));
    }

    @Test
    void multipleUnclosedOpening() {
        assertFalse(validParentheses.isValid("(((("));
    }

    @Test
    void multipleUnmatchedClosing() {
        assertFalse(validParentheses.isValid("))))"));
    }
}
