
public class SmallestSubarrayWithSumGrarerX {

    public static int smallestSubWithSum(int arr[], int x) {
        int n = arr.length;
        int minLength = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                if (sum > x) {
                    int length = j - i + 1;
                    minLength = Math.min(minLength, length);
                    break;
                }
            }
        }
        return (minLength == Integer.MAX_VALUE) ? 0 : minLength;
    }

    public static int smallestSubWithSumWithSlidingWindow(int arr[], int x) {
        int n = arr.length;
        int sum = 0;
        int start = 0;
        int end = 0;
        int minLength = Integer.MAX_VALUE;

        while (end < n) {
            //this is a expension phase we need to add elements
            sum += arr[end];
            if (sum > x) {
                int length = end - start + 1;
                minLength = Math.min(minLength, length);

                //this is a shrinking phase to remove the elements from start
                while (start < end && sum > x) {
                    sum -= arr[start];
                    start++;
                    if (sum > x) {
                        length = end - start + 1;
                        minLength = Math.min(minLength, length);
                    }
                }
            }
            end++;
        }
        return (minLength == Integer.MAX_VALUE) ? 0 : minLength;
    }

    public static void main(String[] args) {
        int arr[] = {1, 4, 45, 6, 0, 9};
        int x = 51;
        // int res = smallestSubWithSum(arr, x);
        // System.out.println(res);

        int res = smallestSubWithSumWithSlidingWindow(arr, x);
        System.out.println(res);

    }
}

//https://www.geeksforgeeks.org/problems/smallest-subarray-with-sum-greater-than-x5651/1
// Smallest subarray with sum greater than x
// Difficulty: EasyAccuracy: 37.07%Submissions: 142K+Points: 2Average Time: 20m
// Given a number x and an array of integers arr, find the smallest subarray with sum greater than the given value. If such a subarray do not exist return 0 in that case.
// Examples:
// Input: x = 51, arr[] = [1, 4, 45, 6, 0, 19]
// Output: 3
// Explanation: Minimum length subarray is [4, 45, 6]
// Input: x = 100, arr[] = [1, 10, 5, 2, 7]
// Output: 0
// Explanation: No subarray exist
// Constraints:
// 1 ≤ arr.size, x ≤ 105
// 0 ≤ arr[] ≤ 104

