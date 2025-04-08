//leetcode problem --503  nearest gratest element find

import java.util.Stack;

public class NextGraterElement2nd {

    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 4, 3};
        int res[] = nextGreaterElements(nums);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }

    public static int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<Integer>();
        int n = nums.length;
        int res[] = new int[n];

        for (int i = 2 * n - 1; i >= 0; i--) {
            System.out.println("index is " + i);
            System.out.println("index consider is " + (i % n));
            System.out.println("element is " + nums[i % n]);
            while (!stack.isEmpty() && stack.peek() <= nums[i % n]) {
                System.out.println("poped element is " + stack.peek());
                stack.pop();
            }
            if (i < n) {
                if (stack.isEmpty()) {
                    res[i] = -1;
                } else {
                    res[i] = stack.peek();
                }
                System.out.println("stored reselt is" + res[i]);
            }
            System.out.println("pushed  in stack " + nums[i % n]); 
            stack.push(nums[i % n]);
            System.out.println();
        }
        return res;
    }
}

// 503. Next Greater Element II
// Medium
// Topics
// Companies
// Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]), return the next greater number for every element in nums.
// The next greater number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, return -1 for this number.
// Example 1:
// Input: nums = [1,2,1]
// Output: [2,-1,2]
// Explanation: The first 1's next greater number is 2; 
// The number 2 can't find next greater number. 
// The second 1's next greater number needs to search circularly, which is also 2.
// Example 2:
// Input: nums = [1,2,3,4,3]
// Output: [2,3,4,-1,4]
// Constraints:
// 1 <= nums.length <= 104
// -109 <= nums[i] <= 109
