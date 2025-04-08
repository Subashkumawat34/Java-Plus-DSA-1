
public class CountingSort {

    public static void main(String[] args) {
        int arr[] = {87, 43, 1, 21, 65, 32, 2, 8, 54};
        int res[] = countingSort(arr);
        printArr(res, "Sorted array is ");
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

    public static int[] countingSort(int arr[]) {

        //Fint max element k
        int k = Integer.MIN_VALUE;
        int n = arr.length;
        int res[] = new int[n];

        for (int i = 0; i < n; i++) {
            if (arr[i] > k) {
                k = arr[i];
            }
        }

        if (k == Integer.MIN_VALUE) {
            System.out.println("Erray is Empty");
            return res;
        }

        int countArr[] = new int[k + 1];
        //Find the Frequency

        for (int i = 0; i < n; i++) {
            int index = arr[i];
            countArr[index] += 1;
        }

        //Find Cumulitive Frequency
        for (int i = 1; i <= k; i++) {
            countArr[i] += countArr[i - 1];
        }

        //Find the sorted array
        for (int i = n - 1; i >= 0; i--) {
            int val = arr[i];
            int countVal = --countArr[val];
            res[countVal] = val;
        }
        return res;

    }
}
