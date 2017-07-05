package ayonel_211_AddandSearchWordDatastructuredesign;

/**
 * @author ayonel
 * @create 2017-07-05 10:59
 * @blog https://ayonel.me
 **/
public class WordDictionary {
    Trie trie;
    /** Initialize your data structure here. */
    public WordDictionary() {
        trie = new Trie();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        trie.insert(word);
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return trie.search(word, trie.root);
    }
}

class TrieNode {
    public char val;
    public boolean isWord;
    public TrieNode[] children = new TrieNode[26];
    public TrieNode() {}
    TrieNode(char c){
        TrieNode node = new TrieNode();
        node.val = c;
    }
}

class Trie {
    public TrieNode root;
    public Trie() {
        root = new TrieNode();
        root.val = ' ';
    }

    public void insert(String word) {
        TrieNode ws = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(ws.children[c - 'a'] == null){
                ws.children[c - 'a'] = new TrieNode(c);
            }
            ws = ws.children[c - 'a'];
        }
        ws.isWord = true;
    }

    public boolean search(String word, TrieNode parent) {

        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if (c != '.') {
                if(parent.children[c - 'a'] == null) return false;
                parent = parent.children[c - 'a'];
            } else {
                boolean res = false;
                for(int j = 0; j < 26; j++) {
                    if (parent.children[j] != null)
                        res |= search(word.substring(i+1),parent.children[j]);
                }
                return res;
            }
        }
        return parent.isWord;
    }

    public static void main(String[] args) {
        WordDictionary wd =  new WordDictionary();
        wd.addWord("bad");
        wd.addWord("dad");
        wd.addWord("mad");
        System.out.println(wd.search("pad"));
        System.out.println(wd.search("bad"));
        System.out.println(wd.search(".ad"));
        System.out.println(wd.search("d.t"));
    }

}
