package org.example.dongbin;

import java.util.*;

public class LawOfLargeNumber {
    public static void lawOfLargeNumber() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); //배열의 크기
        int M = sc.nextInt(); //숫자가 더해질 횟수
        int K = sc.nextInt(); //연속해서 가능한 최대 수
        sc.nextLine();

        String[] input = sc.nextLine().split(" ");
        int[] intInput = Arrays.stream(input)
                .mapToInt(Integer::parseInt)
                .boxed()
                .sorted(Collections.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();

        int result = 0;

        for (int i = 1; i <= M; i ++) {
            if(i % K == 0) {
                result += intInput[1];
            } else {
                result += intInput[0];
            }
        }

        System.out.print(result);
    }
}
