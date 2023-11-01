package org.example.softeer;

import java.util.Arrays;
import java.util.Scanner;

public class SecretMenu {
    static public void secretMenu() {
        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt(); // 비밀 레시피 length
        int N = sc.nextInt(); // 사용자 입력 length
        int K = sc.nextInt(); // K이하의 숫자만 나옴 5 -> 1~5
        sc.nextLine();

        String[] secretKeyStr = sc.nextLine().split(" ");
        int[] secretKey = Arrays.stream(secretKeyStr).mapToInt(Integer::parseInt).toArray();
        String[] userKeyStr = sc.nextLine().split(" ");
        int[] userKey = Arrays.stream(userKeyStr).mapToInt(Integer::parseInt).toArray();


        int secretKeyCount = 0;

        for (int i = 0; i < N; i++) {
            if(userKey[i] == secretKey[secretKeyCount]) {
                secretKeyCount++;
                if(secretKeyCount == M) {
                    System.out.print("secret");
                    return;
                }
            } else {
                if(secretKeyCount > 0) {
                    i = i - secretKeyCount;
                    secretKeyCount = 0;
                }
            }
        }
        System.out.print("normal");
    }

}
