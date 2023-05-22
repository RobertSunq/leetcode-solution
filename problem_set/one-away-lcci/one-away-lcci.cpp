
```
// @Title: 一次编辑 (One Away LCCI)
// @Author: robert.sunq
// @Date: 2020-03-23 23:39:43
// @Runtime: 0 ms
// @Memory: 7.4 MB

class Solution {
public:
    bool oneEditAway(string first, string second) { 
        int len_f = first.length();
        int len_s = second.length();
        if(abs(len_f-len_s) >1) return false;
        int counts = 0;
        if(len_s == len_f){
            for(int i=0;i<len_f;i++){
                if(first[i] != second[i]) counts++;
                if(counts >1) return false;

            }
            return true;
        }
        
        if(len_f >len_s){
            int i=0,j=0;
            counts = 0;
             while(i<len_f && j<len_s){
               if(first[i] != second[j]){
                  counts++;
                  if(counts >1) return false;
                  if(first[i+1] == second[j])
                     i++;
                  else return false; 
            }
            i++;
            j++;
          }  
          return true; 
        }
        else {
             int i=0,j=0;
            counts = 0;
             while(j<len_f && i<len_s){
               if(first[j] != second[i]){
                  counts++;
                  if(counts >1) return false;
                  if(first[j] == second[i+1])
                     i++;
                  else return false; 
            }
             i++;
             j++;
          }
          return true;   
        }
       

    }
};
