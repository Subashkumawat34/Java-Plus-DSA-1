
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SlidingWindowMaximum {

    public static int[] SlidindWindowMaxReturn(int nums[], int k) {
        int n = nums.length;
        //create a resulting array to store the result
        int result[] = new int[n - k + 1];

        //loop through all possible windows
        for (int i = 0; i < n - k + 1; i++) {
            int max = nums[i];

            //check next k elements from element i
            for (int j = i + 1; j < i + k; j++) {
                if (nums[j] > max) {
                    max = nums[j];
                }
            }
            result[i] = max;
        }
        return result;
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;

        // Edge case: empty array
        if (n == 0 || k == 0) {
            return new int[0];
        }

        // Result array of size (n - k + 1)
        int[] res = new int[n - k + 1];

        // Deque to store indices of useful elements in window
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            // Step 1: Remove indices out of current window
            while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst(); // Remove from front
            }

            // Step 2: Remove smaller elements from the back of deque
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            // Step 3: Add current element's index to deque
            deque.offerLast(i);

            // Step 4: Record the max value when window is full
            if (i >= k - 1) {
                res[i - k + 1] = nums[deque.peekFirst()];
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        // int[] result = SlidindWindowMaxReturn(nums, k);
        // System.out.println(Arrays.toString(result));
        int[] result = maxSlidingWindow(nums, k);

        System.out.println(Arrays.toString(result));

    }
}

// https://leetcode.com/problems/sliding-window-maximum/description/
// 239. Sliding Window Maximum
// Hard
// Topics
// premium lock icon
// Companies
// Hint
// You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.
// Return the max sliding window.
// Example 1:
// Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
// Output: [3,3,5,5,6,7]
// Explanation: 
// Window position                Max
// ---------------               -----
// [1  3  -1] -3  5  3  6  7       3
//  1 [3  -1  -3] 5  3  6  7       3
//  1  3 [-1  -3  5] 3  6  7       5
//  1  3  -1 [-3  5  3] 6  7       5
//  1  3  -1  -3 [5  3  6] 7       6
//  1  3  -1  -3  5 [3  6  7]      7
// Example 2:
// Input: nums = [1], k = 1
// Output: [1]
// Constraints:
// 1 <= nums.length <= 105
// -104 <= nums[i] <= 104
// 1 <= k <= nums.length
