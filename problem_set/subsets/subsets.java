
```
// @Title: 子集 (Subsets)
// @Author: robert.sunq
// @Date: 2021-06-05 23:15:46
// @Runtime: 1 ms
// @Memory: 38.3 MB

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int len = nums.length-1;
        List<List<Integer>> res = recur(nums,len);
        return res;
    }

    List<List<Integer>> recur(int[] nums , int end){
        // List<List<Integer>> res = new ArrayList<>();
        if(end < 0) {
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> temp = new ArrayList<>();
            res.add(temp);
            return res;
        }
        List<List<Integer>> res = recur(nums,end-1);
        int i = 0;
        int len = res.size();
        while(i<len){

            List<Integer> temp = new ArrayList<>(res.get(i));
            // ArrayList<Integer> temp1 = new ArrayList<>(temp);
            // 放入当前位置的字符
            temp.add(nums[end]);
            res.add(temp);
            i++;
        }
        return res;
    }
}
