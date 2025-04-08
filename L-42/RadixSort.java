
public class RadixSort {

    public static void main(String[] args) {
        int arr[] = {203, 100, 343, 234, 777, 324, 111, 309, 130, 21};
        radixSort(arr);
        printArr(arr, "sorted array is ");;

    }

    public static void printArr(int arr[], String message) {
        System.out.print(message);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i != arr.length - 1) {
                System.out.print(",");
            }
        }
        System.out.println();
    }

    public static void countingSortingWithDigits(int arr[], int digits) {
        int n = arr.length;
        int k = 9;
        int res[] = new int[n];

        //Find the Frequency 
        int countArr[] = new int[k + 1];
        for (int i = 0; i < n; i++) {
            int index = (arr[i] / digits) % 10;
            countArr[index] += 1;
        }

        //find Commulative requency
        for (int i = 1; i <= k; i++) {
            countArr[i] += countArr[i - 1];
        }
        //Find the original array
        for (int i = n - 1; i >= 0; i--) {
            int val = arr[i];
            int countIndex = (arr[i] / digits) % 10;
            int countVal = --countArr[countIndex];
            res[countVal] = val;

        }
        //Copy Result to original array
        for (int i = 0; i < n; i++) {
            arr[i] = res[i];
        }
    }

    public static void radixSort(int arr[]) {
        int n = arr.length;
        int maxAl = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (arr[i] > maxAl) {
                maxAl = arr[i];
            }
        }

        if (maxAl == Integer.MIN_VALUE) {
            System.out.print("Empty array");
            return;
        }

        for (int digit = 1; maxAl / digit > 0; digit *= 10) {
            countingSortingWithDigits(arr, digit);
        }
    }

}
