package HashMap;

class Node <K, V>{
    K key;
    V value;
    Node<K, V> hashNext;

    Node(K key, V value) {
        this.key = key;
        this.value = value;
    }
}

public class HashMap <K, V>{
    Node<K, V>[] table;
    private final int tableSize;

    @SuppressWarnings("unchecked")
    HashMap(int tableSize) {
        this.tableSize = tableSize;
        table = new Node[tableSize];
    }

    HashMap() {this(10);}

    public void put(K key, V value) {
        Node<K, V> newNode = new Node<K, V>(key, value);
        int hash = key.hashCode() % this.tableSize;

        if (table[hash] == null) {
            table[hash] = newNode;
            return;
        }

        Node<K, V> entry = table[hash];

        while (entry.hashNext != null && entry.key!=key) {
            entry = entry.hashNext;
        }

        if (entry.key == key) {
            entry.value = value;
            return;
        }

        entry.hashNext = newNode;
    }

    public void removeKey(K key) {
        int hash = key.hashCode() % this.tableSize;

        if (table[hash] == null) return;

        if (table[hash].key == key) {
            table[hash] = table[hash].hashNext;
            return;
        }

        Node<K, V> entry = table[hash];
        Node<K, V> temp = entry.hashNext;

        while (temp.hashNext != null && temp.key != key) {
            entry = temp;
            temp = temp.hashNext;
        }

        if (temp.key == key) entry.hashNext = temp.hashNext;
    }

    public void printByKey(K key) {
        int hash = key.hashCode() % this.tableSize;

        Node<K, V> entry = table[hash];
        System.out.print("Key: " + key);

        if (entry == null) {
            System.out.println();
            return;
        }

        while (entry.hashNext != null && entry.key != key) {
            entry = entry.hashNext;
        }

        if (entry.key == key) System.out.print(" Value: " + entry.value);
        System.out.println();
    }

    public void printAllByKey(K key) {
        int hash = key.hashCode() % this.tableSize;
        Node<K, V> entry = table[hash];
        System.out.print("Key: " + key + " Value:");

        if (entry == null) {
            System.out.println();
            return;
        }

        System.out.print(" " + entry.value);
        while (entry.hashNext != null) {
            entry = entry.hashNext;
            System.out.print(" " + entry.value);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>(10);

        for (int i = 0; i < 26; i++) {
            char alpha = (char) (65 + i);
            hashMap.put(alpha ,i);
        }

        for (int i = 0; i < 26; i++) {
            char alpha = (char) (65 + i);
            hashMap.printAllByKey(alpha);
        }

        hashMap.printByKey('Z');
        hashMap.printByKey('J');
        hashMap.printByKey('K');
        hashMap.printByKey('I');
        hashMap.printByKey('U');

        hashMap.removeKey('Z');
        hashMap.removeKey('J');
        hashMap.removeKey('K');
        hashMap.removeKey('I');
        hashMap.removeKey('U');

        hashMap.printByKey('Z');
        hashMap.printByKey('J');
        hashMap.printByKey('K');
        hashMap.printByKey('I');
        hashMap.printByKey('U');

        for (int i = 0; i < 10; i++) {
            char alpha = (char) (65 + i);
            hashMap.printAllByKey(alpha);
        }
    }
}
