//Leetcode Problem ---->  287
public class OptimizedFindDuplicat {

    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 4, 2, 2, 5, 2, 6, 2};
        int res = findDuplicate(nums);
        System.out.println("Duplicate element is: " + res);
    }

    public static int findDuplicate(int nums[]) {
        for (int i = 0; i < nums.length; i++) {
            int element = Math.abs(nums[i]);
            int actualIndex = element - 1;
            if (nums[actualIndex] < 0) {
                return element;
            }
            nums[actualIndex] = -1 * nums[actualIndex];
        }
        return -1;
    }
}
