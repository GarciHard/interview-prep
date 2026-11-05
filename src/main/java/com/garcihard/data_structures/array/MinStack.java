package com.garcihard.data_structures.array;

import java.util.Stack;

public class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int value) {
        stack.push(value);
        if ( minStack.isEmpty() ) {
            minStack.push(value);
        } else if ( value <= minStack.peek() ) {
            minStack.push(value);
        }
    }

    public void pop() {
        int curr = stack.pop();
        if ( curr == minStack.peek() ) minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
        /*
        List<Integer> tmp = new ArrayList<>();

        while ( !pila.isEmpty() ) {
            int minT = pila.peek();
            tmp.add(minT);
            pila.pop();
        }

        for ( int i = tmp.size() - 1; i >= 0; i-- ) {
            pila.push(tmp.get(i));
        }

        Collections.sort(tmp);

        return tmp.get(0);
        */
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();

 -3
 0
 -2

 -3, 0, -2

 0
 3
 0
 2

 */
