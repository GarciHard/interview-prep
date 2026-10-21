package com.garcihard.data_structures.array;

import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();

        findSum(0, candidates, target, new Stack<>(), 0, result);

        return result;
    }

    private void findSum(int idx, int[]candidates, int target, Stack<Integer> path, int accSum, List<List<Integer>> results) {

        if ( accSum == target ) {
            results.add(new ArrayList<>(path));
            return;
        }

        if ( accSum > target || idx == candidates.length ) {
            return;
        }

        int candidate = candidates[idx];
        path.push(candidate);

        findSum(idx, candidates, target, path, accSum + candidate, results);
        path.pop();

        findSum(idx + 1, candidates, target, path, accSum, results);

    }
}

/* [[2], 3, 6, 7] -> target = 7
   p = [2, 2, 3] -> stack or list of Integer
   acc = 2
   idx = 0

          2    -> 7 - 2 = 5
        /   \
       2       -> 5 - 2 = 3
     /  \
    2    3     -> 6 = 7 N | 7 = 7 Y
  /  \
 2    3        -> 8 = 7 N | 9 = 7 N

*/
