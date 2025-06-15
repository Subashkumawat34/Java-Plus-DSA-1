
import java.util.HashMap;

public class CountFerqHashMap {

    public static int mostFrequentElement(int arr[]) {
        HashMap<Integer, Integer> frqMap = new HashMap<>();
        int ans = -1;
        int frequency = 0;

        for (int i = 0; i < arr.length; i++) {
            frqMap.put(arr[i], frqMap.getOrDefault(arr[i], 0) + 1);
            // if (frqMap.containsKey(arr[i])) {
            //     int val = frqMap.get(arr[i]);
            //     val += 1;

            //     frqMap.put(arr[i], val);
            // } else {
            //     frqMap.put(arr[i], 1);
            // }
            int currFrequency = frqMap.get(arr[i]);

            if (currFrequency > frequency) {
                frequency = currFrequency;
                ans = arr[i];
            } else if (currFrequency == frequency && arr[i] > ans) {
                ans = arr[i];
            }
        }
        return ans;

    }

    public static void main(String[] args) {

        int arr[] = {9, 2, 1, 7, 8, 2, 1, 9, 9, 2, 8, 2, 9};
        int ans = mostFrequentElement(arr);
        System.out.println("the answer is " + ans);

    }
}
