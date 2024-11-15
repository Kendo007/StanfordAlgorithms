package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Inversion {
    private static long inversionCount = 0;

    private static int[] countHelper(int[] arr, int start, int end) {
        if (end == start) {
            return new int[]{arr[start]};
        }

        int mid = start + (end - start) / 2;
        int[] left = countHelper(arr, start, mid);
        int[] right = countHelper(arr, mid + 1, end);
        int[] merged = new int[end - start + 1];

        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                merged[k++] = left[i++];
            } else {
                merged[k++] = right[j++];
                inversionCount += left.length - i;
            }
        }

        while (i < left.length) {
            merged[k++] = left[i++];
        }

        while (j < right.length) {
            merged[k++] = right[j++];
        }

        return merged;
    }

    public static long count(int[] arr) {
        inversionCount = 0;
        countHelper(arr, 0, arr.length - 1);
        return inversionCount;
    }

    public static void main(String[] args) throws FileNotFoundException {
        int[] arr = new int[100000];

        File file = new File("src/main/java/org/example/IntegerArray.txt");
        Scanner scanner = new Scanner(file);

        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println(count(arr)); // Output: 5
    }
}