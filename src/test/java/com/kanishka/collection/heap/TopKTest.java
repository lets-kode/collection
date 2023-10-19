package com.kanishka.collection.heap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class TopKTest {
    @Test
    public void testInvalidInput() {
        try {
            TopK.topK(null, 1);
            Assertions.fail();
        } catch (IllegalArgumentException ignored) {
        }
        try {
            TopK.topK(List.of("hello").iterator(), 0);
            Assertions.fail();
        } catch (IllegalArgumentException ignored) {
        }
    }

    @Test
    void testSingleStringInput() {
        validateSingleResult("hello", 1);
        validateSingleResult("world", 5);
    }

    private static void validateSingleResult(String expectedString, int k) {
        List<String> result = TopK.topK(List.of(expectedString).iterator(), k);
        Assertions.assertEquals(1, result.size());
        Assertions.assertEquals(expectedString, result.get(0));
    }

    @Test
    void testMultipleResults() {
        final String one = "one";
        final String three = "three";
        final String five = "five";
        final int expectedResults = 2;
        final List<String> result = TopK.topK(List.of(one, three, five).iterator(), expectedResults);
        Assertions.assertEquals(expectedResults, result.size());

        final Set<String> resultSet = new HashSet<>(result);
        Assertions.assertEquals(Set.of(three, five), resultSet);
    }

    @Test
    void testDuplicateValues() {
        final String one = "one";
        final String three = "three";
        final String threeDuplicate = "three";
        final int expectedResults = 2;
        final List<String> result = TopK.topK(List.of(one, three, threeDuplicate).iterator(), expectedResults);
        Assertions.assertEquals(expectedResults, result.size());

        final Set<String> resultSet = new HashSet<>(result);
        Assertions.assertEquals(Set.of(three), resultSet);
    }

    @Test
    void testCaseIndependence() {
        final String one = "one";
        final String three = "three";
        final String threeDuplicate = "THREE";
        final int expectedResults = 2;
        final List<String> result = TopK.topK(List.of(one, three, threeDuplicate).iterator(), expectedResults);
        Assertions.assertEquals(expectedResults, result.size());

        final Set<String> resultSet = new HashSet<>(result);
        Assertions.assertEquals(Set.of(three, threeDuplicate), resultSet);
    }
}