
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FirstNegitiveNoInWindowK {

    public static int[] PrintFirstNegitiveInteger(int arr[], int k) {
        int n = arr.length;
        int res[] = new int[n - k + 1];
        if (arr.length == 0) {
            return new int[0];
        }
        for (int i = 0; i < n - k + 1; i++) {
            for (int j = 0; j < k; j++) {
                int element = i + j;

                if (arr[element] < 0) {
                    res[i] = arr[element];
                    break;
                }
            }
        }
        return res;
    }

    public static List<Integer> firstNegInt(int arr[], int k) {
        int n = arr.length;
        List<Integer> resList = new ArrayList<>();
        if (arr.length == 0) {
            return new ArrayList<>();
        }
        for (int i = 0; i < n - k + 1; i++) {
            boolean found = false;
            for (int j = 0; j < k; j++) {
                int element = i + j;

                if (arr[element] < 0) {
                    resList.add(arr[element]);
                    found = true;
                    break;
                }
            }
            if (!found) {
                resList.add(0);
            }
        }
        return resList;
    }

    static List<Integer> firstNegIntWithSlidingWindow(int[] arr, int k) {
        List<Integer> resList = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>(); // Stores INDICES of negative numbers
        int n = arr.length;

        // Edge cases
        if (n == 0 || k <= 0 || k > n) {
            return resList;
        }

        // Step 1: Process the first window (0 to k-1)
        for (int i = 0; i < k; i++) {
            if (arr[i] < 0) {
                queue.offer(i); // Store the INDEX
            }
        }
        // Add result for first window
        resList.add(queue.isEmpty() ? 0 : arr[queue.peek()]);

        // Step 2: Process remaining windows (1 to n-k)
        for (int j = 1; j <= n - k; j++) {
            // Remove the outgoing element's index if it's at the front of the queue
            if (!queue.isEmpty() && queue.peek() < j) {
                queue.poll();
            }
            // Add new element's index if negative
            if (arr[j + k - 1] < 0) {
                queue.offer(j + k - 1);
            }
            // Add result for current window
            resList.add(queue.isEmpty() ? 0 : arr[queue.peek()]);
        }

        return resList;
    }

    public static void main(String[] args) {
        int arr[] = {12, -1, -7, 8, -15, 30, 16, 28};
        int k = 3;
        // int res[] = PrintFirstNegitiveInteger(arr, k);
        // for (int i = 0; i < res.length; i++) {
        //     System.out.print(res[i] + ",");
        // }

        // List<Integer> res = firstNegInt(arr, k);
        // for (int i = 0; i < res.size(); i++) {
        //     System.out.print(res.get(i) + ",");
        // }
        List<Integer> res = firstNegIntWithSlidingWindow(arr, k);
        for (int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i) + ",");
        }

    }
}

//https://www.geeksforgeeks.org/problems/first-negative-integer-in-every-window-of-size-k3345/1
// First negative in every window of size k
// Difficulty: MediumAccuracy: 48.61%Submissions: 190K+Points: 4Average Time: 15m
// Given an array arr[]  and a positive integer k, find the first negative integer for each and every window(contiguous subarray) of size k.
// Note: If a window does not contain a negative integer, then return 0 for that window.
// Examples:
// Input: arr[] = [-8, 2, 3, -6, 10] , k = 2
// Output: [-8, 0, -6, -6]
// Explanation:
// Window [-8, 2] First negative integer is -8.
// Window [2, 3] No negative integers, output is 0.
// Window [3, -6] First negative integer is -6.
// Window [-6, 10] First negative integer is -6.
// Input: arr[] = [12, -1, -7, 8, -15, 30, 16, 28] , k = 3
// Output: [-1, -1, -7, -15, -15, 0] 
// Explanation:
// Window [12, -1, -7] First negative integer is -1.
// Window [-1, -7, 8] First negative integer is -1.
// Window [-7, 8, -15] First negative integer is -7.
// Window [8, -15, 30] First negative integer is -15.
// Window [-15, 30, 16] First negative integer is -15.
// Window [30, 16, 28] No negative integers, output is 0.
// Input: arr[] = [12, 1, 3, 5] , k = 3
// Output: [0, 0] 
// Explanation:
// Window [12, 1, 3] No negative integers, output is 0.
// Window [1, 3, 5] No negative integers, output is 0.
// Constraints:
// 1 <= arr.size() <= 106
// -105 <= arr[i] <= 105
// 1 <= k <= arr.size()
