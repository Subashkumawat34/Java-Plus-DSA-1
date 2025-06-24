
import java.util.HashMap;

public class UsingHashMap {

    public static void main(String[] args) {
        int arr[] = {2, 1, 4, 1, 6, 5, 5};
        //<2,1,4,6,5>
        //<1,5>
        //<5>

        int res = findMinNoOfSubsets(arr);
        System.out.println("The Array Contains " + res + " Distinct Elements");
    }

    public static int findMinNoOfSubsets(int arr[]) {
        HashMap<Integer, Integer> frqMap = new HashMap<>();

        int maxFrq = 0;
        for (int i = 0; i < arr.length; i++) {
            frqMap.put(arr[i], frqMap.getOrDefault(arr[i], 0) + 1);
            maxFrq = Math.max(maxFrq, frqMap.get(arr[i]));
        }
        return maxFrq;
    }
}
