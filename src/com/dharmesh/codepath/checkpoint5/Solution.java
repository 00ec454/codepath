package com.dharmesh.codepath.checkpoint5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if (A == null || A.size() == 0) { return ans; }
        permute(ans, A.toArray(new Integer[0]), 0);
        return ans;
    }

    private void permute(ArrayList<ArrayList<Integer>> ans, Integer[] nums, int index) {
        if (index == nums.length) {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.addAll(Arrays.asList(nums));
            ans.add(temp);
            return;
        }
        Set<Integer> appeared = new HashSet<>();
        for (int i = index; i < nums.length; ++i) {
            if (appeared.add(nums[i])) {
                swap(nums, index, i);
                permute(ans, nums, index + 1);
                swap(nums, index, i);
            }
        }
    }

    private void swap(Integer[] nums, int i, int j) {
        int save = nums[i];
        nums[i] = nums[j];
        nums[j] = save;
    }
}

