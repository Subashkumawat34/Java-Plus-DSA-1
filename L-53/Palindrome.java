
import java.awt.im.InputContext;

public class Palindrome {

    public static void main(String[] args) {
        String name = "SsAasS";
        boolean res = palindromeNumber(name);
        System.out.println(res);

    }

    public static boolean palindromeNumber(String name1) {
        String name = name1.toLowerCase();
        int start = 0;
        int end = name.length() - 1;

        while (start < end) {
            if (name.charAt(start) != name.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;

    }
}
