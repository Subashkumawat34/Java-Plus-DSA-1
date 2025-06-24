
import java.util.HashMap;

public class LargestSubArrayWithZerosAndOnes {

    public static int SubarrayWithBruteForce(int arr[]) {
        int maxLength = 0;
        for (int start = 0; start < arr.length; start++) {
            for (int end = start; end < arr.length; end++) {
                int zeroCount = 0;
                int oneCount = 0;
                for (int k = start; k <= end; k++) {
                    if (arr[k] == 0) {
                        zeroCount++;
                    } else if (arr[k] == 1) {
                        oneCount++;
                    }
                }
                if (zeroCount == oneCount) {
                    int length = end - start + 1;
                    maxLength = Math.max(maxLength, length);
                }
            }
        }
        return maxLength;
    }

    public static int SubarrayWithOptimise(int arr[]) {
        int maxLength = 0;
        for (int start = 0; start < arr.length; start++) {
            int zeroCount = 0;
            int oneCount = 0;
            for (int end = start; end < arr.length; end++) {
                if (arr[end] == 0) {
                    zeroCount++;
                } else {
                    oneCount++;
                }
                if (zeroCount == oneCount) {
                    int length = end - start + 1;
                    maxLength = Math.max(length, maxLength);
                }
            }
        }
        return maxLength;
    }

    public static int SubarrayWithHashMap(int arr[]) {
        HashMap<Integer, Integer> sumMap = new HashMap<>();
        sumMap.put(0, -1);
        int maxLength = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = (arr[i] == 0) ? (sum - 1) : (sum + 1);
            if (sumMap.containsKey(sum)) {
                int length = i - sumMap.get(sum);
                maxLength = Math.max(length, maxLength);
            } else {
                sumMap.put(sum, i);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        //int arr[] = {0, 1, 0, 0, 0, 1, 0, 1, 0, 0};
        int arr[] = {1, 0, 1, 1, 1, 0, 0};
        // int res = SubarrayWithBruteForce(arr);
        // System.out.println(res);
        // int res = SubarrayWithOptimise(arr);
        // System.out.println(res);
        int res = SubarrayWithHashMap(arr);
        System.out.println(res);

    }
}

// https://www.geeksforgeeks.org/problems/largest-subarray-of-0s-and-1s/1
// Largest subarray of 0's and 1's
// Difficulty: EasyAccuracy: 32.96%Submissions: 123K+Points: 2Average Time: 20m
// Given an array arr of 0s and 1s. Find and return the length of the longest subarray with equal number of 0s and 1s.
// Examples:
// Input: arr[] = [1, 0, 1, 1, 1, 0, 0]
// Output: 6
// Explanation: arr[1...6] is the longest subarray with three 0s and three 1s.
// Input: arr[] = [0, 0, 1, 1, 0]
// Output: 4
// Explnation: arr[0...3] or arr[1...4] is the longest subarray with two 0s and two 1s.
// Input: arr[] = [0]
// Output: 0
// Explnation: There is no subarray with an equal number of 0s and 1s.
// Constraints:
// 1 <= arr.size() <= 105
// 0 <= arr[i] <= 1

