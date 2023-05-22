
```
// @Title: 栈排序 (Sort of Stacks LCCI)
// @Author: robert.sunq
// @Date: 2020-04-08 19:46:53
// @Runtime: 156 ms
// @Memory: 11.8 MB

class SortedStack {
public:
    SortedStack() {
        top_an = -1;
        top_temp = -1;

    }
    
    void push(int val) {
        if(top_an ==-1) {
            an.push_back(val);
            top_an++;

        }
        else if(top_an >= 5000 ) return ;
        else{
            
            while(top_an >-1 && an[top_an] < val){
                temp.push_back(an[top_an]);
                top_temp++;
                top_an--;
                an.pop_back();
            }
            an.push_back(val);
            top_an++;
            while(top_temp > -1){
                an.push_back(temp[top_temp]);
                top_temp--;
                top_an++;
                temp.pop_back();
            }

        }

    }
    
    void pop() {
        if(top_an == -1) return;
        else{
            top_an--;
            an.pop_back();
        }

    }
    
    int peek() {
        if(top_an == -1) return -1;
        else return an[top_an];

    }
    
    bool isEmpty() {
        if(top_an == -1) return true;
        else return false;

    }

protected: 
   vector<int> an;
   vector<int> temp;
   int top_an = -1;
   int top_temp = -1;
};

/**
 * Your SortedStack object will be instantiated and called as such:
 * SortedStack* obj = new SortedStack();
 * obj->push(val);
 * obj->pop();
 * int param_3 = obj->peek();
 * bool param_4 = obj->isEmpty();
 */
