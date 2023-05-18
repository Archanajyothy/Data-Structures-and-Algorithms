public class HashTable {
    private static final int SIZE = 53;
    private String[] keys;
    private String[] values;

    public HashTable() {
        keys = new String[SIZE];
        values = new String[SIZE];
    }

    // Hash function 1
    private int hash1(String key) {
        int hash = 0;
        for (int i = 0; i < key.length(); i++) {
            hash = (hash * 31 + key.charAt(i)) % SIZE;
        }
        return hash;
    }

    // Hash function 2
    private int hash2(String key) {
        int hash = 0;
        for (int i = 0; i < key.length(); i++) {
            hash = (hash * 37 + key.charAt(i)) % SIZE;
        }
        return hash;
    }

    // Insert key-value pair into hash table
    public void put(String key, String value) {
        int index = hash1(key);
        int step = hash2(key);
        int i = 1;

        // Double hashing to find next available slot
        while (keys[index] != null && !keys[index].equals(key)) {
            index = (index + i * step) % SIZE;
            i++;
        }

        keys[index] = key;
        values[index] = value;
    }

    // Retrieve value based on key
    public String get(String key) {
        int index = hash1(key);
        int step = hash2(key);
        int i = 1;

        // Double hashing to find key's index
        while (keys[index] != null && !keys[index].equals(key)) {
            index = (index + i * step) % SIZE;
            i++;
        }

        if (keys[index] == null) {
            return null; // Key not found
        } else {
            return values[index]; // Return corresponding value
        }
    }

    // Test the hash table
    public static void main(String[] args) {
        HashTable hashTable = new HashTable();

        // Insert key-value pairs
        hashTable.put("apple", "red");
        hashTable.put("banana", "yellow");
        hashTable.put("cherry", "red");
        hashTable.put("grape", "purple");

        // Retrieve values based on keys
        System.out.println("apple: " + hashTable.get("apple"));
        System.out.println("banana: " + hashTable.get("banana"));
        System.out.println("cherry: " + hashTable.get("cherry"));
        System.out.println("grape: " + hashTable.get("grape"));
        System.out.println("orange: " + hashTable.get("orange")); // Key not found
    }
}

