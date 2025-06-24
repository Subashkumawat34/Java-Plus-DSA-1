
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CountOccuracesOfAnagrams {

    public static int CountOccurencesOfAnagrams(String txt, String pattern) {
        int count = 0;
        int m = txt.length();
        int n = pattern.length();

        for (int i = 0; i <= m - n; i++) {
            String subString = txt.substring(i, i + n);
            if (isAnagram(subString, pattern)) {
                count++;
            }
        }

        return count;
    }

    public static boolean isAnagram(String s1, String s2) {
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        if (Arrays.equals(arr1, arr2)) {
            return true;
        }
        return false;
    }

    public static int CountOccurencesOfAnagramsWithSlidingWindow(String pattern, String txt) {
        int patternFrq[] = new int[26];
        int k = pattern.length();

        //Calculate the frequency of pattern
        for (int i = 0; i < k; i++) {
            int index = pattern.charAt(i) - 97;
            patternFrq[index]++;
        }

        //initialize the window
        int n = txt.length();
        int txtFrq[] = new int[26];
        for (int i = 0; i < k; i++) {
            int index = txt.charAt(i) - 97;
            txtFrq[index]++;
        }
        //Count the frequency
        int count = 0;
        if (Arrays.equals(patternFrq, txtFrq)) {
            count++;
        }
        //calculate others windows and count
        for (int i = 1; i < n - k + 1; i++) {
            int removeCharIndex = txt.charAt(i - 1) - 97;
            int addedCharIndex = txt.charAt(i + k - 1) - 97;
            txtFrq[removeCharIndex]--;
            txtFrq[addedCharIndex]++;

            if (Arrays.equals(patternFrq, txtFrq)) {
                count++;
            }
        }
        return count;
    }

    public static int countAnagramsUsingHashMap(String pattern, String txt) {
        int k = pattern.length();
        int n = txt.length();
        if (k > n) {
            return 0;
        }

        Map<Character, Integer> patternMap = new HashMap<>();
        Map<Character, Integer> windowMap = new HashMap<>();

        // Step 1: Build pattern frequency map
        for (char ch : pattern.toCharArray()) {
            patternMap.put(ch, patternMap.getOrDefault(ch, 0) + 1);
        }

        // Step 2: Initialize the first window
        for (int i = 0; i < k; i++) {
            char ch = txt.charAt(i);
            windowMap.put(ch, windowMap.getOrDefault(ch, 0) + 1);
        }

        int count = 0;
        if (patternMap.equals(windowMap)) {
            count++;
        }

        // Step 3: Slide the window
        for (int i = 1; i < n - k + 1; i++) {
            // Remove the leftmost character
            char leftChar = txt.charAt(i - 1);
            windowMap.put(leftChar, windowMap.get(leftChar) - 1);
            if (windowMap.get(leftChar) == 0) {
                windowMap.remove(leftChar);
            }

            // Add the new character
            char rightChar = txt.charAt(i + k - 1);
            windowMap.put(rightChar, windowMap.getOrDefault(rightChar, 0) + 1);

            if (patternMap.equals(windowMap)) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        String txt = "forxxorfxdofr";
        String pattern = "for";

        // int ans = CountOccurencesOfAnagrams(txt, pattern);
        // System.out.println(ans);
        // int ans = CountOccurencesOfAnagramsWithSlidingWindow(pattern, txt);
        // System.out.println(ans);
        int ans = countAnagramsUsingHashMap(pattern, txt);
        System.out.println(ans);

    }
}

// https://www.geeksforgeeks.org/problems/count-occurences-of-anagrams5839/1
// Count Occurences of Anagrams
// Difficulty: MediumAccuracy: 48.09%Submissions: 90K+Points: 4
// Given a word pat and a text txt. Return the count of the occurrences of anagrams of the word in the text.
// Example 1:
// Input: txt = "forxxorfxdofr", pat = "for"
// Output: 3
// Explanation: for, orf and ofr appears in the txt, hence answer is 3.
// Example 2:
// Input: txt = "aabaabaa", pat = "aaba"
// Output: 4
// Explanation: aaba is present 4 times in txt.
// Constraints:
// 1 <= |pat| <= |txt| <= 105
// Both strings contain lowercase English letters.
