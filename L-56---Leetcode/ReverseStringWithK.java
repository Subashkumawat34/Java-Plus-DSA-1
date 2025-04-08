
public class ReverseStringWithK {

    public static void main(String[] args) {
        String s = "abcdefg";
        int k = 3;
        String res = reverseStr(s, k);
        System.out.println(res);
    }

    public static String reverseStr(String s, int k) {
        char arr[] = s.toCharArray();
        int n = arr.length;
        int index1 = 0;

        while (index1 < n) {
            int index2 = Math.min(index1 + k - 1, n - 1);
            reverse(arr, index1, index2);
            index1 = index1 + 2 * k;
        }
        return new String(arr);
    }

    public static void reverse(char arr[], int index1, int index2) {
        while (index1 < index2) {
            char temp = arr[index1];
            arr[index1] = arr[index2];
            arr[index2] = temp;
            index1++;
            index2--;
        }
    }
}
