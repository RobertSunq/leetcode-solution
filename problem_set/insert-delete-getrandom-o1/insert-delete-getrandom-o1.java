
```
// @Title: O(1) 时间插入、删除和获取随机元素 (Insert Delete GetRandom O(1))
// @Author: robert.sunq
// @Date: 2023-10-17 23:46:35
// @Runtime: 31 ms
// @Memory: 86.6 MB

class RandomizedSet {

    private List<Integer> nums;
    private Map<Integer, Integer> indexes;
    private Random random;

    public RandomizedSet() {
        nums = new ArrayList<>();
        indexes = new HashMap<>();
        random = new Random();
    }
    
    public boolean insert(int val) {
        if (indexes.containsKey(val)) {
            return false;
        }
        int n = nums.size();
        nums.add(val);
        indexes.put(val, n);
        return true;
    }
    
    public boolean remove(int val) {
        if (!indexes.containsKey(val)) {
            return false;
        }

        int index = indexes.get(val);
        int n = nums.size();
        // 这里，可变数组，将最后一个数替换为需要删除的位置，然后删除最后一个元素\
        int lastVal = nums.get(n - 1);
        nums.set(index, lastVal);
        indexes.put(lastVal, index);
        nums.remove(n - 1);
        indexes.remove(val);
        return true;
    }
    
    public int getRandom() {
        int randomIndex = random.nextInt(nums.size());
        return nums.get(randomIndex);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
