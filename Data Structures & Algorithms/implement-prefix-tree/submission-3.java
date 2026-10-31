class PrefixTree {
    // Node definition inside the PrefixTree
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isWord;
    }

    private TrieNode root = new TrieNode();

    public PrefixTree() {
        // Constructor does nothing extra
    }

    // Insert a word into the Trie
    public void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';
            if (node.children[idx] == null)
                node.children[idx] = new TrieNode();
            node = node.children[idx];
        }
        node.isWord = true;
    }

    // Search for a complete word in the Trie
    public boolean search(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';
            if (node.children[idx] == null)
                return false;
            node = node.children[idx];
        }
        return node.isWord;
    }

    // Check if any word in Trie starts with the prefix
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char ch : prefix.toCharArray()) {
            int idx = ch - 'a';
            if (node.children[idx] == null)
                return false;
            node = node.children[idx];
        }
        return true;
    }
}
