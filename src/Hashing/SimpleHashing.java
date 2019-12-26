package Hashing;

import java.util.*;

class Pair {
    public int key;
    public String value;

    public Pair(int rollNo, String colleague) {
        key = rollNo;
        value = colleague;
    }
}

public class SimpleHashing {
    private static ArrayList<Pair>[] hashTable = new ArrayList[2069];
    private static final int size = 5;

    public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(System.in);
        int numInputs = in.nextInt();


        initializeLists();

        while (numInputs > 0) {
            int rollNo = in.nextInt();
            String colleague = in.next();

            Pair pair = new Pair(rollNo, colleague);
            insert(pair);

            numInputs--;
        }



        int numQueries = in.nextInt();
        while (numQueries > 0) {
            int rollNo = in.nextInt();
            String colleague = search(rollNo);

            System.out.println(colleague);

            numQueries--;
        }
    }

    private static void initializeLists() {
        for (int i = 0; i < size; i++)
            hashTable[i] = new ArrayList<Pair>();
    }

    public static void insert(Pair pair) {
        int index = hashFunction(pair.key);
        hashTable[index].add(pair);
    }

    public static String search(int key) {
        int index = hashFunction(key);
        ArrayList<Pair> list = hashTable[index];

        String result = "";

        if (list.size() == 0)
            return result = "Roll number " + key + " not added to the database.";

        return list.get(0).value;
    }

    private static int hashFunction(int key) {
        return key % size;
    }
}