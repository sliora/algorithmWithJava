package org.example.softeer;

import java.util.Arrays;
import java.util.Scanner;

public class SecretMenu {
    static public String secretMenu() {
        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt();
        int N = sc.nextInt();
        int K = sc.nextInt();
        sc.nextLine();

        int[] recipe = new int[M];
        for (int i=0; i<M; i++) {
            recipe[i] = sc.nextInt();
        }

        int[] intInput = new int[N];
        for (int i = 0; i < N; i++) {
            intInput[i] = sc.nextInt();
        }

        int recipeIndex = 0;

        for (int i=0; i< N; i++) {
            if (intInput[i] == recipe[recipeIndex]) {
                recipeIndex++;
                if(recipeIndex == M) {
                    System.out.print("secret");
                    return "secret";
                }
            } else {
                recipeIndex = 0;
            }
        }


        System.out.print("normal");
        return "normal";
    }

}
