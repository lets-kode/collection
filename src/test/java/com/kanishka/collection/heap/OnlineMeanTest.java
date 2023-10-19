package com.kanishka.collection.heap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class OnlineMeanTest {
    @Test
    void add() {
        OnlineMean onlineMean = new OnlineMean();
        Assertions.assertEquals(1.0f, onlineMean.add(1));
        Assertions.assertEquals(0.5f, onlineMean.add(0));
        Assertions.assertEquals(1.0f, onlineMean.add(3));
        Assertions.assertEquals(2.0f, onlineMean.add(5));
        Assertions.assertEquals(2.0f, onlineMean.add(2));
        Assertions.assertEquals(1.5f, onlineMean.add(0));
        Assertions.assertEquals(1.0f, onlineMean.add(1));
    }
}