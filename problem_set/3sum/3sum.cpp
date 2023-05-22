
```
// @Title: 三数之和 (3Sum)
// @Author: robert.sunq
// @Date: 2020-05-13 18:15:02
// @Runtime: 92 ms
// @Memory: 20.5 MB

class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {

        vector<vector<int> > res;
        int n = nums.size();
        if(n<3) return res;
        sort(nums.begin(),nums.end());
        int str = 0,sto = 0,i=0;
        while(i<n-2){
            if(nums[i] >0 ) break;
            // if(nums[i+1] == nums[i]) continue;
            str = i+1;
            sto = n-1;
            while(str<sto){
                    int temp = nums[i]+nums[sto]+nums[str];
                    if(temp==0){
                        vector<int> b(3,0) ;
                        b[0]= nums[i];
                        b[1] = nums[str];
                        b[2] = nums[sto];
                        res.push_back(b);
                        while(str<sto && nums[str+1] == nums[str])
                            str++;
                        while(str<sto && nums[sto-1] == nums[sto])
                            sto--;
                        str++;
                        sto--;
                    }
                    else if(temp >0) sto--;
                    else str++;
                    
                }
            i++;
            while(i<n-2 && nums[i] == nums[i-1]) i++;
            
            
        }
        return res;

    }
};
