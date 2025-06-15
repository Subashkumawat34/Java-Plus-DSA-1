
import java.util.HashMap;

public class ArraySubsetUsingHashMap {

    public static boolean isSubset(int a[], int b[]) {
        HashMap<Integer, Integer> frqMap = new HashMap<>();

        for (int elements : a) {
            frqMap.put(elements, frqMap.getOrDefault(elements, 0) + 1);
        }
        for (int elements : b) {
            if (frqMap.containsKey(elements) && frqMap.get(elements) > 0) {
                frqMap.put(elements, frqMap.get(elements) - 1);
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] var1 = new int[]{1, 2, 7, 1, 6, 4, 3};
        int[] var2 = new int[]{1, 2, 1, 4, 3,12};
        boolean var3 = isSubset(var1, var2);
        System.out.println(var3);
    }
}
