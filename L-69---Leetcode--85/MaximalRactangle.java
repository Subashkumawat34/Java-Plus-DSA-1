//Leetcode --- 85. problem.

import java.util.Stack;

public class MaximalRactangle {

    public static void main(String[] args) {
        char matrix[][] = {
            {'1', '0', '1', '0', '0'},
            {'1', '0', '1', '1', '1'},
            {'1', '1', '1', '1', '1'},
            {'1', '0', '0', '1', '0'}
        };
        int res = maximalRectangle(matrix);
        System.out.println("maximal ractangle covered in matrix is: " + res);
    }

    public static int maximalRectangle(char[][] matrix) {

        //if given matrix is empty or all zeros
        if (matrix.length == 0) {
            return 0;
        }

        //finds the number of columns in row
        int heights[] = new int[matrix[0].length];
        int largest = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {

                //Char to integer conversion
                int val = matrix[i][j] - '0';

                //for find the maximal ractingal using 0's
                // if (val == 1) {
                //     heights[j] = 0;
                // } else {
                //     // heights[j] += val;
                //     heights[j]++;
                // }
                //for find the maximal ractingal using 1's
                if (val == 0) {
                    heights[j] = 0;
                } else {
                    heights[j] += val;
                }
            }
            int maxArea = largestRectangleArea(heights);
            if (largest < maxArea) {
                largest = maxArea;
            }
        }
        return largest;
    }

    public static int largestRectangleArea(int[] heights) {
        int ns[] = findNextSmaller(heights);
        int ps[] = findPrevSmaller(heights);
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < heights.length; i++) {
            int height = heights[i];
            int width = ns[i] - ps[i] - 1;
            max = Math.max(max, (height * width));
        }
        return max;
    }

    public static int[] findNextSmaller(int[] nums) {
        Stack<Integer> stack = new Stack<Integer>();
        int n = nums.length;
        int res[] = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                res[i] = n;
            } else {
                res[i] = stack.peek();
            }
            stack.push(i);
        }
        return res;
    }

    public static int[] findPrevSmaller(int[] nums) {
        Stack<Integer> stack = new Stack<Integer>();
        int n = nums.length;
        int res[] = new int[n];
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                res[i] = -1;
            } else {
                res[i] = stack.peek();
            }
            stack.push(i);
        }
        return res;
    }
}

// 85. Maximal Rectangle
// Hard
// Topics
// Companies
// Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
// Example 1:
// Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
// Output: 6
// Explanation: The maximal rectangle is shown in the above picture.
// Example 2:
// Input: matrix = [["0"]]
// Output: 0
// Example 3:
// Input: matrix = [["1"]]
// Output: 1
// Constraints:
// rows == matrix.length
// cols == matrix[i].length
// 1 <= row, cols <= 200
// matrix[i][j] is '0' or '1'.
