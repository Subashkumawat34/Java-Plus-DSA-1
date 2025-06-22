
// import java.util.ArrayList;
// import java.util.Collections;
// public class BucketSort {
//     public static float findMax(float arr[]) {
//          float maxElement = Float.MIN_VALUE;
//         for (int i = 1; i < arr.length; i++) {
//             maxElement = Math.max(maxElement, arr[i]);
//         }
//         return maxElement;
//     }
//     public static ArrayList<Float> BucketSorting(float arr[]) {
//         if (arr.length == 0) {
//             return new ArrayList<>();
//         }
//         //find the bucket size
//         float maxElement = findMax(arr);
//         int maxIndex = (int) (maxElement * arr.length);
//         int bucketSize = maxIndex + 1;
//         //init bucket size
//         ArrayList<Float> buckets[] = new ArrayList[bucketSize];
//         for (int i = 0; i < bucketSize; i++) {
//             buckets[i] = new ArrayList<>();
//         }
//         //insert element in the bucket
//         for (int i = 0; i < arr.length; i++) {
//             int index = (int) (arr[i] * bucketSize);
//             buckets[index].add(arr[i]);
//         }
//         //sort the buckets
//         for (int i = 0; i < bucketSize; i++) {
//             Collections.sort(buckets[i]);
//         }
//         //store the elements and store in result List
//         ArrayList<Float> res = new ArrayList<>();
//         for (int i = 0; i < bucketSize; i++) {
//             for (float element : buckets[i]) {
//                 res.add(element);
//             }
//         }
//         return res;
//     }
//     public static void main(String[] args) {
//         float arr[] = {0.32f, 0.43f, 0.76f, 0.98f, 0.11f, 0.3f, 0.65f, 0.44f, 0.02f};
//         ArrayList<Float> res = new BucketSorting(arr);
//         System.out.println(res);
//     }
// }
import java.util.ArrayList;
import java.util.Collections;

public class BucketSort {

    public static float findMax(float arr[]) {
        float maxElement = Float.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            maxElement = Math.max(maxElement, arr[i]);
        }
        return maxElement;
    }

    public static ArrayList<Float> BucketSorting(float arr[]) {
        if (arr.length == 0) {
            return new ArrayList<>();
        }
        //find the bucket size
        float maxElement = findMax(arr);
        int bucketSize = (int) (maxElement * arr.length);

        // Create empty buckets
        ArrayList<Float>[] buckets = new ArrayList[bucketSize];
        for (int i = 0; i < bucketSize; i++) {
            buckets[i] = new ArrayList<>();
        }

        // Put array elements into buckets
        for (int i = 0; i < arr.length; i++) {
            int index = (int) (arr[i] * bucketSize);
            // buckets[index].add(arr[i]);
            int targetIndex = 0;

            //Sort each bucket and insert
            while (targetIndex < buckets[index].size() && arr[i] > buckets[index].get(targetIndex)) {
                targetIndex++;
            }
            buckets[index].add(targetIndex, arr[i]);
        }

        // // Sort each bucket
        // for (int i = 0; i < bucketSize; i++) {
        //     Collections.sort(buckets[i]);
        // }
        // Concatenate buckets and store result
        ArrayList<Float> res = new ArrayList<>();
        for (int i = 0; i < bucketSize; i++) {
            System.err.println("Buckets " + i + " " + buckets[i]);
            res.addAll(buckets[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        float arr[] = {0.32f, 0.43f, 0.76f, 0.98f, 0.11f, 0.3f, 0.65f, 0.44f, 0.02f};
        ArrayList<Float> res = BucketSorting(arr);
        System.out.println("Sorted Array: " + res);
    }
}
