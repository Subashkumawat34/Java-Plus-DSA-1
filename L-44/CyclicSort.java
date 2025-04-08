
public class CyclicSort {

    public static void main(String[] args) {
        int arr[] = {2, 7, 1, 5, 4, 6, 0, 3};
        cyclicSort(arr);
        printArr(arr, "Cyclic Sorted Array is ");
    }

    public static void swap(int arr[], int index, int actualPos) {
        int temp = arr[index];
        arr[index] = arr[actualPos];
        arr[actualPos] = temp;
    }

    public static void printArr(int arr[], String message) {
        System.out.print(message);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i != arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    public static void cyclicSort(int arr[]) {
        int n = arr.length;
        int index = 0;
        while (index < n) {
            int element = arr[index];
            //this is valid if the range of given array is 1 to n
            //int actualPos = element - 1;

            //this is valid if the range of given array is 0  to n
            int actualPos = element;
            if (arr[index] < n && arr[index] != arr[actualPos]) {
                swap(arr, index, actualPos);
            } else {
                index++;
            }
        }
    }
}
