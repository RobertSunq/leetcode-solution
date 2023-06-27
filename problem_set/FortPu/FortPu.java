
```
// @Title: 插入、删除和随机访问都是 O(1) 的容器 (插入、删除和随机访问都是 O(1) 的容器)
// @Author: robert.sunq
// @Date: 2023-06-27 23:37:11
// @Runtime: 22 ms
// @Memory: 87.5 MB

class RandomizedSet {

    private List<Integer> list;
    private Map<Integer, Integer> map;
    private Random random;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
        random = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }

        list.add(val);
        map.put(val, list.size() - 1);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (map.containsKey(val)) {
            list.set(map.get(val), list.get(list.size() - 1));
            map.put(list.get(list.size() - 1), map.get(val));
            map.remove(val);
            list.remove(list.size() - 1);
            return true;
        }

        return false;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int randomIndex = random.nextInt(list.size());
        return list.get(randomIndex);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
