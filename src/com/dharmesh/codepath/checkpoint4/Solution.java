package com.dharmesh.codepath.checkpoint4;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode subtract(ListNode A) {
        int size = 0;
        ListNode current = A;
        while (current != null) {
            current = current.next;
            size++;
        }

        int[] temp = new int[size / 2];
        current = A;
        for (int i = 0; i < size / 2; i++) {
            temp[i] = current.val;
            current = current.next;
        }

        if (size % 2 != 0) {
            current = current.next;
        }

        for (int i = size / 2 - 1; i >= 0; i--) {
            temp[i] = current.val - temp[i];
            current = current.next;
        }

        current = A;
        for (int i = 0; i < size / 2; i++) {
            current.val = temp[i];
            current = current.next;
        }
        return A;
    }
}

