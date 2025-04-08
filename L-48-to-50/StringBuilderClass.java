
public class StringBuilderClass {

    public static void main(String[] args) {

        StringBuilder name1 = new StringBuilder("Kumawat");
        StringBuilder name2 = new StringBuilder("Kumawat");
        StringBuilder name3 = new StringBuilder("Subhash");
        StringBuilder name4 = name1;

        System.out.println(name1.equals(name2));
        System.out.println(name2.equals(name3));
        System.out.println(name3.equals(name4));
        System.err.println(name4.equals(name1));
        System.err.println("");
        System.out.println(name1 == name2);
        System.out.println(name2 == name3);
        System.out.println(name3 == name4);
        System.err.println(name4 == name1);

        name4.append("Subhash");
        System.out.println(name1);

    }
}
