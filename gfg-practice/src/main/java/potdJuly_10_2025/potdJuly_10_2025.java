package potdJuly_10_2025;

import java.util.ArrayList;

class TrieNode{
    boolean isEndofWord = false;
    TrieNode[] children = new TrieNode[26];

    TrieNode(){
        isEndofWord = false;
        for(int i =0; i<26;i++){
            children[i] = null;
        }
        //System.out.println("Size of TrieNode: " + children.length);
    }
}

class Trie{
    TrieNode root;

    Trie(){
        root = new TrieNode();
    }

    public void insert(String word){
        TrieNode crawler = root;
        for(int i=0;i<word.length();i++){
            int index = word.charAt(i)-'a';
            if(crawler.children[index] == null){
                crawler.children[index] =  new TrieNode();
            }
            crawler = crawler.children[index];
        }
        crawler.isEndofWord =true;
    }

    public boolean search(String word){
        TrieNode crawler = root;
        for(int i=0;i<word.length();i++){
            int index = word.charAt(i)-'a';
            crawler = crawler.children[index];
            if(crawler == null || crawler.isEndofWord == false){
                return false;
            }
        }

        return true;
    }

}

public class potdJuly_10_2025 {
    public static void main(String[] args) {
        String[] arr = new String[]{"p", "pr", "pro", "probl", "problem", "pros", "process", "processor"};
        System.out.println(longestPrefixString(arr));
    }

    private static String longestPrefixString(String[] arr){
        String result = "";

        Trie trie = new Trie();

        for(String word :arr){
            trie.insert(word);
        }

        for(String word : arr){
            if(trie.search(word)){
                if(word.length()>result.length() ||
                        (word.length() == result.length() &&
                                word.compareTo(result)<0 )){
                    result = word;
                }
            }
        }

        return result;
    }
}
