
public class InsertionSort {

    public static void main(String args[]) {
        int arr[] = {1, 4, 79, 34, 54, 12, 33, 8};
        sort(arr);
        printArr(arr, "Sorted Array is : ");

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

    public static void sort(int arr[]) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            //Shifting logic
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            //Place the key at j+1
            arr[j + 1] = key;
        }
    }
}
