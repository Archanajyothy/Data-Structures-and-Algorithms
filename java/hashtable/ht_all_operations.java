public class HashTable {
    private static final int SIZE = 53;
    private String[][] keyMap;

    public HashTable() {
        keyMap = new String[SIZE][];
    }

    private int hash(String key) {
        int total = 0;
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            int value = (int) c;
            total = (total * 51 + value) % SIZE;
        }
        return total;
    }

    public void set(String key, String value) {
        int index = hash(key);
        if (keyMap[index] == null) {
            keyMap[index] = new String[] {key, value};
        } else {
            // Handle collisions using linear probing
            int newIndex = (index + 1) % SIZE;
            while (keyMap[newIndex] != null && !keyMap[newIndex][0].equals(key)) {
                newIndex = (newIndex + 1) % SIZE;
            }
            keyMap[newIndex] = new String[] {key, value};
        }
    }

    public String[] get(String key) {
        int index = hash(key);
        if (keyMap[index] != null && keyMap[index][0].equals(key)) {
            return keyMap[index];
        } else {
            // Handle collisions during retrieval
            int newIndex = (index + 1) % SIZE;
            while (keyMap[newIndex] != null && !keyMap[newIndex][0].equals(key)) {
                newIndex = (newIndex + 1) % SIZE;
            }
            return keyMap[newIndex];
        }
    }

    public void delete(String key) {
        int index = hash(key);
        if (keyMap[index] != null && keyMap[index][0].equals(key)) {
            keyMap[index] = null; // Delete the key-value pair
        } else {
            // Handle collisions during deletion
            int newIndex = (index + 1) % SIZE;
            while (keyMap[newIndex] != null && !keyMap[newIndex][0].equals(key)) {
                newIndex = (newIndex + 1) % SIZE;
            }
            keyMap[newIndex] = null; // Delete the key-value pair
        }
    }

    public void update(String key, String value) {
        int index = hash(key);
        if (keyMap[index] != null && keyMap[index][0].equals(key)) {
            keyMap[index][1] = value; // Update the value for the given key
        } else {
            // Handle collisions during update
            int newIndex = (index + 1) % SIZE;
            while (keyMap[newIndex] != null && !keyMap[newIndex][0].equals(key)) {
                newIndex = (newIndex + 1) % SIZE;
            }
            keyMap[newIndex][1] = value; // Update the value for the given key
        }
    }

    public int size() {
        int count = 0;
        for (int i = 0; i < SIZE; i++) {
            if (keyMap[i] != null) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        HashTable ht = new HashTable();

        // Insert key-value pairs
        ht.set("student", "Archana");
        ht.set("hi", "HI");
        ht.set("hello", "THIS IS HELLO");

        // Retrieve values
        String[] pair1 = ht.get("student");
        String[] pair2 = ht.get("hi");
        String[] pair3 = ht.get("hello");

        System.out.println("Value for key 'student': " + pair1[1]);
        System.out.println("Value for key 'hi': " + pair2[1]);
        System.out.println("Value for key 'hello': " + pair3[1]);

        // Update values
        ht.update("student", "John");
        ht.update("hi", "Hello");
        ht.update("hello", "World");

        // Retrieve updated values
        pair1 = ht.get("student");
        pair2 = ht.get("hi");
        pair3 = ht.get("hello");

        System.out.println("Updated value for key 'student': " + pair1[1]);
        System.out.println("Updated value for key 'hi': " + pair2[1]);
        System.out.println("Updated value for key 'hello': " + pair3[1]);

        // Delete a key-value pair
        ht.delete("hi");

        // Try to retrieve deleted key-value pair
        pair2 = ht.get("hi");
        if (pair2 == null) {
            System.out.println("Key 'hi' not found.");
        }

        // Print the size of the hash table
        System.out.println("Size of the hash table: " + ht.size());
    }
}


