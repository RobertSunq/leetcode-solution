
```
// @Title: 动物收容所 (Animal Shelter LCCI)
// @Author: robert.sunq
// @Date: 2020-04-08 21:36:04
// @Runtime: 596 ms
// @Memory: 110.6 MB

class AnimalShelf {
public:
    AnimalShelf() {
        Head = new Node();
        last = Head;
        sum = 0;
    }
    
    void enqueue(vector<int> animal) {
        if(sum > 20000) return;
        else{
            Node *p = new Node(animal[0],animal[1]);
            last = Head;
            while(last->next != NULL) last = last->next;
            last->next = p;
            sum++;
        }
    }
    
    vector<int> dequeueAny() {
        vector<int> temp;
        temp.push_back(-1);
        temp.push_back(-1);
        if(Head->next == NULL) return temp;
        else{
            sum--;
            Node *p = Head->next;
            temp[0] = p->a;
            temp[1] = p->b;
            Head->next = p->next;
           // free(p);
            return temp;
        }
    }
    
    vector<int> dequeueDog() {
        vector<int> temp;
        temp.push_back(-1);
        temp.push_back(-1);
        if(Head->next == NULL) return temp;
        else{
            Node *p = Head->next;
            Node *pre = Head;
            while(p!= NULL){
                if(p->b == 1){
                    pre->next = p->next;
                    temp[0] = p->a;
                    temp[1] = p->b;
              //      free(p);
                    sum--;
                    return temp;
                }
                else{
                    pre = p;
                    p = p->next;
                }
            }
            return temp;
        }


    }
    
    vector<int> dequeueCat() {
        vector<int> temp;
        temp.push_back(-1);
        temp.push_back(-1);
        if(Head->next == NULL) return temp;
        else{
            Node *p = Head->next;
            Node *pre = Head;
            while(p!= NULL){
                if(p->b == 0){
                    pre->next = p->next;
                    temp[0] = p->a;
                    temp[1] = p->b;
                    // free(p);
                    sum--;
                    return temp;
                }
                else{
                    pre = p;
                    p = p->next;
                }
            }
            return temp;
        }


    }
    protected: 
    struct Node{
        int a;
        int b;
        Node *next;
        Node():next(NULL){};
        Node(int _a,int _b) :a(_a),b(_b),next(NULL){};
      //  ~Node();
    };
    Node *Head = new Node();
    Node *last;
    int sum = 0;
};

/**
 * Your AnimalShelf object will be instantiated and called as such:
 * AnimalShelf* obj = new AnimalShelf();
 * obj->enqueue(animal);
 * vector<int> param_2 = obj->dequeueAny();
 * vector<int> param_3 = obj->dequeueDog();
 * vector<int> param_4 = obj->dequeueCat();
 */
