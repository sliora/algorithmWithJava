package org.example.leetcode;

import java.util.Stack;

/**
 * Design an algorithm that collects daily price quotes for some stock and returns the span of that stock's price for the current day.
 * The span of the stock's price in one day is the maximum number of consecutive days (starting from that day and going backward) for which the stock price was less than or equal to the price of that day.
 *
 */
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
