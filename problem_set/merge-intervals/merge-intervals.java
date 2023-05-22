
```
// @Title: 合并区间 (Merge Intervals)
// @Author: robert.sunq
// @Date: 2021-07-06 23:36:28
// @Runtime: 7 ms
// @Memory: 40.5 MB

class Solution {
    public int[][] merge(int[][] intervals) {
        // 排序
        // sort(intervals , 0 , intervals.length-1);
        // 采用工具类中的 lambda表达式
        Arrays.sort(intervals,(a,b)->{
            return a[0] - b[0];
        });
        List<List<Integer>> res = new ArrayList<>();
        Integer[] temp = new Integer[2];
        temp[0] = intervals[0][0];
        temp[1] = intervals[0][1];
        int len = intervals.length;
        int i = 1;
        while(i<len){
            // 表示不连续
            if(temp[1] < intervals[i][0]){
                // List<Integer> t = new ArrayList(Arrays.asList(temp));
                res.add(new ArrayList(Arrays.asList(temp)));
                temp[0] = intervals[i][0];
                temp[1] = intervals[i][1];
            }else{
                // 否则连续 合并
                
                temp[1] = Math.max(temp[1],intervals[i][1]);
            }
            i++;
        }
        // List<Integer> t = new ArrayList(Arrays.asList(temp));
        res.add(new ArrayList(Arrays.asList(temp)));
        // System.out.println(res);
        int[][] ress = new int[res.size()][2];
        int j =0;
        for(List<Integer> list:res){
            ress[j][0] = list.get(0);
            ress[j][1] = list.get(1);
            j++;
        }
        return ress;
    }

    // 排序
    void sort(int[][] intervals , int left, int right){
        int start = left,end = right;
        if(left >= right) return;
        // 哨兵
        int temp0 = intervals[left][0];
        int temp1 = intervals[left][1];
        while(left < right){
            // 由后往前 找第一个小于哨兵的
            while(left < right && intervals[right][0] >= temp0) right--;
            if(left<right){
                intervals[left][0] = intervals[right][0];
                intervals[left][1] = intervals[right][1];
                left++;
            }
            // 由前往后 找第一个大于哨兵的
            while(left < right && intervals[left][0] <= temp0) left++;
            if(left<right){
                intervals[right][0] = intervals[left][0];
                intervals[right][1] = intervals[left][1];
                right--;
            }
        }
        intervals[left][0] = temp0;
        intervals[left][1] = temp1;
        sort(intervals,start,left-1);
        sort(intervals,left+1,end);
    }
}
