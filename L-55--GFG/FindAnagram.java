
import java.util.Arrays;

public class FindAnagram {

    public static void main(String[] args) {
        String s1 = "geeks";
        String s2 = "kseeg";
        boolean res1 = areAnagrams1(s1, s2);
        System.out.println(res1);

        boolean res2 = areAnagrams2(s1, s2);
        System.out.println(res2);
    }

    public static boolean areAnagrams1(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        char arrA[] = s1.toCharArray();
        char arrB[] = s2.toCharArray();
        Arrays.sort(arrA);
        Arrays.sort(arrB);
        int index1 = 0;
        int index2 = 0;
        int length = arrA.length;
        while (index1 < length && index2 < length) {
            if (arrA[index1] != arrB[index2]) {
                return false;
            }
            index1++;
            index2++;
        }
        return true;
    }

    public static boolean areAnagrams2(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int frequency[] = new int[26];
        int index1 = 0;
        int index2 = 0;
        int length = s1.length();
        while (index1 < length && index2 < length) {
            char charA = s1.charAt(index1);
            int frequencyIdxA = charA - 97;
            frequency[frequencyIdxA] += 1;

            char charB = s2.charAt(index2);
            int frequencyIdxB = charB - 97;
            frequency[frequencyIdxB] -= 1;

            index1++;
            index2++;
        }
        for (int i = 0; i < 26; i++) {
            if (frequency[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
