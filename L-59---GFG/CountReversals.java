// gfg problem ---> count retraversals

import java.util.Stack;
 
public class CountReversals {

    public static void main(String[] args) {
        String S = "}{{}}{{{";
        int ans = countRev(S);
        System.out.print("Count of Traversals is: " + ans);
    }

    public static int countRev(String s) {

        if (s.length() % 2 != 0) {
            return -1;
        }
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '{') {
                stack.push(ch);
            } else {
                if (stack.isEmpty() || stack.peek() == '}') {
                    stack.push(ch);
                } else {
                    stack.pop();
                }
            }
        }
        int res = 0;
        int open = 0;
        int close = 0;

        while (!stack.isEmpty()) {
            char top = stack.pop();
            if (top == '{') {
                open++;
            } else {
                close++;
            }
        }
        res = (int) (Math.ceil((open / 2.0)) + (Math.ceil(close / 2.0)));
        return res;
    }
}
