//Leetcode URL - https://leetcode.com/problems/word-search-ii/description/


class TrieNode{
    TrieNode[] children;
    String word;
    boolean isEnd;

    TrieNode(){
        children = new TrieNode[26];
        word = null;
        isEnd = false;
    }
}


class Trie{
    TrieNode root;
    Trie(){
        root = new TrieNode();
    }

    public void insert(String word){
        TrieNode curr = root;
        for(char w : word.toCharArray()){
            if(curr.children[w - 'a'] == null){
                curr.children[w - 'a'] = new TrieNode();
            }
            curr = curr.children[w - 'a'];
        }
        curr.isEnd = true;
        curr.word = word;
    }
}


//Build a trie tree using the given words list.
//and at each cell check if trie root has children based on the character on the board and traverse 4 directions
//add a new string value 'word' for every node and default is null! and for end of the word it doesn't be null

//if it is not null, then found a word and add it to the set - for avoiding duplicates in result
//or list and clear the word in the trie(not recommened)


class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new LinkedList<>();

        Trie trie = new Trie();
        for(int i = 0; i < words.length; i++){
            trie.insert(words[i]);
        }
        TrieNode root = trie.root;

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                search(board, root, i, j, res);
            }
        }

        return res;
    }

    void search(char[][] board, TrieNode currNode, int i, int j, List<String> res){
        if(i < 0 || j < 0 || i >= board.length || j >= board[i].length){
            return;
        }        

        char curr = board[i][j];

        if(curr == '#'){
            return;
        }

        if(currNode.children[curr - 'a'] == null){
            return;
        }

        if(currNode.children[curr - 'a'].word != null){
            res.add(currNode.children[curr - 'a'].word);
            currNode.children[curr - 'a'].word = null;
        }

        currNode = currNode.children[curr - 'a'];

        //can change the original values of board and 
        //store it in temporary variable and change it back after all recursive calls are done.
        char temp = board[i][j];
        board[i][j] = '#';

        //recursive calls!
        search(board, currNode, i + 1, j, res);
        search(board, currNode, i, j + 1, res);
        search(board, currNode, i, j - 1, res);
        search(board, currNode, i - 1, j, res);

        //After exploring all directions, restore the current cell's original value to allow other paths to use it. 
        //Continue this process until all cells and paths are exhausted.
        //backtracking!!

        // Restore the original character in the cell
        board[i][j] = temp;
    }

}
