
import java.util.LinkedList;
import java.util.Objects;

public class myHashMap<K, V> {

    public static void main(String[] args) {

    }

    class Node {

        K key;
        V value;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return key + " : " + value;
        }

    }

    private LinkedList<Node> hashTable[];
    private int elements;
    private int tableSize;
    private double threshold;

    private void initializationTable() {
        for (int i = 0; i < tableSize; i++) {
            hashTable[i] = new LinkedList<>();
        }
    }

    public myHashMap() {
        elements = 0;
        tableSize = 16;
        threshold = 0.75;
        hashTable = new LinkedList[tableSize];
        initializationTable();
    }

    private int getHashCode(K key) {
        int hashCode = Objects.hash(key);
        hashCode = (Math.abs(hashCode)) % tableSize;
        return hashCode;
    }

    private int searchKeyInList(K key, int hashCode) {
        LinkedList<Node> list = hashTable[hashCode];
        for (int index = 0; index < list.size(); index++) {
            if (list.get(index).key.equals(key)) {
                return index;
            }
        }
        return -1;
    }

    private void reashing() {
        LinkedList<Node> oldTable[] = hashTable;
        tableSize = 2 * tableSize;
        elements = 0;
        hashTable = new LinkedList[tableSize];
        initializationTable();
        for (LinkedList<Node> list : oldTable) {
            for (Node node : list) {
                put(node.key, node.value);
            }
        }
    }

    public void put(K key, V value) {
        //Find the hashCode
        int hashCode = getHashCode(key);
        int index = searchKeyInList(key, hashCode);
        Node node = new Node(key, value);

        if (index == -1) {
            //insert
            hashTable[hashCode].add(0, node);
            elements++;
        } else {
            //update
            hashTable[hashCode].get(index).value = value;
        }
        if (elements / (double) tableSize >= threshold) {
            reashing();
        }
    }

    public V get(K key) {
        //find the hashcode
        int hashCode = getHashCode(key);
        int index = searchKeyInList(key, hashCode);
        if (index == -1) {
            //not presented
            return null;
        } else {
            //presented in hashtable
            return hashTable[hashCode].get(index).value;
        }
    }

    public boolean containsKey(K key) {
        int hashCode = getHashCode(key);
        int index = searchKeyInList(key, hashCode);

        if (index == -1) {
            return false;
        } else {
            return true;
        }
    }

    public boolean containsValue(V value) {
        for (int i = 0; i < tableSize; i++) {
            for (Node node : hashTable[i]) {
                if (node.value.equals(value)) {
                    return true;
                }

            }
        }
        return false;
    }

    public V remove(K key) {
        //find the hashcode and index
        int hashCode = getHashCode(key);
        int index = searchKeyInList(key, hashCode);

        if (index == -1) {
            return null;
        } else {
            V value = hashTable[hashCode].get(index).value;
            hashTable[hashCode].remove(index);
            elements--;
            return value;
        }
    }

    public boolean isEmpty() {
        return (elements == 0);
    }

    public void iterate() {
        for (int i = 0; i < tableSize; i++) {
            for (Node node : hashTable[i]) {
                System.out.println(node);
            }
        }
    }

    public int size() {
        return elements;
    }

}
