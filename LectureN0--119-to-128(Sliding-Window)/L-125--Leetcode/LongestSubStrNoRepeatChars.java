
import java.util.HashMap;
import java.util.HashSet;

public class LongestSubStrNoRepeatChars {

    public static int LongestStr(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int maxLength = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            HashSet<Character> uniqueChars = new HashSet<>();
            for (int j = i; j < n; j++) {
                char currentChar = s.charAt(j);
                if (uniqueChars.contains(currentChar)) {
                    break;
                }
                System.out.println(currentChar);
                uniqueChars.add(currentChar);
                int length = j - i + 1;
                maxLength = Math.max(maxLength, length);
            }
        }
        return maxLength;
    }

    public static int LongeststrWithSlidingWindow(String s) {
        int n = s.length();
        int maxLength = Integer.MIN_VALUE;
        int windowStart = 0;
        int windowEnd = 0;
        HashSet<Character> uniqueChars = new HashSet<>();

        while (windowEnd < n) {
            char currentChar = s.charAt(windowEnd);
            if (uniqueChars.contains(currentChar)) {
                //Shrinking
                while (windowStart < windowEnd && uniqueChars.contains(currentChar)) {
                    uniqueChars.remove(s.charAt(windowStart));
                    windowStart++;
                }
            }
            //Expansion
            uniqueChars.add(currentChar);
            int length = windowEnd - windowStart + 1;
            maxLength = Math.max(maxLength, length);
            windowEnd++;
        }
        return (maxLength == Integer.MIN_VALUE ? 0 : maxLength);
    }

    public static int LongeststrWithSlidingWindowOptimized(String s) {
        int n = s.length();
        int windowStart = 0;
        int windowEnd = 0;
        int maxLength = Integer.MIN_VALUE;
        HashMap<Character, Integer> charsMap = new HashMap();

        while (windowEnd < n) {
            char currentChar = s.charAt(windowEnd);
            if (charsMap.containsKey(currentChar) && charsMap.get(currentChar) >= windowStart) {
                windowStart = charsMap.get(currentChar) + 1;
            }
            charsMap.put(currentChar, windowEnd);
            int length = windowEnd - windowStart + 1;
            maxLength = Math.max(maxLength, length);
            windowEnd++;
        }
        return (maxLength == Integer.MIN_VALUE ? 0 : maxLength);
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        // int res = LongestStr(s);
        // System.out.println(res);
        // int res = LongeststrWithSlidingWindow(s);
        // System.out.println(res);
        int res = LongeststrWithSlidingWindowOptimized(s);
        System.out.println(res);
    }
}

//https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
// 3. Longest Substring Without Repeating Characters
// Medium
// Topics
// premium lock icon
// Companies
// Hint
// Given a string s, find the length of the longest substring without duplicate characters.
// Example 1:
// Input: s = "abcabcbb"
// Output: 3
// Explanation: The answer is "abc", with the length of 3.
// Example 2:
// Input: s = "bbbbb"
// Output: 1
// Explanation: The answer is "b", with the length of 1.
// Example 3:
// Input: s = "pwwkew"
// Output: 3
// Explanation: The answer is "wke", with the length of 3.
// Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
// Constraints:
// 0 <= s.length <= 5 * 104
// s consists of English letters, digits, symbols and spaces.
