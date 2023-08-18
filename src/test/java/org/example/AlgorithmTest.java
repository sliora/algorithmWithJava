package org.example;

import org.assertj.core.api.Assertions;
import org.example.leetcode.*;
import org.example.leetcode.LinkedListCycle.ListNode;
import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class AlgorithmTest {

    @Test
    void testFindHIndex() {
        HIndex hIndex = new HIndex();
        assertEquals(3, hIndex.findHIndex(new int[]{3, 0, 6, 1, 5}));
        assertEquals(4, hIndex.findHIndex(new int[]{10, 8, 5, 4, 3}));
        assertEquals(0, hIndex.findHIndex(new int[]{0, 0, 0, 0}));
    }

    @Test
    void testKthSmallestElementInSortedMatrix() {
        KthSmallestElementInSortedMatrix kthSmallestElementInSortedMatrix = new KthSmallestElementInSortedMatrix();
        assertThat(kthSmallestElementInSortedMatrix.findKthSmallest(new int[][]{{1,5,9}, {10,11,13}, {12,13,15}},8)).isEqualTo(13);
        assertThat(kthSmallestElementInSortedMatrix.findKthSmallest(new int[][]{{-5}},1)).isEqualTo(-5);
    }

    @Test
    void testLinkedListCycle() {
        // Create a list with a cycle
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;  // create the cycle

        LinkedListCycle solution = new LinkedListCycle();
        assertTrue(solution.hasCycle(node1));

        // Create a list without a cycle
        ListNode node5 = new ListNode(1);
        ListNode node6 = new ListNode(2);
        node5.next = node6;

        assertFalse(solution.hasCycle(node5));
    }

    @Test
    public void testLRUCache() {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        assertEquals(1, lruCache.get(1)); // Returns 1
        lruCache.put(3, 3); // LRU key was 2, evicts key 2
        assertEquals(-1, lruCache.get(2)); // Returns -1 (not found)
        lruCache.put(4, 4); // LRU key was 1, evicts key 1
        assertEquals(-1, lruCache.get(1)); // Returns -1 (not found)
        assertEquals(3, lruCache.get(3)); // Returns 3
        assertEquals(4, lruCache.get(4)); // Returns 4
    }

    @Test
    public void testGenerateParentheses() {
        GenerateParentheses generateParentheses = new GenerateParentheses();
        System.out.println("generateParentheses.generateParenthesis(3) = " + generateParentheses.generateParenthesis(3));
    }
    
    @Test
    void stackTest() {
        Stack<int[]> ints = new Stack<>();

        ints.push(new int[]{100, 1});
        ints.push(new int[]{80, 1});
        ints.push(new int[]{60, 1});
        ints.push(new int[]{70, 1});
        ints.push(new int[]{60, 1});
        ints.push(new int[]{75, 1});
        ints.push(new int[]{85, 1});


        System.out.println("ints.peek()[0] = " + ints.peek()[0]); //peek 은 마지막 요소인듯?
        System.out.println("ints.get(ints.size() - 1)[0] = " + ints.get(ints.size() - 1)[0]); // == peek
        System.out.println("ints.stream().count() = " + ints.size());
        System.out.println("ints.pop()[1] = " + ints.pop()[1]);
        System.out.println("ints.pop()[1] = " + ints.pop()[1]);
        System.out.println("ints.pop()[1] = " + ints.pop()[1]);
    }

    @Test
    void OnlineStockSpanTest() {
        OnlineStockSpan onlineStockSpan = new OnlineStockSpan();

        assertThat(onlineStockSpan.next(100)).isEqualTo(1);
        assertThat(onlineStockSpan.next(80)).isEqualTo(1);
        assertThat(onlineStockSpan.next(60)).isEqualTo(1);
        assertThat(onlineStockSpan.next(70)).isEqualTo(2);
        assertThat(onlineStockSpan.next(60)).isEqualTo(1);
        assertThat(onlineStockSpan.next(75)).isEqualTo(4);
        assertThat(onlineStockSpan.next(85)).isEqualTo(6);
    }
}