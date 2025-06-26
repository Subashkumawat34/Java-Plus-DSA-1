
import java.util.HashSet;

public class LongestSubstringwithKUniques {

    public static int longestkSubstr(String s, int k) {
        int maxLength = -1;
        for (int i = 0; i < s.length(); i++) {
            HashSet<Character> uniqueChars = new HashSet<>();
            for (int j = i; j < s.length(); j++) {
                uniqueChars.add(s.charAt(j));
                if (uniqueChars.size() == k) {
                    int length = j - i + 1;
                    maxLength = Math.max(maxLength, length);
                }
                if (uniqueChars.size() > k) {
                    break;
                }
            }
        }
        return maxLength;
    }

    public static int longestKSubStrWithSlidingWindow(String s, int k) {
        int maxLength = Integer.MIN_VALUE;
        int n = s.length();
        int windowStart = 0;
        int windowEnd = 0;
        int UniqueCharCount = 0;
        int length = 0;
        int frqArr[] = new int[26];

        while (windowEnd < n) {
            //Expansion phase
            int index = (s.charAt(windowEnd) - 97);
            if (frqArr[index] == 0) {
                UniqueCharCount++;
            }
            frqArr[index]++;

            if (UniqueCharCount == k) {
                length = windowEnd - windowStart + 1;
                maxLength = Math.max(maxLength, length);
            } //Shrinking phase
            else if (UniqueCharCount > k) {
                while (windowStart < windowEnd && UniqueCharCount > k) {
                    windowStart++;
                    index = s.charAt(windowStart) - 97;
                    frqArr[index]--;
                    if (frqArr[index] == 0) {
                        UniqueCharCount--;
                    }
                }
            }
            windowEnd++;
        }

        return (maxLength == Integer.MIN_VALUE ? -1 : maxLength);
    }

    public static void main(String[] args) {
        String s = "aabacbebebe";
        int k = 3;
        // int res = longestkSubstr(s, k);
        // System.out.println(res);

        int res = longestKSubStrWithSlidingWindow(s, k);
        System.out.println(res);
    }
}

// https://www.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853/1
// Longest Substring with K Uniques
// Difficulty: MediumAccuracy: 34.65%Submissions: 195K+Points: 4
// Given a string s, you need to print the size of the longest possible substring with exactly k unique characters. If no possible substring exists, print -1.
// Examples:
// Input: s = "aabacbebebe", k = 3
// Output: 7
// Explanation: "cbebebe" is the longest substring with 3 distinct characters.
// Input: s = "aaaa", k = 2
// Output: -1
// Explanation: There's no substring with 2 distinct characters.
// Input: s = "aabaaab", k = 2
// Output: 7
// Explanation: "aabaaab" is the longest substring with 2 distinct characters.
// Constraints:
// 1 ≤ s.size() ≤ 105
// 1 ≤ k ≤ 26
// All characters are lowercase letters
