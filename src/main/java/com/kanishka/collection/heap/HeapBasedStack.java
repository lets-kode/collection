package com.kanishka.collection.heap;

import java.util.NoSuchElementException;
import java.util.PriorityQueue;

public class HeapBasedStack<E extends Comparable<E>> {
    private final PriorityQueue<Item<E>> maxHeap = new PriorityQueue<>();

    public E top() {
        return maxHeap.element().value;
    }

    public E push(E value) {
        final int index = (maxHeap.isEmpty() ? 0 : maxHeap.peek().index + 1);
        maxHeap.add(new Item<>(index, value));
        return value;
    }

    public E pop() {
        if (maxHeap.isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        return maxHeap.poll().value;
    }

    public int size() {
        return maxHeap.size();
    }
    private static class Item<T extends Comparable<T>> implements Comparable<Item<T>> {
        final int index;
        final T value;

        public Item(int index, T value) {
            this.index = index;
            this.value = value;
        }

        @Override
        public int compareTo(Item<T> o) {
            return o.value.compareTo(this.value);
        }
    }
}
