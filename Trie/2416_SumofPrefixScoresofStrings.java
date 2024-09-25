//LeetCode URL - https://leetcode.com/problems/sum-of-prefix-scores-of-strings/description

class TrieNode{
    boolean isEnd;
    TrieNode[] children;
    int count;
    TrieNode(){
        isEnd = false;
        children = new TrieNode[26];
        count = 0;
    }
}

class Trie{
    TrieNode root;
    Trie(){
        root = new TrieNode();
    }

    public void insert(String word){
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++){
            if(curr.children[word.charAt(i) - 'a'] == null){
                curr.children[word.charAt(i) - 'a'] = new TrieNode();
            }
            curr.children[word.charAt(i) - 'a'].count += 1;
            curr = curr.children[word.charAt(i) - 'a'];
        }
        curr.isEnd = true;
    }

    public int getCount(String word){
        TrieNode curr = root;
        int res = 0;
        for(int i = 0; i < word.length(); i++){
            res += curr.children[word.charAt(i) - 'a'].count;
            curr = curr.children[word.charAt(i) - 'a'];
        }

        return res;
    }
}


class Solution {
    public int[] sumPrefixScores(String[] words) {
        int n = words.length;
        int[] res = new int[n];
        Trie tree = new Trie();

        for(int i = 0; i < n; i++){
            tree.insert(words[i]);
        }

        for(int i = 0; i < n; i++){
            res[i] = tree.getCount(words[i]);
        }

        return res;
    }
}
