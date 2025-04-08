
public class PigeonholeSort {

    public static void main(String[] args) {
        int arr[] = {2, 7, 1, 5, 0, 1, 12};
        pigeonHoleSort(arr);
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

    public static void pigeonHoleSort(int arr[]) {
        int n = arr.length;
        if (n == 0) {
            System.out.println("Array is Empty");
            return;
        }

        int maxVal = Integer.MIN_VALUE;
        int minVal = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (arr[i] > maxVal) {
                maxVal = arr[i];
            }
            if (arr[i] < minVal) {
                minVal = arr[i];
            }
        }

        int size = maxVal - minVal + 1;
        int pigeonHole[] = new int[size];

        // Count occurrences
        for (int i = 0; i < n; i++) {
            int index = arr[i] - minVal;

            pigeonHole[index]++;
            //pigeonHole[arr[i] - minVal]++;
        }

        int insertionIndex = 0;
        // Reconstruct the original sorted array
        for (int i = 0; i < size; i++) {
            while (pigeonHole[i] > 0) {
                arr[insertionIndex] = i + minVal;  // Fixed here
                insertionIndex++;
                pigeonHole[i]--;
            }
        }
    }
}
