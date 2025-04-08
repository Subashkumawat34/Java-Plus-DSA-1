
public class ArrayEquality {

    public static void main(String[] args) {
        int name1[] = new int[3];
        int name2[] = new int[3];
        int name3[] = name1;

        System.out.println(name1 == name2);
        System.out.println(name2 == name3);
        System.out.println(name3 == name1);
    }
}
