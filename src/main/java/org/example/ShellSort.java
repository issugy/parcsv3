package org.example;

import parcs.AM;
import parcs.AMInfo;
import java.util.Random;

public class ShellSort implements AM {
    public void run(AMInfo info) {
        int[] array = generateRandomArray(10_000_000);  // Збільшення розміру масиву до 100000
        System.out.println("Unsorted array (first 20 elements): ");
        printArray(array, 20);

        long startTime = System.currentTimeMillis();
        shellSort(array);
        long endTime = System.currentTimeMillis();

        System.out.println("Sorted array (first 20 elements): ");
        printArray(array, 20);

        System.out.println("Array length: " + array.length);
        System.out.println("Sorting took " + (endTime - startTime) + " milliseconds.");
    }

    private int[] generateRandomArray(int size) {
        Random rand = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt(10_000_000) - 10_000_000;  // Випадкові числа від -5000 до 4999
        }
        return array;
    }

    public static void shellSort(int[] array) {
        int n = array.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i += 1) {
                int temp = array[i];
                int j;
                for (j = i; j >= gap && array[j - gap] > temp; j -= gap) {
                    array[j] = array[j - gap];
                }
                array[j] = temp;
            }
        }
    }

    private void printArray(int[] array, int limit) {
        for (int i = 0; i < Math.min(array.length, limit); i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
