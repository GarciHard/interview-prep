package com.garcihard.data_structures.array;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ThreeSumTest {

    @Test
    @DisplayName("Example from main: [-1, 0, 1, 2, -1, -4]")
    void threeSumExampleInput() {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = ThreeSum.threeSum(nums);

        // Sorted: [-4, -1, -1, 0, 1, 2]
        // Valid triplets: [-1, -1, 2] and [-1, 0, 1]
        assertEquals(2, result.size());
        assertTrue(result.contains(List.of(-1, -1, 2)));
        assertTrue(result.contains(List.of(-1, 0, 1)));
    }

    @Test
    @DisplayName("Exactly three elements that sum to zero")
    void threeSumExactlyThreeElementsSumToZero() {
        int[] nums = {-1, 0, 1};
        List<List<Integer>> result = ThreeSum.threeSum(nums);

        assertEquals(1, result.size());
        assertEquals(List.of(-1, 0, 1), result.get(0));
    }

    @Test
    @DisplayName("Exactly three elements that do NOT sum to zero")
    void threeSumExactlyThreeElementsNoSum() {
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = ThreeSum.threeSum(nums);

        assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("All zeros: [0, 0, 0]")
    void threeSumAllZeros() {
        int[] nums = {0, 0, 0};
        List<List<Integer>> result = ThreeSum.threeSum(nums);

        assertEquals(1, result.size());
        assertEquals(List.of(0, 0, 0), result.get(0));
    }

    @Test
    @DisplayName("All zeros with more elements: [0, 0, 0, 0]")
    void threeSumMultipleZeros() {
        int[] nums = {0, 0, 0, 0};
        List<List<Integer>> result = ThreeSum.threeSum(nums);

        assertEquals(1, result.size());
        assertEquals(List.of(0, 0, 0), result.get(0));
    }

    @Test
    @DisplayName("No triplets sum to zero")
    void threeSumNoValidTriplets() {
        int[] nums = {1, 2, 3, 4, 5};
        List<List<Integer>> result = ThreeSum.threeSum(nums);

        assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("Negative numbers only, no triplet sums to zero")
    void threeSumAllNegative() {
        int[] nums = {-5, -3, -1, -2};
        List<List<Integer>> result = ThreeSum.threeSum(nums);

        assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("Positive numbers only, no triplet sums to zero")
    void threeSumAllPositive() {
        int[] nums = {1, 3, 5, 7};
        List<List<Integer>> result = ThreeSum.threeSum(nums);

        assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("Multiple valid triplets found")
    void threeSumMultipleTriplets() {
        int[] nums = {-1, 0, 1, -2, 1, 1};
        List<List<Integer>> result = ThreeSum.threeSum(nums);

        // Sorted: [-2, -1, 0, 1, 1, 1]
        // Valid unique triplets: [-2, 1, 1] and [-1, 0, 1]
        assertEquals(2, result.size());
        assertTrue(result.contains(List.of(-2, 1, 1)));
        assertTrue(result.contains(List.of(-1, 0, 1)));
    }

    @Test
    @DisplayName("Four elements with exactly one valid triplet")
    void threeSumFourElements() {
        int[] nums = {-3, 1, 2, 5};
        List<List<Integer>> result = ThreeSum.threeSum(nums);

        // Sorted: [-3, 1, 2, 5] → triplet [-3, 1, 2] sums to 0
        assertEquals(1, result.size());
        assertEquals(List.of(-3, 1, 2), result.get(0));
    }

    @Test
    @DisplayName("Large values that sum to zero")
    void threeSumLargeValues() {
        int[] nums = {1000000, -500000, -500000};
        List<List<Integer>> result = ThreeSum.threeSum(nums);

        // Sorted: [-500000, -500000, 1000000]
        assertEquals(1, result.size());
        assertEquals(List.of(-500000, -500000, 1000000), result.get(0));
    }

    @Test
    @DisplayName("Two elements — too few for a triplet")
    void threeSumTwoElements() {
        int[] nums = {1, -1};
        List<List<Integer>> result = ThreeSum.threeSum(nums);

        assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("Single element array")
    void threeSumSingleElement() {
        int[] nums = {0};
        List<List<Integer>> result = ThreeSum.threeSum(nums);

        assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("Empty array returns empty list")
    void threeSumEmptyArray() {
        int[] nums = {};
        List<List<Integer>> result = ThreeSum.threeSum(nums);

        assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("Triplet found at the end of the array")
    void threeSumTripletAtEnd() {
        int[] nums = {5, 5, -1, 0, 1};
        List<List<Integer>> result = ThreeSum.threeSum(nums);

        // Sorted: [-1, 0, 1, 5, 5] → triplet [-1, 0, 1] sums to 0
        assertEquals(1, result.size());
        assertTrue(result.contains(List.of(-1, 0, 1)));
    }
}
