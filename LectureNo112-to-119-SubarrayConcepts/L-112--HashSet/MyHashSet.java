
import java.util.HashSet;
import java.util.Iterator;

public class MyHashSet {

    public static void main(String[] args) {

        HashSet<Integer> set = new HashSet<>();
        set.add(5);
        set.add(3);
        set.add(9);
        set.add(8);
        System.out.println(set);
        System.out.println(set.contains(9));
        System.out.println(set.remove(3));
        System.out.println(set);

        // for (Integer i : set) {
        //     System.out.println(i);
        //     set.remove(i);

        // }

        Iterator<Integer> itr = set.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
            itr.remove();
        }

    }
}
