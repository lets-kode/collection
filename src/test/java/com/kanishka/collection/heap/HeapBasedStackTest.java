package com.kanishka.collection.heap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

class HeapBasedStackTest {

    @Test
    void pop() {
        HeapBasedStack<Float> stack = new HeapBasedStack<>();
        stack.push(1.0f);
        Assertions.assertEquals(1.0f, stack.pop());
    }

    @Test
    void push() {
        HeapBasedStack<Integer> stack = new HeapBasedStack<>();
        Assertions.assertEquals(1, stack.push(1));
    }

    @Test
    void top() {
        HeapBasedStack<Long> stack = new HeapBasedStack<>();
        stack.push(10L);
        Assertions.assertEquals(10L, stack.top());
    }

    @Test
    void size() {
        HeapBasedStack<String> stack = new HeapBasedStack<>();
        stack.push("CAT");
        Assertions.assertEquals(1, stack.size());
    }

    @Test
    public void multiPopStr() {
        HeapBasedStack<String> stack = new HeapBasedStack<>();
        stack.push("CAT");
        stack.push("DOG");
        Assertions.assertEquals("DOG", stack.pop());
        Assertions.assertEquals("CAT", stack.pop());
    }

    @Test
    public void multiPopInt() {
        HeapBasedStack<Integer> stack = new HeapBasedStack<>();
        stack.push(5);
        stack.push(10);
        Assertions.assertEquals(10, stack.pop());
        Assertions.assertEquals(5, stack.pop());
    }

    @Test
    public void invalidUsage() {
        try {
            new HeapBasedStack<Integer>().pop();
            Assertions.fail();
        } catch (NoSuchElementException ignored) {}

        try {
            new HeapBasedStack<Integer>().top();
            Assertions.fail();
        } catch (NoSuchElementException ignored) {}
    }
}