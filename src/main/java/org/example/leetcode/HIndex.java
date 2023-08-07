package org.example.leetcode;

import java.util.Arrays;

public class HIndex {

    /**
     *
     *
     *
     *
     */
    public  int findHIndex(int[] citations) {
        int citationsLength = citations.length;
        Arrays.sort(citations);

        for (int i = 0; i < citationsLength; i++) {
            if (citations[i] >= (citationsLength - i)) {
                return citationsLength - i;
            }
        }
        return 0;
    }
}
