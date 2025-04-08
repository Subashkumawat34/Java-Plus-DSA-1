
import java.util.ArrayList;
import java.util.List;

public class AllOccurrencesInArray {

    public static void main(String[] args) {
        int nums[] = {4, 3, 2, 7, 8, 2, 3, 1};
        AllOccurrencesInArray obj = new AllOccurrencesInArray();
        List<String> res = obj.findOccurrences(nums);
        System.out.println("Occurrences of each element: " + res);
    }

    public List<String> findOccurrences(int[] nums) {
        cyclicSort(nums);
        List<String> list = new ArrayList<>();

        for (int index = 0; index < nums.length; index++) {
            int count = 1;
            if (nums[index] != -1) {
                for (int j = index + 1; j < nums.length; j++) {
                    if (nums[index] == nums[j]) {
                        count++;
                        nums[j] = -1; // Mark duplicate as visited
                    }
                }
                list.add(nums[index] + " occures "+ count + " times  ");
            }
        }
        return list;
    }

    public static void cyclicSort(int[] nums) {
        int index = 0;
        int n = nums.length;
        while (index < n) {
            int element = nums[index];
            int correctPos = element - 1;
            if (element != nums[correctPos]) {
                swap(nums, index, correctPos);
            } else {
                index++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + "  ");
        }
    }

    public static void swap(int arr[], int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
