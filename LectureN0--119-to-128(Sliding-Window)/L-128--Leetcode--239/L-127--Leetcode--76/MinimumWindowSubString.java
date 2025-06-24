
import java.util.HashMap;

public class MinimumWindowSubString {

    public static String minimumWindowSubstring(String s, String t) {
        int minlength = Integer.MAX_VALUE;
        String result = "";
        //frequency array of all txt
        int txtFrq[] = new int[128];
        for (char ch : t.toCharArray()) {
            txtFrq[ch]++;
        }

        //find all the substrings
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int windowFrq[] = new int[128];
            for (int j = i; j < n; j++) {
                windowFrq[s.charAt(j)]++;

                //check the subarray is valid or not
                if (containsAll(windowFrq, txtFrq)) {
                    if (j - i + 1 < minlength) {
                        minlength = j - i + 1;
                        result = s.substring(i, j + 1);
                    }
                    break;
                }
            }
        }
        return result;
    }

    public static boolean containsAll(int[] windowFrq, int[] txtFrq) {
        for (int i = 0; i < 128; i++) {
            if (txtFrq[i] > windowFrq[i]) {
                return false;
            }
        }
        return true;
    }

    public static String minWindowSubstringWithSlidingWindow(String s, String t) {
        // Step 1: Create a frequency map for characters in string t
        HashMap<Character, Integer> txtFrq = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            txtFrq.put(ch, txtFrq.getOrDefault(ch, 0) + 1);
        }

        // Step 2: Initialize variables for sliding window
        int uniqueCharCount = txtFrq.size(); // Total distinct characters in t that need to be matched
        int startIndex = -1;                 // Start index of the minimum window found
        int windowStart = 0;                 // Start pointer of the window
        int windowEnd = 0;                   // End pointer of the window
        int minLength = Integer.MAX_VALUE;   // Length of the smallest valid window
        int n = s.length();                  // Length of string s

        // Step 3: Start sliding the window
        while (windowEnd < n) {
            char ch = s.charAt(windowEnd);

            // If current character is part of t, reduce its frequency
            if (txtFrq.containsKey(ch)) {
                txtFrq.put(ch, txtFrq.get(ch) - 1);

                // When frequency becomes 0, one required character is fully matched
                if (txtFrq.get(ch) == 0) {
                    uniqueCharCount--;
                }
            }

            // Step 4: Try to shrink the window when all required characters are matched
            while (uniqueCharCount == 0) {
                // Update minimum window if a smaller valid window is found
                int len = windowEnd - windowStart + 1;
                if (len < minLength) {
                    minLength = len;
                    startIndex = windowStart;
                }

                // Try to remove character at windowStart from the window
                char startChar = s.charAt(windowStart);
                if (txtFrq.containsKey(startChar)) {
                    txtFrq.put(startChar, txtFrq.get(startChar) + 1);

                    // If frequency becomes > 0, that character is now missing from window
                    if (txtFrq.get(startChar) > 0) {
                        uniqueCharCount++;
                    }
                }
                windowStart++; // Shrink the window from the left
            }

            windowEnd++; // Expand the window from the right
        }

        // Step 5: Return the minimum window substring found, or "" if none
        if (startIndex == -1) {
            return "";
        }
        return s.substring(startIndex, startIndex + minLength);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String txt = "ABC";

        // System.out.println(minimumWindowSubstring(s, txt));
        System.out.println(minWindowSubstringWithSlidingWindow(s, txt));
    }
}

// 🧠 Step-by-Step Explanation:
// Goal:
// Find the minimum window substring in s that contains all characters of t (including duplicates).
// 🔄 Steps of the Algorithm:
// Build a Frequency Map:
// Store how many times each character appears in t.
// Initialize Two Pointers:
// windowStart and windowEnd define the current window in s.
// Expand the Window:
// Move windowEnd to include new characters from s.
// If the current character is in the frequency map, decrease its count.
// If the character’s count hits zero, one type of character is fully matched.
// Shrink the Window:
// When all characters are matched (i.e., uniqueCharCount == 0), try shrinking the window from the start (windowStart) to minimize it.
// If shrinking causes a needed character to go missing (i.e., count becomes > 0), increase uniqueCharCount.
// Track Minimum Window:
// Every time a valid window is found, compare its length with minLength. If it's smaller, update minLength and startIndex.
// Return the Result:
// If a window was found (startIndex != -1), return the substring.
// Otherwise, return an empty string.
// https://leetcode.com/problems/minimum-window-substring/
// 76. Minimum Window Substring
// Solved
// Hard
// Topics
// premium lock icon
// Companies
// Hint
// Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".
// The testcases will be generated such that the answer is unique.
// Example 1:
// Input: s = "ADOBECODEBANC", t = "ABC"
// Output: "BANC"
// Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
// Example 2:
// Input: s = "a", t = "a"
// Output: "a"
// Explanation: The entire string s is the minimum window.
// Example 3:
// Input: s = "a", t = "aa"
// Output: ""
// Explanation: Both 'a's from t must be included in the window.
// Since the largest window of s only has one 'a', return empty string.
// Constraints:
// m == s.length
// n == t.length
// 1 <= m, n <= 105
// s and t consist of uppercase and lowercase English letters.
