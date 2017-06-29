package ayonel_146_LRUCache;

import java.util.LinkedHashMap;
import java.util.Map;
//解题思路：双向链表，加hashmap，为什么不用单向链表呢，因为我们需要一个链表的头尾，比如容量不够，需要删除时，
//需要移除链表尾部的节点；缓存命中时，我们需要把该节点移动到头部。所以我们需要的是一个可以操作头尾的链表，故选择
//双向链表。
public class LRUCache {
    private LinkedHashMap<Integer, Integer> map;
    private final int CAPACITY;
    public LRUCache(int capacity) {
        CAPACITY = capacity;
        map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true){
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > CAPACITY;
            }
        };
    }
    public int get(int key) {
        return map.getOrDefault(key, -1);
    }
    public void put(int key, int value) {
        map.put(key, value);
    }
}