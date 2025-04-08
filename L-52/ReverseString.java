
public class ReverseString {

    public static void main(String[] args) {
        String name = "Kumawat";
        reverseString1(name);
        StringBuilder res = new StringBuilder(name);
        reverseString2(res);
    }

    public static void reverseString1(String name) {
        int n = name.length();
        String str = "";
        for (int i = 0; i < n; i++) {
            str = name.charAt(i) + str;
        }
        System.out.println(str);
    }

    public static void reverseString2(StringBuilder name) {
        int n = name.length();
        for (int i = 0; i < n/2; i++) {
            char firstIdx = name.charAt(i);
            char lastIdx = name.charAt(n - 1 - i);
            name.setCharAt(i, lastIdx);
            name.setCharAt(n - 1 - i, firstIdx);
        }
        System.out.println(name.toString());
    }
}
