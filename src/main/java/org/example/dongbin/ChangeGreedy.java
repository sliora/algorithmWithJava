package org.example.dongbin;

import java.util.Scanner;

public class ChangeGreedy {
    static public void changeGreedy() {
        Scanner sc = new Scanner(System.in);
        int amount = sc.nextInt();
        int count = 0;

        int[] coins = {500, 100, 50, 10};
        for (int i = 0; i < coins.length; i++) {
                count += amount / coins[i];
                amount %= coins[i];
        }
        System.out.println(count);
    }
}
