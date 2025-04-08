//leetcode problem--> 84 Largest Rectangle in Histogram

import java.util.Stack;

public class LargestRectangleInHistogram {

    public static void main(String[] args) {
        int heights[] = {2, 1, 5, 6, 2, 3};
        int res = largestRectangleArea(heights);
        System.out.println("Largest Rectangle Area Covered is: "+res);
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

// Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.
// Example 1:
// Input: heights = [2,1,5,6,2,3]
// Output: 10
// Explanation: The above is a histogram where width of each bar is 1.
// The largest rectangle is shown in the red area, which has an area = 10 units.
// Example 2:
// Input: heights = [2,4]
// Output: 4
// Constraints:
// 1 <= heights.length <= 105
// 0 <= heights[i] <= 104

