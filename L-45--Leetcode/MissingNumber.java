
//Leetcode Problem number 268 ---->   Missing Number

public class MissingNumber {

    public static void main(String[] args) {
      int nums[] = {0,1,3};
      int res = missingNumber(nums);
      System.out.print("Missing number is " + res);
    }

    public static int missingNumber(int nums[]) {
        int n = nums.length;
        int expectedSum = n * (n + 1) / 2;
        int originalSum = 0;

        for (int i = 0; i < n; i++) {
            originalSum += nums[i];
        }
        return expectedSum - originalSum;
    }
}
