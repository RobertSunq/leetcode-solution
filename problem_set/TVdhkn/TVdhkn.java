
```
// @Title: 所有子集 (所有子集)
// @Author: robert.sunq
// @Date: 2023-07-20 23:02:56
// @Runtime: 0 ms
// @Memory: 40.5 MB

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        return subsets(nums, 0);
    }


    public List<List<Integer>> subsets(int[] nums, int index) {
        if (index >= nums.length) {
            List<Integer> tmp = new ArrayList<>();
            List<List<Integer>> ans = new ArrayList<>();
            ans.add(tmp);
            return ans;
        }

        List<List<Integer>> ans = subsets(nums, index + 1);
        int n = ans.size();
        for (int i = 0 ; i < n; i++) {
            List<Integer> tmp = new ArrayList<>(ans.get(i));
            tmp.add(nums[index]);
            ans.add(tmp);
        }

        return ans;
    }
}
