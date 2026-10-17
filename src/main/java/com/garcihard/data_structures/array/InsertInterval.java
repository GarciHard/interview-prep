package com.garcihard.data_structures.array;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
    public static int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> list = new ArrayList<>();

        for (int [] arr : intervals) {
            if (arr[1] < newInterval[0]) {
                list.add(arr);
            } else if (arr[0] > newInterval[1]) {
                int[] aux = newInterval;
                newInterval = arr;
                list.add(aux);
            } else {
                int min = Math.min(arr[0], newInterval[0]);
                int max = Math.max(arr[1], newInterval[1]);
                newInterval = new int[]{min, max};
            }
        }
        list.add(newInterval);

        return list.toArray(new int[0][]);
/*
        int l = newInterval[0], r = newInterval[1];

        ArrayList<int[]> list = new ArrayList<>();

        for ( int[] intList : intervals ) {
            int[] tmpArr = new int[newInterval.length];

            for ( int i = 0; i < intList.length; i++ ) {
                if (i == 0) {
                    tmpArr[i] = intList[i];
                }
                if (i == 1) {
                    if ( intList[i] < newInterval[i] ) {
                        tmpArr[i] = newInterval[i];
                    } else {
                        tmpArr[i] = intList[i];
                    }
                }
            }
            list.add(tmpArr);
        }



        for (int[] inter : intervals) {
            int i = 0;
            while( i < inter.length - 1) {
                if ( inter[i] < l ) {
                    if ( l < inter[i+1] ) {
                        int[] newArr = {inter[i], l, inter[i+1]};
                        inter = newArr;
                    }
                }
                i++;
            }
        }
        return intervals;
 */
    }
}
