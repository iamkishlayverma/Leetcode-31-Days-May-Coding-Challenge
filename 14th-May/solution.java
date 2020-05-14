class Trie {
    
    class TrieNode {
        TrieNode[] child = new TrieNode[26];
        boolean isEnd = false;
    }
    
    TrieNode root;
    
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();        
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode curr = root;
        int len = word.length();
        for (int i=0; i<len; i++) {
            int index = word.charAt(i) - 'a';
            if (curr.child[index] == null) {
                curr.child[index] = new TrieNode();
            }
            curr = curr.child[index];
        }
        curr.isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode curr = root;
        int len = word.length();
        for (int i=0; i<len; i++) {
            int index = word.charAt(i) - 'a';
            if (curr.child[index] == null) {
                return false;
            }
            curr = curr.child[index];
        }
        return curr.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        int preLen = prefix.length();
        if (preLen == 0 || prefix == null)
            return true;
        TrieNode curr = root;
        for (int i=0; i<preLen; i++) {
            int index = prefix.charAt(i) - 'a';
            if (curr.child[index] == null) {
                return false;
            }
            curr = curr.child[index];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
