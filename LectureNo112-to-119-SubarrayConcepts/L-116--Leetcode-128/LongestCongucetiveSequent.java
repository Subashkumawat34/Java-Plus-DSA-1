
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;

public class LongestCongucetiveSequent {

    public static int LongestConsecutiveSequenceBruteForce(int arr[]) {
        int maxLength = 0;
        for (int i = 0; i < arr.length; i++) {
            int length = 1;
            int current = arr[i];

            while (LinearSearch(arr, current + 1)) {
                current = current + 1;
                length++;
            }
            maxLength = Math.max(length, maxLength);
        }
        return maxLength;
    }

    public static boolean LinearSearch(int arr[], int target) {
        for (int nums : arr) {
            if (nums == target) {
                return true;
            }
        }
        return false;
    }

    public static int LongestCongucetiveSequentWithSorting(int arr[]) {
        if (arr.length == 0) {
            return 0;
        }
        Arrays.sort(arr);// Complexity is 0(nlogn)
        int maxLength = 0;
        int prev = arr[0];
        int length = 1;
        for (int i = 1; i < arr.length; i++) {
            if (prev == arr[i]) {
                continue;
            }
            if (arr[i] == prev + 1) {
                length++;
            } else {
                length = 1;
            }
            prev = arr[i];
            maxLength = Math.max(length, maxLength);
        }
        return maxLength;
    }

    public static int LongestCongucetiveSequentWithHashSet(int arr[]) {
        if (arr.length == 0) {
            return 0;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        int maxLength = 0;
        for (Integer element : arr) {
            int prevElement = element - 1;
            if (!set.contains(prevElement)) {
                int length = 1;
                int nextElement = element + 1;
                while (set.contains(nextElement)) {
                    length++;
                    nextElement++;
                }
                maxLength = Math.max(length, maxLength);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int arr[] = {100, 4, 200, 1, 3, 2};
        // int res = LongestConsecutiveSequenceBruteForce(arr);
        // System.out.println(res);

        // int res = LongestCongucetiveSequentWithSorting(arr);
        // System.out.println(res);
        int res = LongestCongucetiveSequentWithHashSet(arr);
        System.out.println(res);
    }
}

//https://leetcode.com/problems/longest-consecutive-sequence/
// 128. Longest Consecutive Sequence
// Medium
// Topics
// premium lock icon
// Companies
// Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
// You must write an algorithm that runs in O(n) time.
// Example 1:
// Input: nums = [100,4,200,1,3,2]
// Output: 4
// Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
// Example 2:
// Input: nums = [0,3,7,2,5,8,4,6,0,1]
// Output: 9
// Example 3:
// Input: nums = [1,0,1,2]
// Output: 3
// Constraints:
// 0 <= nums.length <= 105
// -109 <= nums[i] <= 109
