package org.example.leetcode;

public class KthSmallestElementInSortedMatrix {
    /**
     * No.378
     * Given an n x n matrix where each of the rows and columns is sorted in ascending order, return the kth smallest element in the matrix.
     * Note that it is the kth smallest element in the sorted order, not the kth distinct element.
     * You must find a solution with a memory complexity better than O(n2).
     * https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
     */
    public int findKthSmallest(int[][] matrix, int k) {
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
