
import java.util.HashSet;

public class MinNoOfSubsets {

    public static int findMinNoOfSubsets(int arr[]) {
        int res = 0;
        int n = arr.length;
        boolean visited[] = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }
            res++;
            HashSet<Integer> set = new HashSet<>();
            for (int j = i; j < n; j++) {
                if (visited[j] || set.contains(arr[j])) {
                    continue;
                }
                visited[j] = true;
                set.add(arr[j]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int arr[] = {2, 1, 4, 1, 6, 5, 5, 5};
        //<2,1,4,6,5>
        //<1,5>
        //<5>
        int res = findMinNoOfSubsets(arr);
        System.out.println("The Array Contains " + res + " Distinct Elements");
    }
}

// Minimum Subsets with Distinct Elements
// Last Updated : 27 Feb, 2025
// You are given an array of n-element. You have to make subsets from the array such that no subset contain duplicate elements. Find out minimum number of subset possible.
// Examples : 
// Input : arr[] = {1, 2, 3, 4}
// Output :1
// Explanation : A single subset can contains all values and all values are distinct.
// Input : arr[] = {1, 2, 3, 3}
// Output : 2
// Explanation : We need to create two subsets {1, 2, 3} and {3} [or {1, 3} and {2, 3}] such that both subsets have distinct elements.
// [Naive Solution] - Nested Loops - O(n^2) Time and O(1) Space
// Let us take a look at few observations.
// If all elements are distinct, we need to make only one subset.
// If all elements are same, we need make n subsets.
// If an element appears twice, and all other are distinct, we need to make two subsets,
