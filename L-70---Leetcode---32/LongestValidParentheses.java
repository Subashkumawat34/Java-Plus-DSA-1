//Leetcode---32;
// In ArrayList if we can insert a vslue at a already inserted index so the next values is sifted by 1 and the value is inserted with index.

import java.util.ArrayList;
import java.util.Stack;

public class LongestValidParentheses {
    public static void main(String[] args) {
        String s = ")()())";
        int res = longestValidParentheses(s);
        System.out.println("Valid parenthesis in continuity is: " + res);

    }

    public static int longestValidParentheses(String s) {
        //remove all valid parenthasis
        Stack<Integer> stack = new Stack<Integer>();
        removeValidParenthesis(s, stack);

        //if stack is empty then we dont have any valid parenthesis
        if (stack.isEmpty()) {
            return s.length();
        }
        ArrayList<Integer> arr = new ArrayList<>();
        fornArrayOfInvalidIndexes(arr, stack, s);

        int max = 0;
        for (int i = 1; i < arr.size(); i++) {
            int prev = arr.get(i - 1);
            max = Math.max(max, arr.get(i) - prev - 1);
        }
        return max;
    }

    public static void removeValidParenthesis(String s, Stack<Integer> stack) {
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(i);
            } else {
                if (stack.isEmpty() || s.charAt(stack.peek()) == ')') {
                    stack.push(i);
                } else {
                    stack.pop();
                }
            }
        }
    }

    public static void fornArrayOfInvalidIndexes(ArrayList<Integer> arr, Stack<Integer> stack, String s) {
        arr.add(0, s.length());
        //now stack will have only a valid parenthasis
        while (!stack.isEmpty()) {
            arr.add(0, stack.pop());
        }
        arr.add(0, -1);
    }
}

// 32. Longest Valid Parentheses
// Hard
// Topics
// Companies
// Given a string containing just the characters '(' and ')', return the length of the longest valid (well-formed) parentheses 
// substring
// .
// Example 1:
// Input: s = "(()"
// Output: 2
// Explanation: The longest valid parentheses substring is "()".
// Example 2:
// Input: s = ")()())"
// Output: 4
// Explanation: The longest valid parentheses substring is "()()".
// Example 3:
// Input: s = ""
// Output: 0
// Constraints:
// 0 <= s.length <= 3 * 104
// s[i] is '(', or ')'.
