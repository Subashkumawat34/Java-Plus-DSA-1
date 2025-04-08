
public class AllSubstring {

    public static void main(String[] args) {
        String input = "subhash";
        printAllSubstrings(input);
    }

    public static void printAllSubstrings(String input) {
        int n = input.length();
        for (int startIdx = 0; startIdx < n; startIdx++) {
            for (int endIdx = startIdx + 1; endIdx <= n; endIdx++) {
                System.out.println(input.substring(startIdx, endIdx));
            }
        }
    }
}
