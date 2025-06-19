
import java.util.HashSet;

public class CheckSumKSubarrayHashSet {

    public static boolean checkSumKSubarray(int arr[], int k) {
        HashSet<Integer> mySet = new HashSet<>();
        mySet.add(0);//for x == k the difference of k and x --> 0 in some cases
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            int remaning = sum - k;

            if (mySet.contains(remaning)) {
                return true;
            }
            mySet.add(sum);
        }
        return false;
    }

    public static void main(String[] args) {
        int arr[] = {2, 8, 2, 6, -6, 3, 2};
        int k = 5;
        boolean res = checkSumKSubarray(arr, k);
        System.out.println(res);
    }
}
