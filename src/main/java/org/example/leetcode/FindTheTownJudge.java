package org.example.leetcode;


//997번
public class FindTheTownJudge {
    public int findJudge(int N, int[][] trust) {
        int[] inDegrees = new int[N + 1];
        int[] outDegrees = new int[N + 1];

        for (int[] pair : trust) {
            int people = pair[0];
            int townJudge = pair[1];

            outDegrees[people]++;
            inDegrees[townJudge]++;
        }

        for (int i = 1; i <= N; i++) {
            if (inDegrees[i] == N - 1 && outDegrees[i] == 0) {
                return i;
            }
        }

        return -1;
    }
}
