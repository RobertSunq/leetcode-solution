
```
// @Title: 栈的最小值 (Min Stack LCCI)
// @Author: robert.sunq
// @Date: 2020-03-26 16:49:10
// @Runtime: 48 ms
// @Memory: 14.9 MB

class MinStack {
public:
    /** initialize your data structure here. */
    MinStack() {
        top_st = -1;
        top_minst = -1;
    }
    
    void push(int x) {
        if(top_minst == -1 || minst[top_minst] >= x){
            minst.push_back(x);
            top_minst++;
        } 
        st.push_back(x);
        top_st++;
        return ;
    }
    
    void pop() {
        if(top_st < 0) return;
        if(st[top_st] == minst[top_minst]) {
            minst.pop_back();
            top_minst--;
        }
        st.pop_back();
        top_st--;
        return ;

    }
    
    int top() {
        if(top_st <0) return -1;
        return st[top_st];

    }
    
    int getMin() {
        if(top_minst <0) return 0;
        return minst[top_minst];

    }
protected:
    vector<int> st,minst;
    int top_st = -1,top_minst = -1;
};

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack* obj = new MinStack();
 * obj->push(x);
 * obj->pop();
 * int param_3 = obj->top();
 * int param_4 = obj->getMin();
 */
