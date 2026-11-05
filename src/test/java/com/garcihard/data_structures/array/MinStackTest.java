package com.garcihard.data_structures.array;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MinStackTest {

    private MinStack minStack;

    @BeforeEach
    void setUp() {
        minStack = new MinStack();
    }

    // --- push & top ---

    @Test
    void pushSingleElementAndTop() {
        minStack.push(5);
        assertEquals(5, minStack.top());
    }

    @Test
    void pushMultipleElementsTopReturnsLast() {
        minStack.push(1);
        minStack.push(2);
        minStack.push(3);
        assertEquals(3, minStack.top());
    }

    // --- getMin basic ---

    @Test
    void getMinSingleElement() {
        minStack.push(42);
        assertEquals(42, minStack.getMin());
    }

    @Test
    void getMinReturnsSmallestAfterMultiplePushes() {
        minStack.push(3);
        minStack.push(1);
        minStack.push(2);
        assertEquals(1, minStack.getMin());
    }

    @Test
    void getMinWhenMinIsPushedFirst() {
        minStack.push(-1);
        minStack.push(0);
        minStack.push(5);
        assertEquals(-1, minStack.getMin());
    }

    @Test
    void getMinWhenMinIsPushedLast() {
        minStack.push(5);
        minStack.push(3);
        minStack.push(1);
        assertEquals(1, minStack.getMin());
    }

    // --- pop & getMin interaction ---

    @Test
    void popRemovesTopElement() {
        minStack.push(1);
        minStack.push(2);
        minStack.pop();
        assertEquals(1, minStack.top());
    }

    @Test
    void getMinUpdatesAfterPoppingCurrentMin() {
        minStack.push(2);
        minStack.push(1);
        assertEquals(1, minStack.getMin());
        minStack.pop();
        assertEquals(2, minStack.getMin());
    }

    @Test
    void getMinUnchangedAfterPoppingNonMinElement() {
        minStack.push(1);
        minStack.push(5);
        minStack.pop();
        assertEquals(1, minStack.getMin());
    }

    // --- Duplicate min values ---

    @Test
    void duplicateMinValuesHandledCorrectly() {
        minStack.push(1);
        minStack.push(1);
        minStack.push(2);
        assertEquals(1, minStack.getMin());
        minStack.pop(); // removes 2
        assertEquals(1, minStack.getMin());
        minStack.pop(); // removes second 1
        assertEquals(1, minStack.getMin());
    }

    // --- Negative numbers ---

    @Test
    void negativeNumbers() {
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        assertEquals(-3, minStack.getMin());
        minStack.pop();
        assertEquals(0, minStack.top());
        assertEquals(-2, minStack.getMin());
    }

    // --- LeetCode example sequence ---

    @Test
    void leetCodeExampleSequence() {
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        assertEquals(-3, minStack.getMin());
        minStack.pop();
        assertEquals(0, minStack.top());
        assertEquals(-2, minStack.getMin());
    }

    // --- Edge cases ---

    @Test
    void pushAndPopSingleElement() {
        minStack.push(10);
        minStack.pop();
        assertThrows(EmptyStackException.class, () -> minStack.top());
    }

    @Test
    void popOnEmptyStackThrows() {
        assertThrows(EmptyStackException.class, () -> minStack.pop());
    }

    @Test
    void topOnEmptyStackThrows() {
        assertThrows(EmptyStackException.class, () -> minStack.top());
    }

    @Test
    void getMinOnEmptyStackThrows() {
        assertThrows(EmptyStackException.class, () -> minStack.getMin());
    }

    @Test
    void pushPopPushSequence() {
        minStack.push(3);
        minStack.pop();
        minStack.push(7);
        assertEquals(7, minStack.top());
        assertEquals(7, minStack.getMin());
    }

    // --- Large sequence ---

    @Test
    void decreasingThenPoppingRestoresMin() {
        minStack.push(5);
        minStack.push(4);
        minStack.push(3);
        minStack.push(2);
        minStack.push(1);
        assertEquals(1, minStack.getMin());

        minStack.pop();
        assertEquals(2, minStack.getMin());
        minStack.pop();
        assertEquals(3, minStack.getMin());
        minStack.pop();
        assertEquals(4, minStack.getMin());
        minStack.pop();
        assertEquals(5, minStack.getMin());
    }

    @Test
    void allSameElements() {
        minStack.push(7);
        minStack.push(7);
        minStack.push(7);
        assertEquals(7, minStack.getMin());
        minStack.pop();
        assertEquals(7, minStack.getMin());
        minStack.pop();
        assertEquals(7, minStack.getMin());
    }
}
