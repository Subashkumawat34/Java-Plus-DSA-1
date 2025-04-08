
public class ParityOddEvenBrickSort {

    public static void main(String[] args) {
        int arr[] = {21, 45, 23, 43, 32, 77, 90, 24, 26};
        ParitySort(arr);
        printArr(arr, "Sorted array is: ");

    }

    public static void ParitySort(int arr[]) {
        int n = arr.length;
        boolean isSorted = false;
        while (!isSorted) {
            //even index swaping
            boolean flag = false;
            for (int i = 0; i <= n - 2; i += 2) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                    flag = true;
                }
            }

            //odd inde swaping
            for (int i = 1; i <= n - 2; i += 2) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                    flag = true;
                }
            }
            if (!flag) {
                isSorted = true;
                break;

            }

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
