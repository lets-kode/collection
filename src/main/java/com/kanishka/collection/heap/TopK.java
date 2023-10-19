package com.kanishka.collection.heap;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class TopK {
    public static List<String> topK(Iterator<String> iterator, int k) {
        if (iterator == null || k <= 0) {
            throw new IllegalArgumentException("iterator can't be null; k must be greater than 0");
        }
        final PriorityQueue<String> minHeap = new PriorityQueue<>();
        while(iterator.hasNext()) {
            final String current = iterator.next();
            if (minHeap.size() == k) {
                if (minHeap.peek().length() < current.length()) {
                    minHeap.poll();
                }
            }
            minHeap.offer(current);
        }
        return new ArrayList<>(minHeap);
    }
}
