package org.example.leetcode;

import java.util.Stack;

public class OnlineStockSpan {
    Stack<int[]> ints;
    public OnlineStockSpan() {
        ints = new Stack<>();
    }

    public int next(int price) {
        int span = 1;

        while (!ints.isEmpty() && ints.peek()[0] <= price) {
            span += ints.pop()[1];
        }

        ints.push(new int[]{price, span});

        return span;
    }
}
