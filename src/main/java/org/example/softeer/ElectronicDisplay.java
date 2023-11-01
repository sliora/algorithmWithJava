package org.example.softeer;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ElectronicDisplay {
    static public void electronicDisplay() {
        Map<Character, String> point = new HashMap<>();
        point.put(' ', "0000000");
        point.put('0', "1110111");
        point.put('1', "0010010");
        point.put('2', "1011101");
        point.put('3', "1011011");
        point.put('4', "0111010");
        point.put('5', "1101011");
        point.put('6', "1101111");
        point.put('7', "1110010");
        point.put('8', "1111111");
        point.put('9', "1111011");

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();

        String first = "";
        String second = "";

        for (int i = 0; i < N; i++) {
            String[] inputArr = sc.nextLine().split(" ");
            first = inputArr[0];
            second = inputArr[1];

            int maxLength = Math.max(first.length(), second.length()); // 두개 중 큰 값 뽑기

            //앞에 크기 만큼 공백을 붙이는 작업..
            while (first.length() < maxLength) {
                first = " " + first;
            }

            while (second.length() < maxLength) {
                second = " " + second;
            }

            int result = 0;
            for (int j = 0; j < maxLength; j++) {
                String firstSegment = point.get(first.charAt(j)); //7자리 세그먼트가 나온다.
                String secondSegment = point.get(second.charAt(j)); //7자리 세그먼트가 나온다.

                for (int k = 0; k < 7; k++) {
                    if (firstSegment.charAt(k) != secondSegment.charAt(k)) {
                        result++;
                    }
                }
            }
            System.out.println(result);
        }
    }
}
