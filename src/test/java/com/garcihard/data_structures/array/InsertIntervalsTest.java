package com.garcihard.data_structures.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class InsertIntervalsTest {

    @Test
    void insertIntervalTest() {
        int[][] inter1 = {{1,3},{6,9}};
        int[] newInt1 = {2,5};
        int[][] res1 = {{1,5},{6,9}};

        int[][] inter2 = {{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] newInt2 = {4,8};
        int[][] res2 = {{1,2},{3,10},{12,16}};

        assertArrayEquals(res1, InsertInterval.insert(inter1, newInt1));
        assertArrayEquals(res2, InsertInterval.insert(inter2, newInt2));
    }
}
