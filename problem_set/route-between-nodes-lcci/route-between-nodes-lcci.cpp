
```
// @Title: 节点间通路 (Route Between Nodes LCCI )
// @Author: robert.sunq
// @Date: 2020-04-09 16:48:16
// @Runtime: 644 ms
// @Memory: 91.4 MB

class Solution {

protected:
    vector<int> virsted;    
    vector<vector<int> > list;
    
    void DFS(int val , int target ){
        if (virsted[val]  || virsted[target]) return;
        else{
            virsted[val] = 1;
            for(int i=1;i<list[val].size();i++){
                if(virsted[list[val][i]] == 0){
                    DFS(list[val][i],target);
                }
            }
        }
    }
public:
    bool findWhetherExistsPath(int n, vector<vector<int>>& graph, int start, int target) {
        
        
        for(int i=0;i<n;i++) {
            vector<int> temp;
            temp.push_back(i);
            list.push_back(temp);
            virsted.push_back(0);
        }
        for(int i=0;i<graph.size();i++){
            list[graph[i][0]].push_back(graph[i][1]);
           // list[graph[i][1]].push_back(graph[i][0]);
        }

       // for(int i=0;i<list.size();i++){
            //for(int j=0;j<list[i].size();j++)
           // cout << list[i][j] << ' ';
           // cout << endl;
       // }
        DFS(start,target);
        if(virsted[target]) return true;
        else return false;
    
    }      

    
};
