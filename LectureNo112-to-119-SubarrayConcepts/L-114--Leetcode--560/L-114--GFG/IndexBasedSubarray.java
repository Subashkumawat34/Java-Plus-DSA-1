
import java.util.ArrayList;
import java.util.HashMap;

public class IndexBasedSubarray {

    public static ArrayList<Integer> subarraySum(int[] arr, int target) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(-1);//if answer is not exist
        HashMap<Integer, Integer> myMap = new HashMap<>();
        myMap.put(0, -1);
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            int remaning = sum - target;
            if (myMap.containsKey(remaning)) {
                int startIndex = myMap.get(remaning) + 2;
                list.add(0, startIndex);
                list.add(1, i + 1);
                break;
            }
            myMap.put(sum, i);
        }
        return list;
    }

    public static void main(String[] args) {
        int arr[] = {15, 2, 4, 8, 9, 5, 10, 23};
        int target = 23;
        ArrayList<Integer> res = subarraySum(arr, target);
        if (res.get(0) == -1) {
            System.out.println("Subarray Not Found");
            return;
        }
        System.out.println("Subarray if found at index " + res.get(0) + " To " + res.get(1));
    }
}

// Subarray with Given Sum
// Last Updated : 30 Dec, 2024
// Given a 1-based indexing array arr[] of non-negative integers and an integer sum. You mainly need to return the left and right indexes(1-based indexing) of that subarray. In case of multiple subarrays, return the subarray indexes which come first on moving from left to right. If no such subarray exists return an array consisting of element -1.
// Examples: 
// Input: arr[] = [15, 2, 4, 8, 9, 5, 10, 23], target = 23
// Output: [2, 5]
// Explanation: Sum of subarray arr[2...5] is 2 + 4 + 8 + 9 = 23.
// Input: arr[] = [1, 10, 4, 0, 3, 5], target = 7
// Output: [3, 5]
// Explanation: Sum of subarray arr[3...5] is 4 + 0 + 3 = 7.
// Input: arr[] = [1, 4], target = 0
// Output: [-1]
// Explanation: There is no subarray with 0 sum.
