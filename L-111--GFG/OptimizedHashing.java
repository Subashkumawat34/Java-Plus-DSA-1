
import java.util.HashMap;

public class OptimizedHashing {

    public static int OptimizedCpuntPairs(int arr[], int k) {
        HashMap<Integer, Integer> frqMap = new HashMap<>();

        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            int secondVal = k - arr[i];
            count += frqMap.getOrDefault(secondVal, 0);
            frqMap.put(arr[i], frqMap.getOrDefault(arr[i], 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int arr[] = {2, 8, 5};
        int target = 10;
        int ans = OptimizedCpuntPairs(arr, target);
        System.out.println(ans);
    }
}
