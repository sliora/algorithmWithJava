package org.example;

import org.assertj.core.api.Assertions;
import org.example.leetcode.*;
import org.example.leetcode.LinkedListCycle.ListNode;
import org.junit.jupiter.api.Test;

import java.util.*;

import static javax.swing.UIManager.put;
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

    @Test
    void DailyTemperaturesTest() {
        DailyTemperatures dailyTemperatures = new DailyTemperatures();
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 75};

        int[] ints = dailyTemperatures.dailyTemperatures(temperatures);

        for (int anInt : ints) {
            System.out.println("anInt = " + anInt);
        }
    }

    @Test
    void name() {

        String a = "aBcDeFg";
        StringBuilder result = new StringBuilder();

        char[] charArray = a.toCharArray();


        for (char c : charArray) {
            if(Character.isLowerCase(c)) {
                result.append(Character.toUpperCase(c));
            } else {
                result.append(Character.toLowerCase(c));
            }

        }

        System.out.println("result = " + result);
    }

    @Test
    void 문자열_돌리기() {
        String a = "abced";

        for(Character c : a.toCharArray()) {
            System.out.println(c);
        }
    }

    @Test
    void 홀짝_구분하기() {
        int n = 100;

        if (n % 2 == 0) {
            System.out.print(n + " is even");
        } else {
            System.out.print(n + " is odd");
        }
    }

    @Test
    void 문자열_겹쳐쓰기() {
        String my_string = "He11oWor1d";
        String overwrite_string = "lloWorl";
        int s = 2;

        String before = my_string.substring(0, s);
        String after = my_string.substring(s + overwrite_string.length());


        System.out.print(before + overwrite_string + after);
    }

    @Test
    void letterCombinations() {
        String digits = "23";

        Map<Character, String> phoneMap = new HashMap<>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};

        List<String> combinations = new ArrayList<>();
//        if (digits.length() == 0) {
//            return combinations;
//        }

        combinations.add("");
        for (char digit : digits.toCharArray()) {
            List<String> temp = new ArrayList<>();
            for (String combo : combinations) {
                for (char letter : phoneMap.get(digit).toCharArray()) {
                    temp.add(combo + letter);
                }
            }
            combinations = temp;
        }
        //return combinations;
        System.out.println("combinations = " + combinations);
    }

    @Test
    void mergeTwoSortedLists() {
        ListNodeTest firstNode1 = new ListNodeTest(1);
        ListNodeTest firstNode2 = new ListNodeTest(2);
        ListNodeTest firstNode3 = new ListNodeTest(4);
        firstNode1.next = firstNode2;
        firstNode2.next = firstNode3;


        ListNodeTest secondNode1 = new ListNodeTest(1);
        ListNodeTest secondNode2 = new ListNodeTest(3);
        ListNodeTest secondNode3 = new ListNodeTest(4);
        secondNode1.next = secondNode2;
        secondNode2.next = secondNode3;

        mergeTwoLists(firstNode1, secondNode1);

    }

    public ListNodeTest mergeTwoLists(ListNodeTest list1, ListNodeTest list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }


    public class ListNodeTest {
        int val;
        ListNodeTest next;
        ListNodeTest() {}
        ListNodeTest(int val) {
            this.val = val;
        }
        ListNodeTest(int val, ListNodeTest next) {
            this.val = val; this.next = next;
        }

    }


    @Test
    void FindTheTownJudgeTest() {
        FindTheTownJudge findTheTownJudge = new FindTheTownJudge();

        // Example test
        int[][] trust = {{1, 3}, {2, 3}};
        int N = 3;
        System.out.println(findTheTownJudge.findJudge(N, trust));  // Exp
    }

}