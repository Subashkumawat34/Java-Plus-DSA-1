//Leetcode-921;

import java.util.Stack;

public class MakeParanthasisValid {

    public static void main(String[] args) {
        String s = "(((";
        int res = minAddToMakeValid1(s);
        System.out.println(res);

        int res2 = minAddToMakeValid2(s);
        System.out.println(res2);
    }

    public static int minAddToMakeValid1(String s) {
        // if (s.length() % 2 != 0) {
        //     return -1;
        // }
        int open = 0;
        int close = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                open++;
            } else {
                if (open <= 0) {
                    close++;
                } else {
                    open--;
                }
            }
        }
        return (open + close);
    }

    public static int minAddToMakeValid2(String s) {
        // if (s.length() % 2 != 0) {
        //     return -1;
        // }
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(ch);
            } else {
                if (stack.isEmpty() || stack.peek() == ')') {
                    stack.push(ch);
                } else {
                    stack.pop();
                }
            }
        }
        return stack.size();
    }
}
