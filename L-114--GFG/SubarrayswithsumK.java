
import java.util.HashMap;
public class SubarrayswithsumK {

    public static int findsubarrayForK(int arr[], int k) {
        int n = arr.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = i; j < n; j++) {
                count += arr[j];
                if (count == k) {
                    res++;
                }
            }
        }
        return res;
    }
    

    public static int countSubarrays(int arr[], int k){
        HashMap<Integer, Integer> prefixFrq = new HashMap<>();
        prefixFrq.put(0, 1);//base condition
        int sum = 0;
        int count = 0;

        for(int i=0; i<arr.length; i++){
            sum += arr[i];
            int remaning = sum - k;
            count += prefixFrq.getOrDefault(remaning, 0);
            prefixFrq.put(sum, prefixFrq.getOrDefault(sum, 0)+1);
        }
        return count;
    }

    public static void main(String[] args) {
        // int arr[] = {2, 8, 2, 6, -6, 3, 2};
        // int k = 5;
        // int res = findsubarrayForK(arr, k);
        // System.out.println(res);


        int arr[] = {2, 8, 2, 6, -6, 3, 2};
        int k = 5;
        int res = findsubarrayForK(arr, k);
        System.out.println(res);
    }
}

// Subarrays with sum K
// Difficulty: MediumAccuracy: 49.74%Submissions: 78K+Points: 4
// Given an unsorted array of integers, find the number of subarrays having sum exactly equal to a given number k.
// Examples:
// Input: arr = [10, 2, -2, -20, 10], k = -10
// Output: 3
// Explaination: Subarrays: arr[0...3], arr[1...4], arr[3...4] have sum exactly equal to -10.
// Input: arr = [9, 4, 20, 3, 10, 5], k = 33
// Output: 2
// Explaination: Subarrays: arr[0...2], arr[2...4] have sum exactly equal to 33.
// Input: arr = [1, 3, 5], k = 0
// Output: 0
// Explaination: No subarray with 0 sum.
// Constraints:
// 1 ≤ arr.size() ≤ 105
// -103 ≤ arr[i] ≤ 103
// -107 ≤ k ≤ 107