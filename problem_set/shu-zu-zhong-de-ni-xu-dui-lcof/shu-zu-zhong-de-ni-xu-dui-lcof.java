
```
// @Title: 数组中的逆序对 (数组中的逆序对  LCOF)
// @Author: robert.sunq
// @Date: 2021-06-07 22:10:48
// @Runtime: 152 ms
// @Memory: 45.9 MB

class Solution {
    int max;
    public int reversePairs(int[] nums) {
        max = nums.length-1;
        int res = recur(nums,0,nums.length-1);
        return res;
    }

    int recur(int[] nums,int start,int end){
        if(start >= end) return 0;
        int temp = (start + end)/2;
        // 查找左边的逆序对
        int left = recur(nums,start,temp);
        // 查找右边的逆序对
        int right = recur(nums,temp+1,end);
        int res = left+right;
        // 归并排序的同时并计数 做降序排序
        int i = start,j = temp+1;
        List<Integer> list = new ArrayList<>();
        boolean flag = true;
        while(i <= temp && j <= end){
            // 相等 随意移动一个指针
            if(nums[i] == nums[j]){
                list.add(nums[j]);
                j++;
            }else if(nums[i] < nums[j]){
                list.add(nums[j]);
                j++;
            }else{
                list.add(nums[i]);
                res = res + (end - j +1);
                i++;
            }
        }
        // 右边小的由结余
        while(j<=end){
            list.add(nums[j]);
            j++;
        }
        // 左边小的有结余
        while(i <= temp){
            list.add(nums[i]);
            i++;
        }
        // 放入原数组中
        for (int t=0;t<list.size();t++){
            nums[start+t] = list.get(t); 
        }
        if(start == 0 && end == max){
            System.out.println(list);
        }
        return res;

    }
}
