
public class ArrayMemoryAllocation {

    public static void main(String[] args) {
        int arr1[] = new int[3];
        arr1[0] = 4;
        int arr2[] = arr1;
        arr2[0] = 6;
        int arr3[] = new int[3];
        arr3[0] = 9;
        System.out.println(arr1[0]);
        System.out.println(arr2[0]);
        System.out.println(arr3[0]);
    }
}
