package com.dharmesh.codepath.checkpoint2;

import java.util.ArrayList;

public class Solution {

    public ArrayList<ArrayList<Integer>> prettyPrint(int A) {
        if (A <= 0) {
            return new ArrayList<>();
        }

        int maxRow = A * 2 - 1, maxCol = A * 2 - 1;
        int startRow = 0, startCol = 0;
        int row, col;
        int filler = A;
        int[][] matrix = new int[A * 2 - 1][A * 2 - 1];
        while (filler > 0) {
            //run right
            col = startCol;
            row = startRow;
            while (col < maxCol) {
                matrix[row][col] = filler;
                col++;
            }
            col--;
            //run bottom
            while (row < maxRow) {
                matrix[row][col] = filler;
                row++;
            }
            row--;
            //run left
            while (col >= startRow) {
                matrix[row][col] = filler;
                col--;
            }
            col++;
            //run to top
            while (row >= startCol) {
                matrix[row][col] = filler;
                row--;
            }
            maxCol--;
            maxRow--;
            startCol++;
            startRow++;
            filler--;
        }

        return toList(matrix);
    }

    private ArrayList<ArrayList<Integer>> toList(int[][] matrix) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int[] aMatrix : matrix) {
            ArrayList<Integer> rowList = new ArrayList<>();
            for (int anAMatrix : aMatrix) {
                rowList.add(anAMatrix);
            }
            result.add(rowList);
        }
        return result;
    }
}
