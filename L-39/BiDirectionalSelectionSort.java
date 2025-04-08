public class BiDirectionalSelectionSort {

    public static void main(String[] args) {
        int arr[] = {2,7,1,5,0,1,12};
        biSelectionSort(arr);
        printArr(arr, "Sorted array is: ");
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

    public static void biSelectionSort(int arr[]) {
        int n = arr.length;
        int k = n - 1;

        for (int i = 0; i < k; i++) {
            int minIndex = i;
            int maxIndex = k;

            // Find min and max in the remaining unsorted part
            for (int j = i; j <= k; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
                if (arr[j] > arr[maxIndex]) {
                    maxIndex = j;
                }
            }

            // Swap min element with i
            swap(arr, i, minIndex);

            // Adjust maxIndex if it was swapped with i
            if (maxIndex == i) {
                maxIndex = minIndex;
            }

            // Swap max element with k
            swap(arr, k, maxIndex);

            // Move k inwards
            k--;
        }
    }

    public static void swap(int arr[], int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
