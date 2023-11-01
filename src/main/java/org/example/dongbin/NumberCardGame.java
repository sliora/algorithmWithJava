package org.example.dongbin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class NumberCardGame {
    static public void numberCardGame() throws IOException{
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); //ROW
        int M = sc.nextInt(); //COL

        sc.nextLine();

        int result = 0;

        for(int i = 0; i < N; i++) {
            int min_value = 10001;

            //String[] strArr = sc.nextLine().split(" ");
            //int[] intArr = Arrays.stream(strArr).mapToInt(Integer::parseInt).toArray();

            for(int j = 0; j < M; j ++) {
                int input = sc.nextInt();
                min_value = Math.min(input, min_value);
            }
            result = Math.max(min_value, result);
        }
        System.out.println("result = " + result);
    }



}
