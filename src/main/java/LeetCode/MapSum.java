package LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author:menglihuan
 * @data:2018/12/5
 * @ds:
 */
public class MapSum {
    HashMap<String, Integer> map;
    TrieNode trieNode;

    public MapSum() {
        map = new HashMap();
        trieNode = new TrieNode();
    }

    public void insert(String key, int val) {
        int change = val - map.getOrDefault(key, 0);
        map.put(key, val);
        TrieNode cur = trieNode;
        cur.score += change;
        for (char c : key.toCharArray()
                ) {
            cur.children.putIfAbsent(c, new LeetCode.MapSum.TrieNode());
            cur = cur.children.get(c);
            cur.score += change;
        }
    }

    public int sum(String prefix) {
        TrieNode cur = trieNode;
        for (char c : prefix.toCharArray()) {
            cur = cur.children.get(c);
            if(cur==null) return 0;
        }
        return cur.score;
    }

    class TrieNode {
        Map<Character, TrieNode> children = new HashMap();
        int score;
    }
}
