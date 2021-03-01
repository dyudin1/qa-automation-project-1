package ru.dyudin.homework;

import java.util.Arrays;

public class ThanosSort {

    static int[] sortByHalves(int[] notSortedArray) {
        int[] sortedArray = Arrays.copyOf(notSortedArray, notSortedArray.length);

        if (notSortedArray.length > 2) {

            notSortedArray = trySortArray(notSortedArray);

            int cache = 0;
            for (int j : notSortedArray) {
                cache = cache + j;
            }
            double meanNum = (double) cache / notSortedArray.length;
            int leftHalf = 0;
            for (int l : notSortedArray) {
                if (l <= meanNum) {
                    leftHalf++;
                }
            }

            int[] cacheFirstHalf = Arrays.copyOfRange(notSortedArray, 0, leftHalf);
            int[] cacheSecondHalf = Arrays.copyOfRange(notSortedArray, leftHalf, notSortedArray.length);

            if (sortedArray.length - cacheFirstHalf.length > 0) {
                System.arraycopy(sortByHalves(cacheFirstHalf), 0, sortedArray, 0, cacheFirstHalf.length);
            }
            if (sortedArray.length - cacheSecondHalf.length > 0) {
                System.arraycopy(sortByHalves(cacheSecondHalf), 0, sortedArray,
                        sortedArray.length - cacheSecondHalf.length, cacheSecondHalf.length);
            }

            return sortedArray;
        }

        return trySortArray(notSortedArray);
    }

    static int[] trySortArray(int[] notSortedArray) {

        if (notSortedArray.length < 2) {
            return notSortedArray;
        }

        int cache = 0;
        for (int j : notSortedArray) {
            cache = cache + j;
        }
        double meanNum = (double) cache / notSortedArray.length;

        int[] sortedArray = Arrays.copyOf(notSortedArray, notSortedArray.length);
        int x = 0;
        int y = notSortedArray.length - 1;

        for (int j : notSortedArray) {
            if (j <= meanNum) {
                sortedArray[x++] = j;
            } else {
                sortedArray[y--] = j;
            }
        }

        return sortedArray;
    }
}
