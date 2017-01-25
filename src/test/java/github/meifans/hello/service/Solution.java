package github.meifans.hello.service;

import org.junit.Test;

import java.util.ArrayList;

/**
 * public class ListNode {
 * int val;
 * ListNode next = null;
 * <p>
 * ListNode(int val) {
 * this.val = val;
 * }
 * }
 */

public class Solution {
    ArrayList<Integer> result = new ArrayList<>();
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> result = new ArrayList<>();
        if (listNode != null) {
            System.out.println(listNode.val);
            this.printListFromTailToHead(listNode.next);
            result.add(listNode.val);
        }
        return result;
    }

    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    @Test
    public void testListNode() {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        ArrayList<Integer> list = printListFromTailToHead(listNode);
        list.forEach(System.out::println);

    }

}