package org.example;

public class SecondLargest {
    private static class Pair {
        int first, second;
        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    private static Pair largestHelper(int[] arr, int start, int end) {
        if (end - start == 2) {
            if (arr[start] > arr[end - 1]) {
                return new Pair(arr[start], arr[end - 1]);
            } else {
                return new Pair(arr[end - 1], arr[start]);
            }
        } else if (end - start == 1) {
            return new Pair(arr[start], Integer.MIN_VALUE);
        }

        Pair left = largestHelper(arr, start, (start + end) / 2);
        Pair right = largestHelper(arr, (start + end) / 2, end);

        if (left.first > right.first) {
            if (left.second > right.first) {
                return new Pair(left.first, left.second);
            } else {
                return new Pair(left.first, right.first);
            }
        } else {
            if (right.second > left.first) {
                return new Pair(right.first, right.second);
            } else {
                return new Pair(right.first, left.first);
            }
        }
    }

    public static int largest(int[] arr) {
        if (arr.length < 2) {
            throw new IllegalArgumentException("Array must have at least two elements");
        }

        return largestHelper(arr, 0, arr.length).second;
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 7, 6, 5};
        int result = largest(arr);

        System.out.println(result);
    }
}