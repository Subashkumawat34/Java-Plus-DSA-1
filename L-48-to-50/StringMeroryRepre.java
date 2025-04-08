
// String constant pool
public class StringMeroryRepre {

    public static void main(String[] args) {
        String name1 = "subhash";
        System.out.println(name1);
        String name2 = name1;
        System.out.println(name2);
        name2 = "Shiny";
        System.err.println(name1);
        String name3 = "kumawat";
        System.err.println(name3);
        name2 = name3;
        System.err.println(name2);
    }
}
