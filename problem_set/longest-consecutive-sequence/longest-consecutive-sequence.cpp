
```
// @Title: 最长连续序列 (Longest Consecutive Sequence)
// @Author: robert.sunq
// @Date: 2020-05-13 14:27:54
// @Runtime: 116 ms
// @Memory: 11.9 MB

class Solution {
private: map<int,int> u,counts;

int finds(int x){
    return (x == u[x]) ? x:finds(u[x]);
}

int meges(int x,int y){
    x = finds(x);
    y = finds(y);
    if (x == y) return counts[x];
    u[x] = y;
    counts[x] += counts[y];
    counts[y] = counts[x];
    return counts[x];
}
public:
    int longestConsecutive(vector<int>& nums) {
      if(nums.size() == 0) return 0;
      for(int i=0;i<nums.size();i++){
          u[nums[i]] = nums[i];
          counts[nums[i]] = 1;
      }
      int count = 1;
      for(int i=0;i<nums.size();i++){
          if( u.find(nums[i]+1 ) != u.end()) 
            count = max(count,meges(nums[i],nums[i]+1));
      }
      return count;

    }
};
