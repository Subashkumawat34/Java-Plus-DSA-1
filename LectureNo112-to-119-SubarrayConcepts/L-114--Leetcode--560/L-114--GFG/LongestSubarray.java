
import java.util.HashMap;

public class LongestSubarray {

    public static int findLongestKSumSubarray(int arr[], int k) {
        int maxLength = 0;
        int sum = 0;
        HashMap<Integer, Integer> myMap = new HashMap<>();
        myMap.put(0, -1);
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            int remaning = sum - k;
            if (myMap.containsKey(remaning)) {
                int len = i - myMap.get(remaning);
                maxLength = Math.max(maxLength, len);
            }
            if (!myMap.containsKey(sum)) {
                myMap.put(sum, i);
            }
        }
        return maxLength;
    }

    public static int findShortestKSumSubarray(int arr[], int k) {
        HashMap<Integer, Integer> myMap = new HashMap<>();
        int minLength = Integer.MAX_VALUE;
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            int remaning = sum - k;
            if (myMap.containsKey(remaning)) {
                int length = i - myMap.get(remaning);
                minLength = Math.min(minLength, length);
            }
            if (!myMap.containsKey(sum)) {
                myMap.put(sum, i);
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    public static void main(String[] args) {
        int arr[] = {10, 5, 2, 7, 1, -10};
        // int arr[] = {94, -33, -13, 40, -82, 94, -33, -13, 40, -82};
        int k = 15;
        //int res = findLongestKSumSubarray(arr, k);//for finding the maximum length of sub array using indexes
        int res = findShortestKSumSubarray(arr, k);

        System.out.println(res);

    }
}

// Longest Subarray with Sum K
// Difficulty: MediumAccuracy: 24.64%Submissions: 666K+Points: 4
// Given an array arr[] containing integers and an integer k, your task is to find the length of the longest subarray where the sum of its elements is equal to the given value k. If there is no subarray with sum equal to k, return 0.
// Examples:
// Input: arr[] = [10, 5, 2, 7, 1, -10], k = 15
// Output: 6
// Explanation: Subarrays with sum = 15 are [5, 2, 7, 1], [10, 5] and [10, 5, 2, 7, 1, -10]. The length of the longest subarray with a sum of 15 is 6.
// Input: arr[] = [-5, 8, -14, 2, 4, 12], k = -5
// Output: 5
// Explanation: Only subarray with sum = -5 is [-5, 8, -14, 2, 4] of length 5.
// Input: arr[] = [10, -10, 20, 30], k = 5
// Output: 0
// Explanation: No subarray with sum = 5 is present in arr[].
// Constraints:
// 1 ≤ arr.size() ≤ 105
// -104 ≤ arr[i] ≤ 104
// -109 ≤ k ≤ 109
