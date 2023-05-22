
```
// @Title: 三合一 (Three in One LCCI)
// @Author: robert.sunq
// @Date: 2020-03-26 16:26:56
// @Runtime: 148 ms
// @Memory: 32.5 MB

class TripleInOne {
public:
    TripleInOne(int stackSize) {
        Size = stackSize;
        for(int i=0;i<3;i++){
            vector<int> an;
            st.push_back(an);
            tops[i] = -1;
        }
    }
    
    void push(int stackNum, int value) {
        if(tops[stackNum] >= Size-1) return;
        st[stackNum].push_back(value);
        tops[stackNum] ++;
    }
    
    int pop(int stackNum) {
        if(tops[stackNum] <0) return -1;
        
        int temp = st[stackNum][tops[stackNum]];
        st[stackNum].pop_back();
        tops[stackNum] --;
        return temp;
    }
    
    int peek(int stackNum) {
        if(tops[stackNum] < 0) return -1;
        return st[stackNum][tops[stackNum]];

    }
    
    bool isEmpty(int stackNum) {
        if(tops[stackNum] < 0) return true;
        return false;

    }

protected:
    vector<vector<int> > st;
    int Size=0;
    int tops[3] ;
};

/**
 * Your TripleInOne object will be instantiated and called as such:
 * TripleInOne* obj = new TripleInOne(stackSize);
 * obj->push(stackNum,value);
 * int param_2 = obj->pop(stackNum);
 * int param_3 = obj->peek(stackNum);
 * bool param_4 = obj->isEmpty(stackNum);
 */
