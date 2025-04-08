//Leetcode problem 151..

public class ReverseWords {

    public static void main(String[] args) {
        String s = "the sky is blue";
        String res1 = reverseWords1(s);
        System.out.println(res1);
        String res2 = reverseWords2(s);
        System.out.println(res2);

    }

    public static String reverseWords1(String s) {
        String arr[] = s.split(" ");
        //String res = "";
        StringBuilder res = new StringBuilder();

        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i].length() == 0) {
                continue;
            }
            if (res.length() == 0) {
                // res += arr[i];
                res.append(arr[i]);
            } else {
                // res += "" + arr[i];
                res.append(" ");
                res.append(arr[i]);
            }
        }
        return res.toString();
    }

    public static String reverseWords2(String s) {
        StringBuilder str = new StringBuilder();
        int startIdx = s.length() - 1;
        while (startIdx >= 0) {
            while (startIdx >= 0 && s.charAt(startIdx) == ' ') {
                startIdx--;
            }

            if (startIdx < 0) {
                break;
            }
            int endIdx = startIdx;
            while (startIdx >= 0 && s.charAt(startIdx) != ' ') {
                startIdx--;
            }
            if (str.length() == 0) {
                str.append(s.substring(startIdx + 1, endIdx + 1));
            } else {
                str.append(" ");
                str.append(s.subSequence(startIdx + 1, endIdx + 1));
            }
        }
        return str.toString();
    }
}
