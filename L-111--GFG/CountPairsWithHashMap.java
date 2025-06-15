
import java.util.HashMap;

public class CountPairsWithHashMap {

    public static int CountPairs(int arr[], int k) {
        HashMap<Integer, Integer> frqMap = new HashMap<>();
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            frqMap.put(arr[i], frqMap.getOrDefault(arr[i], 0) + 1);
        }
        for (int i = 0; i < arr.length; i++) {
            int secondVal = k - arr[i];

            if (frqMap.getOrDefault(secondVal, 0) > 0) {
                count += frqMap.get(secondVal);
                frqMap.put(arr[i], frqMap.get(arr[i]) - 1);
            }
            if (arr[i] == secondVal) {
                count -= 1;
            }
        } 
        return count;
    }

    public static void main(String[] args) {
        int arr[] = {2, 8, 5};
        int target = 10;
        int res = CountPairs(arr, target);
        System.out.println(res);
    }
}
