
| English | [简体中文](README.md) |

# [146. LRU Cache](https://leetcode.cn//problems/lru-cache/)

## Description

<p>Design a data structure that follows the constraints of a <strong><a href="https://en.wikipedia.org/wiki/Cache_replacement_policies#LRU" target="_blank">Least Recently Used (LRU) cache</a></strong>.</p>

<p>Implement the <code>LRUCache</code> class:</p>

<ul>
	<li><code>LRUCache(int capacity)</code> Initialize the LRU cache with <strong>positive</strong> size <code>capacity</code>.</li>
	<li><code>int get(int key)</code> Return the value of the <code>key</code> if the key exists, otherwise return <code>-1</code>.</li>
	<li><code>void put(int key, int value)</code> Update the value of the <code>key</code> if the <code>key</code> exists. Otherwise, add the <code>key-value</code> pair to the cache. If the number of keys exceeds the <code>capacity</code> from this operation, <strong>evict</strong> the least recently used key.</li>
</ul>

<p>The functions <code>get</code> and <code>put</code> must each run in <code>O(1)</code> average time complexity.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input</strong>
[&quot;LRUCache&quot;, &quot;put&quot;, &quot;put&quot;, &quot;get&quot;, &quot;put&quot;, &quot;get&quot;, &quot;put&quot;, &quot;get&quot;, &quot;get&quot;, &quot;get&quot;]
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
<strong>Output</strong>
[null, null, null, 1, null, -1, null, -1, 3, 4]

<strong>Explanation</strong>
LRUCache lRUCache = new LRUCache(2);
lRUCache.put(1, 1); // cache is {1=1}
lRUCache.put(2, 2); // cache is {1=1, 2=2}
lRUCache.get(1);    // return 1
lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
lRUCache.get(2);    // returns -1 (not found)
lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
lRUCache.get(1);    // return -1 (not found)
lRUCache.get(3);    // return 3
lRUCache.get(4);    // return 4
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= capacity &lt;= 3000</code></li>
	<li><code>0 &lt;= key &lt;= 10<sup>4</sup></code></li>
	<li><code>0 &lt;= value &lt;= 10<sup>5</sup></code></li>
	<li>At most <code>2 * 10<sup>5</sup></code> calls will be made to <code>get</code> and <code>put</code>.</li>
</ul>


## Solutions


### Java

```Java
// @Title: LRU 缓存 (LRU Cache)
// @Author: robert.sunq
// @Date: 2021-06-10 23:03:09
// @Runtime: 72 ms
// @Memory: 107 MB

class LRUCache {

    // 双向链表节点
     class LinkNode {
        int key;
        int value;
        LinkNode prev;
        LinkNode next;
        public LinkNode() {}
        public LinkNode(int _key, int _value) {key = _key; value = _value;}
    }
    
    // 缓存key与节点信息
    Map<Integer,LinkNode> mp = new HashMap<>();
    // 当前容量
    int curCapacity;
    // 总容量
    int size;
    // 双向链表头尾指针
    private LinkNode head, tail;
    public LRUCache(int capacity) {
        size = capacity;
        curCapacity = 0;
        head = new LinkNode();
        tail = new LinkNode();
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        LinkNode p = mp.getOrDefault(key,null);
        if(p == null) return -1;
        // 访问，将该节点放入到最前面
        remove(p);
        addPrev(p);
        return p.value;

    }
    
    public void put(int key, int value) {
        // 如果当前点不存在
        LinkNode p = mp.getOrDefault(key,null); 
        if(p == null){
            // 满了，需要删除最后的节点
            if(size == curCapacity){
                curCapacity--;
                mp.remove(tail.prev.key);
                remove(tail.prev);
            }
            // 更新 key value
            p = new LinkNode(key,value);
            mp.put(key,p);
            curCapacity++;
        }else{
            // 更新value 并将节点放到最前方
            p.value = value;
            remove(p);
        }
        // 往前前插节点
        addPrev(p);          
    }
    // 删除节点
    public void remove(LinkNode p){
        p.prev.next = p.next;
        p.next.prev = p.prev;
    }
    // 在头部添加节点，表示最近访问
    public void addPrev(LinkNode p){
        p.next = head.next;
        head.next.prev = p;
        p.prev = head;
        head.next = p;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
```



## Related Topics

- [Design](https://leetcode.cn//tag/design)
- [Hash Table](https://leetcode.cn//tag/hash-table)
- [Linked List](https://leetcode.cn//tag/linked-list)
- [Doubly-Linked List](https://leetcode.cn//tag/doubly-linked-list)

## Similar Questions

- [LFU Cache](../lfu-cache/README_EN.md)
- [Design In-Memory File System](../design-in-memory-file-system/README_EN.md)
- [Design Compressed String Iterator](../design-compressed-string-iterator/README_EN.md)
