package com.dharmesh.codepath.checkpoint3;

import java.util.List;

public class Solution {

    public int kthsmallest(final List<Integer> A, int B) {
        return kthsmallest(A.toArray(new Integer[0]), B);
    }

    public int kthsmallest(final Integer[] A, int B) {
        int heap[] = new int[B];

        for (int i = 0; i < B; i++) {
            heap[i] = A[i];
            int parent;
            int current = i;
            while ((parent = (current - 1) / 2) >= 0 && heap[parent] < heap[current]) {
                int temp = heap[parent];
                heap[parent] = heap[current];
                heap[current] = temp;
                current = parent;
            }
        }

        for (int i = B; i < A.length; i++) {
            if (A[i] < heap[0]) {
                heap[0] = A[i];

                int j = 0;
                int left, right, swapIndex;

                do {
                    left = 2 * j + 1;
                    right = 2 * j + 2;

                    if (left < heap.length && right < heap.length) {
                        swapIndex = (heap[left] > heap[right]) ? left : right;
                    }
                    else if (left < heap.length) {
                        swapIndex = left;
                    }
                    else if (right < heap.length) {
                        swapIndex = right;
                    }
                    else {
                        break;
                    }

                    if (heap[j] < heap[swapIndex]) {
                        int temp = heap[j];
                        heap[j] = heap[swapIndex];
                        heap[swapIndex] = temp;
                        j = swapIndex;
                    }
                    else {
                        break;
                    }

                } while (j < heap.length);
            }
        }
        return heap[0];
    }
}
