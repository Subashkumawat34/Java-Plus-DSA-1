
public class CyclicSortWithRandomArray {

    public static void main(String[] args) {
        int arr[] = {12, 43, 3, 67, 9, 4, 8, 33};
        cyclicSortWithRandomArray(arr);
        printArr(arr, "The Sorted array using CyclicSort is ");
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

    public static void cyclicSortWithRandomArray(int arr[]) {
        int n = arr.length;

        for (int cycles = 0; cycles < n - 1; cycles++) {
            int item = arr[cycles];
            int position = cycles;

            // Find the correct position for the current item
            for (int i = cycles + 1; i < n; i++) {
                if (arr[i] < item) {
                    position++;
                }
            }

            // If the item is already in the correct position, move to the next cycle
            if (position == cycles) {
                continue;
            }

            // Skip duplicates
            while (arr[position] == item) {
                position++;
            }

            // Swap the items
            if (position != cycles) {
                int temp = arr[position];
                arr[position] = item;
                item = temp;
            }

            // Rotate the remaining cycle
            while (position != cycles) {
                position = cycles;

                // Find the correct position for the current item
                for (int i = cycles + 1; i < n; i++) {
                    if (arr[i] < item) {
                        position++;
                    }
                }

                // Skip duplicates
                while (arr[position] == item) {
                    position++;
                }

                // Swap the items
                if (item != arr[position]) {
                    int temp = arr[position];
                    arr[position] = item;
                    item = temp;
                }
            }
        }
    }
}
