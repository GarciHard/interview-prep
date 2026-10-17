package com.garcihard.data_structures.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MergeIntervalsTest {

    @Test
    void mergeIntervalsTest() {

        int[][] inter0 = {{2,3},{4,5},{6,7},{8,9},{1,10}};
        int[][] res0 = {{1,10}};

        assertArrayEquals(res0, MergeIntervals.merge(inter0));
    }
}
