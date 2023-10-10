package org.example.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class CountSubIslands {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int row = grid2.length;
        int col = grid2[0].length;
        boolean[][] visited = new boolean[row][col];
        int count = 0;

        // grid2의 각 셀을 반복하며 탐색
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // 해당 셀이 땅이고 방문하지 않았다면 BFS 시작
                if (grid2[i][j] == 1 && !visited[i][j]) {
                    // BFS 결과가 true라면, grid2의 섬은 grid1의 섬의 부분 집합이다.
                    if (bfs(grid1, grid2, visited, i, j)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private boolean bfs(int[][] grid1, int[][] grid2, boolean[][] visited, int x, int y) {
        int m = grid2.length;
        int n = grid2[0].length;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});

        //방문한 곳은 true 값으로 모두 할당
        visited[x][y] = true;
        boolean isValid = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];

            // 상하좌우 탐색
            for (int i = 0; i < 4; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                //X는 0부터 M 미만, Y는 0부터 n 미만
                if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n)
                    //땅만 가야함, 방문한 곳 가면 안됨
                    if(grid2[nextX][nextY] == 1 && !visited[nextX][nextY]) {
                    visited[nextX][nextY] = true;
                    queue.offer(new int[]{nextX, nextY});
                }
            }

            // grid2의 현재 셀이 grid1에 없다면, 부분 섬이 될 수 없다.
            if (grid1[curX][curY] == 0) {
                isValid = false;
            }
        }
        return isValid;
    }
}
