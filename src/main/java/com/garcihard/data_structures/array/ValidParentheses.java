package com.garcihard.data_structures.array;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

public class ValidParentheses {
    public boolean isValid(String s) {
        Map<Character, Character> brackets = Map.of(')','(',']','[','}','{');
        Deque<Character> stack = new ArrayDeque<>();

        for ( char c : s.toCharArray() ) {
            if ( c == '(' || c == '[' || c == '{' ) {
                stack.addFirst(c);
            } else {
                if ( stack.isEmpty() || stack.removeFirst() != brackets.get(c) ) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
