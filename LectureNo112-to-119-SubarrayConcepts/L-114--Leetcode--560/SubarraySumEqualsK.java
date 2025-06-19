
import java.util.HashMap;

public class SubarraySumEqualsK {

    public static int findTotalKSumSubarray(int arr[], int k) {
        int count = 0;
        int sum = 0;
        HashMap<Integer, Integer> sumFreqMap = new HashMap<>();
        sumFreqMap.put(0, 1);

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            int remaning = sum - k;
            count += sumFreqMap.getOrDefault(remaning, 0);
            sumFreqMap.put(sum, sumFreqMap.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int arr[] = {1, 1, 1};
        int target = 2;
        int res = findTotalKSumSubarray(arr, target);
        System.out.println("the total sum is: " + res);

    }
}

// 560. Subarray Sum Equals K
// Medium
// Topics
// premium lock icon
// Companies
// Hint
// Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
// A subarray is a contiguous non-empty sequence of elements within an array.
// Example 1:
// Input: nums = [1,1,1], k = 2
// Output: 2
// Example 2:
// Input: nums = [1,2,3], k = 3
// Output: 2
// Constraints:
// 1 <= nums.length <= 2 * 104
// -1000 <= nums[i] <= 1000
// -107 <= k <= 107
