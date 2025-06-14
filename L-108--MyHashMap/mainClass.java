
public class mainClass {

    public static void main(String[] args) {
        myHashMap<Integer, String> myMap = new myHashMap<>();
        myMap.put(1, "Subhash");
        myMap.put(2, "Tazyeen");
        myMap.put(3, "Kaviii");
        myMap.put(4, "Saurav");
        myMap.put(5, "Gaurav");
        myMap.put(6, "Shruti");
        System.out.println(myMap.get(2));
        myMap.put(2, "Suhani");
        System.out.println(myMap.get(2));
        System.out.println(myMap.containsKey(3));
        System.out.println(myMap.containsKey(5));
        System.out.println(myMap.isEmpty());
        myMap.iterate();
        System.out.println(myMap.containsValue("Suhani"));
        System.out.println(myMap.containsValue("Sanjana"));

        System.out.println(myMap.remove(6));
        System.out.println(myMap.remove(11));

        System.out.println(myMap.size());

    }
}
