package org.example.dongbin;

import java.util.Scanner;

public class UntilOne {
    //두 과정 중 하나를 반복적으로 선택하여 수행
    //1. N 에서 1을 뺀다
    //2. N 을 K로 나눈다.
    //1,2 번을 합하여 계산 하는 최소 횟수를 구하라
    //최소 횟수 구하는거면.. DP로 하는거랬나?
    //아니네 맞네 ㅋㅋ

    static public void untilOne() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        sc.nextLine();
        
        int count = 0;

        while (N != 1) {
            if(N % K == 0) {
                N = N / K;
            } else {
                N -= 1;
            }
            count++;
        }
        System.out.println("count = " + count);
    }

    private static void recursive() {

    }

}
