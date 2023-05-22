
```
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
