
| [English](README_EN.md) | 简体中文 |

# [146. LRU 缓存](https://leetcode.cn//problems/lru-cache/)

## 题目描述

<div class="title__3Vvk">请你设计并实现一个满足&nbsp; <a href="https://baike.baidu.com/item/LRU" target="_blank">LRU (最近最少使用) 缓存</a> 约束的数据结构。</div>

<div class="title__3Vvk">实现 <code>LRUCache</code> 类：</div>

<div class="original__bRMd">
<div>
<ul>
	<li><code>LRUCache(int capacity)</code> 以 <strong>正整数</strong> 作为容量&nbsp;<code>capacity</code> 初始化 LRU 缓存</li>
	<li><code>int get(int key)</code> 如果关键字 <code>key</code> 存在于缓存中，则返回关键字的值，否则返回 <code>-1</code> 。</li>
	<li><code>void put(int key, int value)</code>&nbsp;如果关键字&nbsp;<code>key</code> 已经存在，则变更其数据值&nbsp;<code>value</code> ；如果不存在，则向缓存中插入该组&nbsp;<code>key-value</code> 。如果插入操作导致关键字数量超过&nbsp;<code>capacity</code> ，则应该 <strong>逐出</strong> 最久未使用的关键字。</li>
</ul>

<p>函数 <code>get</code> 和 <code>put</code> 必须以 <code>O(1)</code> 的平均时间复杂度运行。</p>
</div>
</div>

<p>&nbsp;</p>

<p><strong>示例：</strong></p>

<pre>
<strong>输入</strong>
["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
<strong>输出</strong>
[null, null, null, 1, null, -1, null, -1, 3, 4]

<strong>解释</strong>
LRUCache lRUCache = new LRUCache(2);
lRUCache.put(1, 1); // 缓存是 {1=1}
lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
lRUCache.get(1);    // 返回 1
lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
lRUCache.get(2);    // 返回 -1 (未找到)
lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
lRUCache.get(1);    // 返回 -1 (未找到)
lRUCache.get(3);    // 返回 3
lRUCache.get(4);    // 返回 4
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= capacity &lt;= 3000</code></li>
	<li><code>0 &lt;= key &lt;= 10000</code></li>
	<li><code>0 &lt;= value &lt;= 10<sup>5</sup></code></li>
	<li>最多调用 <code>2 * 10<sup>5</sup></code> 次 <code>get</code> 和 <code>put</code></li>
</ul>


## 题解


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



## 相关话题

- [设计](https://leetcode.cn//tag/design)
- [哈希表](https://leetcode.cn//tag/hash-table)
- [链表](https://leetcode.cn//tag/linked-list)
- [双向链表](https://leetcode.cn//tag/doubly-linked-list)

## 相似题目


- [LFU 缓存](../lfu-cache/README.md)
- [设计内存文件系统](../design-in-memory-file-system/README.md)
- [迭代压缩字符串](../design-compressed-string-iterator/README.md)
