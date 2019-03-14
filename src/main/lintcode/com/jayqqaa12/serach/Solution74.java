package com.jayqqaa12.serach;

/**
 * 搜索target 是否在 矩阵中
 * <p>
 * 矩阵数字 从小到大排序
 * <p>
 * [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * Given target = 3, return true
 * [1,   3,  5,  7],[10, 11, 16, 20],[23, 30, 34, 50]
 * 二维矩阵跟一维矩阵的关系：[mid/n][mid%n]
 * 难度2星
 */
public class Solution74 {

    public boolean searchMatrix(int[][] matrix, int target) {

        int i = 0, j = matrix[0].length - 1;
        while (i <= j) {//暴力解
            if (matrix[i][j] == target) return true;
            if (matrix[i][j] > target) j--;
            else i++;
        }
        return false;
    }

    public boolean searchMatrix1(int[][] matrix, int target) {
        if (matrix.length == 0) return false;
        if (matrix[0].length == 0) return false;
        int start = 0, end = matrix.length * matrix[0].length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int row = mid / matrix[0].length;
            int col = mid % matrix[0].length;
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] mat = new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };
        System.out.println(new Solution74().searchMatrix1(mat, 3));
    }
}