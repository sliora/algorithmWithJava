package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] citations = {3,0,6,1,5};
        //hIndex(citations);
        //System.out.println("hIndex(citations) = " + hIndex(citations));
        int[][] matrix = {{1,5,9},{10,11,13},{12,13,15}};
        int k = 8;

        System.out.println("kthSmallest() = " + kthSmallest(matrix, k));

    }

    /***
     * Given an array of integers citations where citations[i] is the number of citations a researcher received for their ith paper, return the researcher's h-index.
     * According to the definition of h-index on Wikipedia: The h-index is defined as the maximum value of h such that the given researcher has published at least h papers that have each been cited at least h times.
     */
    public static int hIndex(int[] citations) {
        int citationsLength = citations.length;
        Arrays.sort(citations);

        for (int i = 0; i < citationsLength; i++) {
            if (citations[i] >= (citationsLength - i)) {
                return citationsLength - i;
            }
        }
        return 0;
    }

    public static int kthSmallest(int[][] matrix, int k) {
        int matrixLength = matrix.length;
        int start = matrix[0][0];
        int end = matrix[matrixLength - 1][matrixLength - 1];

        while (start < end) {
            int mid = start + (end - start) / 2;
            int count = 0;
            int j = matrixLength - 1;
            for (int i = 0; i < matrixLength; i++) {
                while (j >= 0 && matrix[i][j] > mid) {
                    j--;
                }
                count += (j + 1);
            }
            if (count < k) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }
}