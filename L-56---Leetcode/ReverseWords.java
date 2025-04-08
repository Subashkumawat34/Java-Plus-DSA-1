
public class ReverseWords {

    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        String res = reverseWords(s);
        System.out.println(res);
    }

    public static String reverseWords(String s) {

        //Conver to character array
        char charArr[] = s.toCharArray();
        int stratIdx = 0;
        int length = charArr.length;
        for (int endIdx = 0; endIdx <= length; endIdx++) {

            //word will end at space or at end of string
            if (endIdx == length || charArr[endIdx] == ' ') {
                reverse(charArr, stratIdx, endIdx - 1);

                //First character of the nex word
                stratIdx = endIdx + 1;

            }

        }
        return new String(charArr);
    }

    public static void reverse(char arr[], int stratIdx, int endIdx) {
        while (stratIdx < endIdx) {
            char temp = arr[stratIdx];
            arr[stratIdx] = arr[endIdx];
            arr[endIdx] = temp;
            stratIdx++;
            endIdx--;
        }
    }
}
