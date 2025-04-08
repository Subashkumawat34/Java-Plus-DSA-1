
//it can be deleted using java garbage collector
public class StringEquality {

    public static void main(String[] args) {
        // String name1 = "Subhash";
        // String name2 = "Subhash";
        // String name3 = "Kumawat";
        // String name4 = name1;

        // System.out.println(name1 == name2);
        // System.out.println(name2 == name3);
        // System.out.println(name3 == name4);
        // System.err.println(name4 == name1);
        //using new operator 
        // String name1 = new String("Subhash");
        // String name2 = new String("Subhash");
        // String name3 = new String("Kumawat");
        // String name4 = name1;
        // System.out.println(name1 == name2);
        // System.out.println(name2 == name3);
        // System.out.println(name3 == name4);
        // System.err.println(name4 == name1);
        //Check equality of string using .equals() function it will compare the string of data
        // String name1 = new String("Subhash");
        // String name2 = new String("Subhash");
        // String name3 = new String("Kumawat");
        // String name4 = name1;
        // System.out.println(name1.equals(name2));
        // System.out.println(name2.equals(name3));
        // System.out.println(name3.equals(name4));
        // System.err.println(name4.equals(name1));
        // Scanner Sc = new Scanner(System.in);
        // // System.out.println("enter a Line");
        // // String line = sc.nextLine();
        // System.out.println("enter a word");
        // String word = Sc.next();
        // System.out.println("enter a Line");
        // String line = Sc.nextLine();
        // System.out.println("word is " + word);
        // System.out.println("Lise is " + line);
        String email1 = "subhashkumawat34@gmail.com";
        String email2 = "subhashkumawat34@hotcode.com";
        String parts[] = email1.split("@");
        String domain = parts[1];
        int dotIndex = domain.lastIndexOf('.');
        System.out.println(domain.substring(0, dotIndex));

    }

}
