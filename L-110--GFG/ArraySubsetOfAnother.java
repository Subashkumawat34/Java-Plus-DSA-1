
public class ArraySubsetOfAnother {

    public static boolean isSubset(int a[], int b[]) {
        boolean visited[] = new boolean[a.length];
        for (int i = 0; i < b.length; i++) {
            boolean found = false;

            for (int j = 0; j < a.length; j++) {
                if (b[i] == a[j] && !visited[j]) {
                    visited[j] = true;
                    found = true;
                    break;
                }
            }
            if (!found) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        int a[] = {1, 2, 7, 1, 6, 4, 3};
        int b[] = {1, 2, 1, 4, 3};
        boolean ans = isSubset(a, b);

        System.out.println(ans);

    }
}
