package com.garcihard.data_structures.array;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CombinationSumTest {

    private CombinationSum combinationSum;

    @BeforeEach
    void setUp() {
        combinationSum = new CombinationSum();
    }

    @Test
    public void shouldFindCombinationsForBasicCase() {
        // LeetCode example 1: candidates = [2,3,6,7], target = 7
        int[] candidates = {2, 3, 6, 7};
        int target = 7;

        List<List<Integer>> result = combinationSum.combinationSum(candidates, target);

        assertEquals(2, result.size());
        assertTrue(result.contains(List.of(2, 2, 3)));
        assertTrue(result.contains(List.of(7)));
    }

    @Test
    public void shouldFindCombinationsWithRepeatedElements() {
        // LeetCode example 2: candidates = [2,3,5], target = 8
        int[] candidates = {2, 3, 5};
        int target = 8;

        List<List<Integer>> result = combinationSum.combinationSum(candidates, target);

        assertEquals(3, result.size());
        assertTrue(result.contains(List.of(2, 2, 2, 2)));
        assertTrue(result.contains(List.of(2, 3, 3)));
        assertTrue(result.contains(List.of(3, 5)));
    }

    @Test
    public void shouldReturnEmptyListWhenNoCombinationExists() {
        // No combination can sum to 1 with candidate [2]
        int[] candidates = {2};
        int target = 1;

        List<List<Integer>> result = combinationSum.combinationSum(candidates, target);

        assertTrue(result.isEmpty());
    }

    @Test
    public void shouldHandleSingleCandidateEqualToTarget() {
        int[] candidates = {7};
        int target = 7;

        List<List<Integer>> result = combinationSum.combinationSum(candidates, target);

        assertEquals(1, result.size());
        assertEquals(List.of(7), result.get(0));
    }

    @Test
    public void shouldHandleSingleCandidateUsedMultipleTimes() {
        int[] candidates = {3};
        int target = 9;

        List<List<Integer>> result = combinationSum.combinationSum(candidates, target);

        assertEquals(1, result.size());
        assertEquals(List.of(3, 3, 3), result.get(0));
    }

    @Test
    public void shouldReturnEmptyListWhenCandidatesAreAllLargerThanTarget() {
        int[] candidates = {5, 10, 15};
        int target = 3;

        List<List<Integer>> result = combinationSum.combinationSum(candidates, target);

        assertTrue(result.isEmpty());
    }

    @Test
    public void shouldHandleTargetOfOne() {
        int[] candidates = {1};
        int target = 1;

        List<List<Integer>> result = combinationSum.combinationSum(candidates, target);

        assertEquals(1, result.size());
        assertEquals(List.of(1), result.get(0));
    }

    @Test
    public void shouldHandleMultipleCandidatesWithOnlyOneValidCombination() {
        int[] candidates = {2, 4, 6};
        int target = 6;

        List<List<Integer>> result = combinationSum.combinationSum(candidates, target);

        // Possible: [2,2,2], [2,4], [6]
        assertEquals(3, result.size());
        assertTrue(result.contains(List.of(2, 2, 2)));
        assertTrue(result.contains(List.of(2, 4)));
        assertTrue(result.contains(List.of(6)));
    }

    @Test
    public void shouldReturnEmptyListForEmptyCandidates() {
        int[] candidates = {};
        int target = 5;

        List<List<Integer>> result = combinationSum.combinationSum(candidates, target);

        assertTrue(result.isEmpty());
    }

    @Test
    public void shouldHandleLargeTargetWithSmallCandidate() {
        int[] candidates = {1};
        int target = 5;

        List<List<Integer>> result = combinationSum.combinationSum(candidates, target);

        assertEquals(1, result.size());
        assertEquals(List.of(1, 1, 1, 1, 1), result.get(0));
    }
}
