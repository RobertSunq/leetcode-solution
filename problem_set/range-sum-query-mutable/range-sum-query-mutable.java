
```
// @Title: 区域和检索 - 数组可修改 (Range Sum Query - Mutable)
// @Author: robert.sunq
// @Date: 2023-11-13 22:30:17
// @Runtime: 123 ms
// @Memory: 71.8 MB

class NumArray {

    // sum[i] 表示第 i 个块的元素和
    private int[]  sum; 

    // 块的大小
    private int size;

    private int[] nums;

    public NumArray(int[] nums) {
        this.nums = nums;
        int n = nums.length;
        size = (int) Math.sqrt(n);
        // 分组数量向上取整
        sum = new int[(n + size - 1) / size];
        for (int i = 0; i < n; i++) {
            sum[i / size] = sum[i / size] + nums[i];
        }
    }
    
    public void update(int index, int val) {
        sum[index / size] = sum[index / size] + (val - nums[index]);
        nums[index] = val;

    }
    
    public int sumRange(int left, int right) {
        int leftInSum = left / size;
        int leftIndexInSum = left % size;
        int rightInSum = right / size;
        int rightIndexInSum = right % size;
        
        // 区间 [left, right] 在同一个块中
        if (leftInSum == rightInSum) {
            int ans = 0;
            for (int j = leftIndexInSum; j <= rightIndexInSum; j++) {
                ans += nums[leftInSum * size + j];
            }
            return ans;
        }

        int ans = 0;
        for (int j = leftIndexInSum; j < size; j++) {
            ans += nums[leftInSum * size + j];
        }

        for (int j = 0; j <= rightIndexInSum; j++) {
            ans += nums[rightInSum * size + j];
        }

        for (int j = leftInSum + 1; j < rightInSum; j++) {
            ans += sum[j];
        }

        return ans;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
