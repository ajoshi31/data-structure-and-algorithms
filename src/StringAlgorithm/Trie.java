package StringAlgorithm;

import java.util.HashMap;
import java.util.Map;

public class Trie {

    private void insertInTrie(String str, TrieNode root) {

        TrieNode current = root;
        int length = str.length();

        for (int i = 0; i < length; i++) {

            char ch = str.charAt(i);
            TrieNode node = current.children.get(ch);
            if (node == null) {
                node = new TrieNode();
                current.children.put(ch, node);
            }
            current = node;
        }

        current.isEndOfWord = true;

    }

    private boolean search(String str, TrieNode root) {

        TrieNode current = root;
        int length = str.length();

        for (int i = 0; i < length; i++) {

            char ch = str.charAt(i);
            TrieNode node = current.children.get(ch);
            if (node == null) {
                return false;
            }
            current = node;
        }

        return current.isEndOfWord; // if that is end of word it will return true if it is not then false
    }


    private boolean delete(String str, TrieNode current, int index) {
        if (index == str.length()) { // as it start with zero it will reach end

            if (!current.isEndOfWord) {
                return false;
            }
            current.isEndOfWord = false;
            return current.children.size() == 0;
        }
        char ch = str.charAt(index);
        TrieNode node = current.children.get(ch);
        if (node == null) {
            return false;
        }
        boolean shouldDeleteCurrentNode = delete(str, node, index + 1);
        if (shouldDeleteCurrentNode) {
            current.children.remove(ch);
            return current.children.size() == 0;
        }
        return false;
    }

    public static void main(String args[]) {

        String keys[] = {"the", "there"};

        Trie tries = new Trie();

        TrieNode trieNode = new TrieNode();

        for (String key : keys) {
            tries.insertInTrie(key, trieNode);

        }

        System.out.println(tries.search("the", trieNode));
        System.out.println(tries.search("trie", trieNode));
    }


}

