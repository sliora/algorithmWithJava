package org.example.dongbin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class UpDownLeftRight {
    public static void upDownLeftRight() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        int row = 1;
        int col = 1;

        int[] dr = {0, 0, -1, 1};
        int[] dc = {-1, 1, 0, 0};

        String[] move_type = {"L", "R", "U", "D"};

        for (int i = 0; i < input.length; i ++) {
            for(int j = 0; j < move_type.length; j++) {
                if(input[i].equals(move_type[j])) {

                    int nextRow = row + dr[j];
                    int nextCol = col + dc[j];

                    //가면 안되는 곳 처리
                    if (N >= nextRow && nextRow > 0 && N >= nextCol && nextCol > 0) {
                        row = nextRow;
                        col = nextCol;
                    }
                    break;
                }
            }
        }

        System.out.println("row = " + row);
        System.out.println("col = " + col);
    }
}
