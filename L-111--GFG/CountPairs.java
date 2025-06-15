
public class CountPairs {

    public static int CountPairs(int arr[], int target) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == target) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int arr[] = {1, 5, 7, -1, 5}; 
        int target = 6;
        int ans = CountPairs(arr, target);
        System.out.println(ans);
    }

}

// Count pairs with given sum
// Difficulty: EasyAccuracy: 50.11%Submissions: 48K+Points: 2Average Time: 15m
// Given an array arr[] and an integer target. You have to find numbers of pairs in array arr[] which sums up to given target.
// Examples:
// Input: arr[] = [1, 5, 7, -1, 5], target = 6 
// Output: 3
// Explanation: Pairs with sum 6 are (1, 5), (7, -1) and (1, 5). 
// Input: arr[] = [1, 1, 1, 1], target = 2 
// Output: 6
// Explanation: Pairs with sum 2 are (1, 1), (1, 1), (1, 1), (1, 1), (1, 1), (1, 1).
// Input: arr[] = [10, 12, 10, 15, -1], target = 125
// Output: 0
// Constraints:
// 1 <= arr.size() <= 105
// -104 <= arr[i] <= 104
// 1 <= target <= 104

