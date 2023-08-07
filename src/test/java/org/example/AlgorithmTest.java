package org.example;

import org.assertj.core.api.Assertions;
import org.example.leetcode.HIndex;
import org.example.leetcode.KthSmallestElementInSortedMatrix;
import org.example.leetcode.LinkedListCycle;
import org.example.leetcode.LinkedListCycle.ListNode;
import org.junit.jupiter.api.Test;

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
        Assertions.assertThat(kthSmallestElementInSortedMatrix.findKthSmallest(new int[][]{{1,5,9}, {10,11,13}, {12,13,15}},8)).isEqualTo(13);
        Assertions.assertThat(kthSmallestElementInSortedMatrix.findKthSmallest(new int[][]{{-5}},1)).isEqualTo(-5);
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
}