
public class BubbleSort {

    public static void main(String[] args) {

        int arr[] = {23, 54, 3, 12, 89, 23, 34, 12};
        BubbleSort(arr);
        printArr(arr, "Sorted arr is ");
    }

    public static void BubbleSort(int arr[]) {
        int n = arr.length;
        int passes = n - 2;
        for (int i = 0; i < passes; i++) {
            boolean flag = false;
            for (int j = 0; j <= passes - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    flag = true;
                }
            }
            if (!flag) {
                System.err.println("no passes for swaping");
                break;
            }
            printArr(arr, "after pass " + i);

        }

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

    public static void swap(int arr[], int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
