
```
// @Title: 堆盘子 (Stack of Plates LCCI)
// @Author: robert.sunq
// @Date: 2020-04-02 00:39:52
// @Runtime: 112 ms
// @Memory: 26.8 MB

class StackOfPlates {
public:
    StackOfPlates(int cap) {
        max_size = cap;

    }
    
    void push(int val) {
        int rows = st.size();
        if(max_size == 0) return ;
        if(rows == 0) {
            vector<int> temps;
            temps.push_back(val);
            st.push_back(temps);
        }
        else{
            int cols = st[rows-1].size();
            if(cols<max_size) st[rows-1].push_back(val);
            else{
                vector<int> temps;
                temps.push_back(val);
                st.push_back(temps);
            }
        }
    }
    
    int pop() {
        int rows = st.size();
        if(rows == 0) return -1;
        else{
            int cols = st[rows-1].size();
            int temp = st[rows-1][cols-1];
            if (cols-1 == 0) st.erase(st.begin()+rows-1);
            else{
                st[rows-1].pop_back();
            }
            return temp;
            
        }

    }
    
    int popAt(int index) {

        int rows = st.size();
        if(rows == 0) return -1;
        else{
            if(index > rows -1) return -1;
            else{
                int cols = st[index].size();
                int temp = st[index][cols-1];
                
                if(cols -1 == 0) st.erase(st.begin()+index);
                else{
                    st[index].pop_back();
                }

                rows = st.size();
                return temp;
            } 
        }

    }

protected:
    vector<vector<int> > st;
    int max_size = 0;
};

/**
 * Your StackOfPlates object will be instantiated and called as such:
 * StackOfPlates* obj = new StackOfPlates(cap);
 * obj->push(val);
 * int param_2 = obj->pop();
 * int param_3 = obj->popAt(index);
 */
