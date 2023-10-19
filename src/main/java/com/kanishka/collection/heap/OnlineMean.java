package com.kanishka.collection.heap;

import java.util.PriorityQueue;

public class OnlineMean {
    final PriorityQueue<Integer> maxHeap = new PriorityQueue<>((n1, n2) -> n2 - n1);
    final PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    public float add(int num) {
        if (maxHeap.size() == minHeap.size()) {
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }
        if (minHeap.isEmpty()) {
            return maxHeap.element();
        }

        if (minHeap.element() < maxHeap.element()) {
            int tmp = minHeap.remove();
            minHeap.add(maxHeap.remove());
            maxHeap.add(tmp);
        }

        if (maxHeap.size() == minHeap.size()) {
            return ((float) maxHeap.element() + minHeap.element())/2;
        }
        return maxHeap.element();
    }
}
