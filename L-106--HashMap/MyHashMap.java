
import java.util.HashMap;
import java.util.Objects;

class MyCollege {

    private int hashCode;

    int regNo;

    MyCollege(int regNo) {
        this.regNo = regNo;
        this.hashCode = Objects.hashCode(regNo);
    }

    @Override
    public int hashCode() {
        return hashCode;
    }

    @Override
    public boolean equals(Object obj) {
        MyCollege college = (MyCollege) obj;
        return this.regNo == regNo;
    }

}

class MyRanking {

    int rank;

    MyRanking(int rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "" + this.rank;
    }

    @Override
    public boolean equals(Object obj) {
        MyRanking r = (MyRanking) obj;
        return this.rank == (r.rank);
    }
}

public class MyHashMap {

    public static void main(String[] args) {
        // HashMap<Integer, String> myMap = new HashMap<>();
        // myMap.put(10, "Subhash");
        // myMap.put(9, "Suhanii");
        // myMap.put(2, "Sanjana");
        // myMap.put(11, "Kavisha");
        // System.out.println(myMap);
        // myMap.put(9, "kajal");
        // System.out.println(myMap);
        // System.out.println(myMap.get(9));
        // System.out.println(myMap.containsKey(9));
        // System.out.println(myMap.getOrDefault(34, "The user does not exist"));
        // myMap.replace(9, "Suhanii");
        // System.out.println(myMap);

        // for (Map.Entry<Integer, String> entry : myMap.entrySet()) {
        //     System.out.println("Key-->" + entry.getKey());
        //     System.out.println("value-->" + entry.getValue());
        // }
        // for (Integer key : myMap.keySet()) {
        //     System.err.println("key-->" + key);
        //     System.out.println("value-->" + myMap.get(key));
        // }
        HashMap<MyCollege, MyRanking> collegeMap = new HashMap<>();
        collegeMap.put(new MyCollege(10), new MyRanking(0));
        collegeMap.put(new MyCollege(11), new MyRanking(2));
        collegeMap.put(new MyCollege(13), new MyRanking(3));
        System.out.println(collegeMap.get(new MyCollege(10)));
        System.out.println(collegeMap.containsValue(new MyRanking(3)));
        System.out.println(collegeMap);

    }
}
