package org.example;

import static org.junit.jupiter.api.Assertions.*;

class SecondLargestTest {

    @org.junit.jupiter.api.Test
    void SecondLarges() {
        int[] arr = {1, 4, 7, 6, 5};

        assertEquals(6, SecondLargest.largest(arr));
    }

    @org.junit.jupiter.api.Test
    public void testNormalCase() {
        int[] input = {1, 3, 4, 5, 0, 2};
        assertEquals(4, SecondLargest.largest(input), "The second largest number should be 4");
    }

    @org.junit.jupiter.api.Test
    public void testAllNegativeNumbers() {
        int[] input = {-10, -20, -3, -7, -15};
        assertEquals(-7, SecondLargest.largest(input), "The second largest number should be -7");
    }

    @org.junit.jupiter.api.Test
    public void testMixedPositiveAndNegativeNumbers() {
        int[] input = {10, -20, 15, 5, 0};
        assertEquals(10, SecondLargest.largest(input), "The second largest number should be 10");
    }

    @org.junit.jupiter.api.Test
    public void testArrayWithTwoElements() {
        int[] input = {1, 2};
        assertEquals(1, SecondLargest.largest(input), "The second largest number should be 1");
    }

}