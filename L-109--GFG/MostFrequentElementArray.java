
public class MostFrequentElementArray {

    public static int countFrequency(int arr[], int element) {
        int frequency = 0;
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] == element) {
                frequency++;
            }
        }
        return frequency;
    }

    public static void findMostFrequency(int arr[]) {
        int ans = -1;
        int ansFreq = 0;
        for (int i = 0; i < arr.length; i++) {
            int element = arr[i];
            int frequency = countFrequency(arr, element);

            if (frequency > ansFreq) {
                ans = element;
                ansFreq = frequency;
            }
        }
        System.out.println("Most Frequent Element is " + ans);
        System.out.println("The Frequency of Element is " + ansFreq);
    }

    public static void main(String[] args) {
        int arr[] = {2, 1, 7, 8, 2, 1, 9, 10, 9, 9, 2, 8, 2};
        findMostFrequency(arr);
    }
}
