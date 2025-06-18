
import java.util.ArrayList;
import java.util.HashMap;

public class IndexesofSubarraySum {

    public static ArrayList<Integer> subarraySum(int[] arr, int target) {
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> myMap = new HashMap<>();
        myMap.put(0, -1);
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            int remaning = sum - target;
            if (myMap.containsKey(remaning)) {
                int startIndex = myMap.get(remaning) + 1;
                list.add(startIndex + 1);//converts to one based index
                list.add(i + 1);//converts to one based indet
                return list;
            }
            if (!myMap.containsKey(sum)) {
                myMap.put(sum, i);
            }
        }
        list.add(-1);
        return list;
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int target = 15;
        ArrayList<Integer> res = subarraySum(arr, target);
        System.out.println("Indexes is " + res);

    }
}

// Indexes of Subarray Sum
// Difficulty: MediumAccuracy: 16.5%Submissions: 1.8MPoints: 4Average Time: 20m
// Given an array arr[] containing only non-negative integers, your task is to find a continuous subarray (a contiguous sequence of elements) whose sum equals a specified value target. You need to return the 1-based indices of the leftmost and rightmost elements of this subarray. You need to find the first subarray whose sum is equal to the target.
// Note: If no such array is possible then, return [-1].
// Examples:
// Input: arr[] = [1, 2, 3, 7, 5], target = 12
// Output: [2, 4]
// Explanation: The sum of elements from 2nd to 4th position is 12.
// Input: arr[] = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], target = 15
// Output: [1, 5]
// Explanation: The sum of elements from 1st to 5th position is 15.
// Input: arr[] = [5, 3, 4], target = 2
// Output: [-1]
// Explanation: There is no subarray with sum 2.
// Constraints:
// 1 <= arr.size()<= 106
// 0 <= arr[i] <= 103
// 0 <= target <= 109
