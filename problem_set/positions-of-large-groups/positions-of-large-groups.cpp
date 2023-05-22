
```
// @Title: 较大分组的位置 (Positions of Large Groups)
// @Author: robert.sunq
// @Date: 2020-03-20 17:33:08
// @Runtime: 12 ms
// @Memory: 9.2 MB

class Solution {
public:
    vector<vector<int>> largeGroupPositions(string S) {
        vector<vector<int> > an;
        if(S.size() == 0) return an;
        int len = S.size();
        int i=0;
        int j=0;
        while(i<len-2){
            vector <int> indexs;
            int counts =0;
            for(j=i;j<len;j++){
                if(S[i] == S[j]){
                    counts++;
                }
                else break;

            }
            if(counts >= 3){
                indexs.push_back(i);
                indexs.push_back(j-1);
                an.push_back(indexs);
                indexs.clear();
                i = j;
            }
            else i++;
        }

        return an;

    }
};
