
// Leetcode Problem ----> 442.
import java.util.ArrayList;
import java.util.List;

public class OptimizedDuplicateAll {

    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 4, 5, 6, 1, 2, 3, 4};
        OptimizedDuplicateAll obj = new OptimizedDuplicateAll();
        List<Integer> res = obj.findDuplicate(nums);
        System.out.println("Optiized Duplicate Elements is: " + res);
    }

    public List<Integer> findDuplicate(int nums[]) {
        List<Integer> list = new ArrayList<Integer>();
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int element = Math.abs(nums[i]);
            int actualIndex = element - 1;

            if (nums[actualIndex] < 0) {
                count++;
                list.add(element);
            } else {
                nums[actualIndex] = -1 * nums[actualIndex];
            }
        }
        System.out.println("Counts of duplicate elements are: " + count);
        return list;
    }
}
