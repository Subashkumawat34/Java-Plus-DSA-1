
public class MaxSumSubarrayWithSizeK {

    public static int findMaxSumOfSubarrayWithK(int arr[], int k) {
        int maxSum = 0;
        int n = arr.length;
        for (int i = 0; i < n - k + 1; i++) {
            int sum = 0;
            for (int j = i; j < i + k; j++) {
                sum += arr[j];
            }
            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }

    public static int maxSumWithSlidingWindowTeq(int arr[], int k) {
        int maxSum = 0;
        int n = arr.length;

        if (k > n) {
            return -1;
        }
        int sum = 0;
        //Find the First sliding window sum
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }

        maxSum = sum;

        //Find the rest sliding window sum
        for (int i = 1; i <= n - k; i++) {
            int prevElement = arr[i - 1];
            int nextElement = arr[i + k - 1];
            sum = sum - prevElement + nextElement;

            maxSum = Math.max(sum, maxSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int arr[] = {100, 200, 300, 400};
        int k = 2;
        // int res = findMaxSumOfSubarrayWithK(arr, k);
        // System.out.println(res);

        int res = maxSumWithSlidingWindowTeq(arr, k);
        System.out.println(res);
    }
}

//https://www.geeksforgeeks.org/problems/max-sum-subarray-of-size-k5313/1
// Max Sum Subarray of size K
// Difficulty: EasyAccuracy: 49.6%Submissions: 194K+Points: 2
// Given an array of integers arr[]  and a number k. Return the maximum sum of a subarray of size k.
// Note: A subarray is a contiguous part of any given array.
// Examples:
// Input: arr[] = [100, 200, 300, 400] , k = 2
// Output: 700
// Explanation: arr3  + arr4 = 700, which is maximum.
// Input: arr[] = [100, 200, 300, 400] , k = 4
// Output: 1000
// Explanation: arr1 + arr2 + arr3 + arr4 = 1000, which is maximum.
// Input: arr[] = [100, 200, 300, 400] , k = 1
// Output: 400
// Explanation: arr4 = 400, which is maximum.
// Constraints:
// 1 <= arr.size() <= 106
// 1 <= arr[i]<= 106
// 1 <= k<= arr.size()
