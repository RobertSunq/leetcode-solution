
```
// @Title: Range 模块 (Range Module)
// @Author: robert.sunq
// @Date: 2023-11-12 20:39:01
// @Runtime: 53 ms
// @Memory: 48.1 MB

    class RangeModule {

        private TreeMap<Integer, Integer> intervals;

        public RangeModule() {
            intervals = new TreeMap<>();
        }

        // 主要是，融合区间
        public void addRange(int left, int right) {
            Map.Entry<Integer, Integer> entry = intervals.higherEntry(left);
            
            if (entry != intervals.firstEntry()) {
                Map.Entry<Integer, Integer> start = entry != null ? intervals.lowerEntry(entry.getKey()) : intervals.lastEntry();
                // 存在一个[i, j)  i 是最接近小于 left 的区间， 且 j 大于 right，  即  [i, j) 包含 [left, right)
                if (start != null && start.getValue() >= right) {
                    return;
                }
                // 存在一个[i, j)  i 是最接近小于 left 的区间， 且 j 大于 left，  即 [i, j) 在 [left, right) 的左侧且 j 在区间内，此时可以合并区间
                if (start != null && start.getValue() >= left) {
                    left = start.getKey();
                    intervals.remove(start.getKey());
                }
            }
            
            // 将所有被 [left, right) 包围的 [i, j) 的区间删除
            while (entry != null && entry.getKey() <= right) {
                right = Math.max(right, entry.getValue());
                intervals.remove(entry.getKey());
                entry = intervals.higherEntry(entry.getKey());
            }
            
            // 添加新的区间
            intervals.put(left, right);
        }

        public boolean queryRange(int left, int right) {
            Map.Entry<Integer, Integer> entry = intervals.higherEntry(left);
            
            if (entry == intervals.firstEntry()) {
                return false;
            }
            
            entry = entry != null ? intervals.lowerEntry(entry.getKey()) : intervals.lastEntry();
            return entry != null && right <= entry.getValue();
        }

        public void removeRange(int left, int right) {
            Map.Entry<Integer, Integer> entry = intervals.higherEntry(left);
            
            if (entry != intervals.firstEntry()) {
                Map.Entry<Integer, Integer> start = entry != null ? intervals.lowerEntry(entry.getKey()) : intervals.lastEntry();
                // 存在一个[i, j)  i 是最接近小于 left 的区间， 且 j 大于 right，  即  [i, j) 包含 [left, right)
                if (start != null && start.getValue() >= right) {
                    int ri = start.getValue();
                    // 如果左边界相同，直接删除原本的区间， 然后在判断右区间是否相同， 来判断是否将剩余的区间写入
                    if (start.getKey() == left) {
                        intervals.remove(start.getKey());
                    } else {
                        // 保留左侧剩余的
                        intervals.put(start.getKey(), left);
                    }
                    // 保留右侧剩余的
                    if (right != ri) {
                        intervals.put(right, ri);
                    }
                // 存在一个[i, j)  i 是最接近小于 left 的区间， 且 j 大于 left，  即 [i, j) 在 [left, right) 的左侧且 j 在区间内，此时可以合并区间
                } else if (start != null && start.getValue() > left) {
                    // 且注意，这里和添加的时候不一样，因为右区间是开区间， 所以要使用  > 
                    if (start.getKey() == left) {
                        intervals.remove(start.getKey());
                    } else {
                        intervals.put(start.getKey(), left);
                    }
                }
                
                while (entry != null && entry.getKey() < right) {
                    if (entry.getValue() <= right) {
                        intervals.remove(entry.getKey());
                        entry = intervals.higherEntry(entry.getKey());
                    } else {
                        intervals.put(right, entry.getValue());
                        intervals.remove(entry.getKey());
                        break;
                    }
                }
            } 
        }
    }

/**
 * Your RangeModule object will be instantiated and called as such:
 * RangeModule obj = new RangeModule();
 * obj.addRange(left,right);
 * boolean param_2 = obj.queryRange(left,right);
 * obj.removeRange(left,right);
 */
