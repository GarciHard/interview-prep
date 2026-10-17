package com.garcihard.data_structures.array;

import java.util.ArrayList;
import java.util.List;

public class MergeIntervals {
    public static int[][] merge(int[][] intervals) {
        int l = 0, r = intervals.length - 1;
        int[] auxL, auxR, auxF;

        while (l < r) {
            while (r > l) {
                auxL = intervals[l];
                auxR = intervals[r];
                if (auxL[0] > auxR[0]) {
                    auxF = intervals[r];
                    intervals[r] = intervals[l];
                    intervals[l] = auxF;
                }
                r--;
            }
            r = intervals.length - 1;
            l++;
        }

        List<int[]> list = new ArrayList<>();

        int[] auxInt = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            int[] arr = intervals[i];
            if (arr[1] < auxInt[0]) {
                list.add(arr);
            } else if (arr[0] > auxInt[1]) {
                int[] aux = auxInt;
                auxInt = arr;
                list.add(aux);
            } else {
                int min = Math.min(arr[0], auxInt[0]);
                int max = Math.max(arr[1], auxInt[1]);
                auxInt = new int[] { min, max };
            }
        }
        list.add(auxInt);

        return list.toArray(new int[0][]);
    }
}