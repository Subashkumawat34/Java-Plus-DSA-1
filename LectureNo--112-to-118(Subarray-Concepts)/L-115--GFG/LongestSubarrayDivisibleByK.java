
import java.util.HashMap;

public class LongestSubarrayDivisibleByK {

    public static int longestSubarrayDivK(int[] arr, int k) {
        HashMap<Integer, Integer> remMap = new HashMap<>();
        int sum = 0;
        int maxLength = 0;
        remMap.put(0, -1);//To handle subarray starting index from zero

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            int rem = sum % k;
            //to handle negitive remenders if we add the value which is divides the original value with remainder so this will gives positive remainders
            if (rem < 0) {
                rem += k;
            }
            if (remMap.containsKey(rem)) {
                int length = i - remMap.get(rem);
                maxLength = Math.max(length, maxLength);
            } else {
                remMap.put(rem, i);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int arr[] = {2, 7, 6, 1, 4, 5};
        int k = 3;
        int res = longestSubarrayDivK(arr, k);
        System.out.println(res);
    }
}

//https://www.geeksforgeeks.org/problems/longest-subarray-with-sum-divisible-by-k1259/1
// Longest subarray with sum divisible by K
// Difficulty: MediumAccuracy: 33.72%Submissions: 101K+Points: 4
// Given an array arr[] and a positive integer k, find the length of the longest subarray with the sum of the elements divisible by k.
// Note: If there is no subarray with sum divisible by k, then return 0.
// Examples :
// Input: arr[] = [2, 7, 6, 1, 4, 5], k = 3
// Output: 4
// Explanation: The subarray [7, 6, 1, 4] has sum = 18, which is divisible by 3.
// Input: arr[] = [-2, 2, -5, 12, -11, -1, 7], k = 3
// Output: 5
// Explanation: The subarray [2, -5, 12, -11, -1] has sum = -3, which is divisible by 3.
// Input: arr[] = [1, 2, -2], k = 2
// Output: 2
// Explanation: The subarray is [2, -2] has sum = 0, which is divisible by 2.
// Constraints:
// 1 <= arr.size() <= 106
// 1 <= k <= 106
// -106 <= arr[i] <= 106 
