//Leetcode-1963

import java.util.Stack;

public class SwapsToMakeStringBalanced {

    public static void main(String[] args) {
        String s = "]]][[[";
        int res1 = minSwaps1(s);
        System.out.println(res1);

        int res2 = minSwaps2(s);
        System.out.println(res2);
    }

    public static int minSwaps1(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '[') {
                stack.push(ch);
            } else {
                if (stack.isEmpty() || stack.peek() == ']') {
                    stack.push(ch);
                } else {
                    stack.pop();
                }
            }
        }
        int totalBrackets = stack.size();
        int closeBrackets = totalBrackets / 2;
        return (closeBrackets + 1) / 2;// in this +1 is use to handle odd no of pairs and the even number can't affacted for this +1 because we are taking floor value for example -->  2.5 will becomes --> 2
        //return ((stack.size() / 2) + 1) / 2;
    }

    public static int minSwaps2(String s) {
        int open = 0;
        int close = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '[') {
                open++;
            } else {
                if (open <= 0) {
                    close++;
                } else {
                    open--;
                }
            }
        }
        return (close + 1) / 2;
    }
}
