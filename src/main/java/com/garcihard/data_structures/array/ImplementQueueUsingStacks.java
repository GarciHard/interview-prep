package com.garcihard.data_structures.array;

import java.util.Stack;

public class ImplementQueueUsingStacks {

    Stack<Integer> pila;
    Stack<Integer> cola;

    public MyQueue() {
        pila = new Stack<>();
        cola = new Stack<>();
    }

    public void push(int x) {
        pila.push(x);
    }

    public int pop() {
        peek();
        return cola.pop();
    }

    public int peek() {
        if ( cola.isEmpty() ) {
            while ( !pila.isEmpty() ) {
                cola.push(pila.pop());
            }
        }
        return cola.peek();
    }

    public boolean empty() {
        return pila.isEmpty() && cola.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */