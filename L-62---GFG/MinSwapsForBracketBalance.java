// gfg problem find the minimum swaps for berackets balances.
public class MinSwapsForBracketBalance {

    public static void main(String[] args) {
        String s = "[]]]][][[[[]";
        int res = minimumNumberOfSwaps(s);
        System.out.println("minimum swaps fpr bracket balances: " + res);
    }

    public static int minimumNumberOfSwaps(String s) {
        int open = 0;
        int close = 0;
        int unbalanced = 0;
        int swaps = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '[') {
                open++;
                if (unbalanced > 0) {
                    swaps += unbalanced;
                    unbalanced--;
                }
            } else {
                close++;
                unbalanced = close - open;
            }
        }
        return swaps;
    }
}
