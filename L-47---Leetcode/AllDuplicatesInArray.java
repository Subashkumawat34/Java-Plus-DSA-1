
import java.util.ArrayList;
import java.util.List;

// Leetcode Problem ----> 442.


public class AllDuplicatesInArray {

    public static void main(String[] args) {
        int nums[] = {4, 3, 2, 7, 8, 2, 3, 1};
        AllDuplicatesInArray obj = new AllDuplicatesInArray();
        List<Integer> res = obj.findDuplicates(nums);
        System.out.println("All duplicate elements is: " + res);

    }

    public List<Integer> findDuplicates(int[] nums) {
        cyclicSort(nums);
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                list.add(nums[i]);
            }
        }
        return list;
    }

    public static void cyclicSort(int nums[]) {
        int n = nums.length;
        int index = 0;
        while (index < n) {
            int element = nums[index];
            int correctPos = element - 1;
            if (nums[index] != nums[correctPos]) {
                swap(nums, index, correctPos);
            } else {
                index++;
            }
        }
    }

    public static void swap(int arr[], int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
