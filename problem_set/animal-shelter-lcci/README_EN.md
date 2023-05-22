
| English | [简体中文](README.md) |

# [面试题 03.06. Animal Shelter LCCI](https://leetcode.cn//problems/animal-shelter-lcci/)

## Description

<p>An animal shelter, which holds only dogs and cats, operates on a strictly&quot;first in, first out&quot; basis. People must adopt either the&quot;oldest&quot; (based on arrival time) of all animals at the shelter, or they can select whether they would prefer a dog or a cat (and will receive the oldest animal of that type). They cannot select which specific animal they would like. Create the data structures to maintain this system and implement operations such as <code>enqueue</code>, <code>dequeueAny</code>, <code>dequeueDog</code>, and <code>dequeueCat</code>. You may use the built-in Linked list data structure.</p>

<p><code>enqueue</code> method has a <code>animal</code> parameter, <code>animal[0]</code> represents the number of the animal, <code>animal[1]</code> represents the type of the animal, 0 for cat and 1 for dog.</p>

<p><code>dequeue*</code> method returns <code>[animal number, animal type]</code>, if there&#39;s no animal that can be adopted, return <code>[-1, -1]</code>.</p>

<p><strong>Example1:</strong></p>

<pre>
<strong> Input</strong>: 
[&quot;AnimalShelf&quot;, &quot;enqueue&quot;, &quot;enqueue&quot;, &quot;dequeueCat&quot;, &quot;dequeueDog&quot;, &quot;dequeueAny&quot;]
[[], [[0, 0]], [[1, 0]], [], [], []]
<strong> Output</strong>: 
[null,null,null,[0,0],[-1,-1],[1,0]]
</pre>

<p><strong>Example2:</strong></p>

<pre>
<strong> Input</strong>: 
[&quot;AnimalShelf&quot;, &quot;enqueue&quot;, &quot;enqueue&quot;, &quot;enqueue&quot;, &quot;dequeueDog&quot;, &quot;dequeueCat&quot;, &quot;dequeueAny&quot;]
[[], [[0, 0]], [[1, 0]], [[2, 1]], [], [], []]
<strong> Output</strong>: 
[null,null,null,null,[2,1],[0,0],[1,0]]
</pre>

<p><strong>Note:</strong></p>

<ol>
	<li>The number of animals in the shelter will not exceed 20000.</li>
</ol>


## Solutions


### C++

```C++
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
```



## Related Topics

- [Design](https://leetcode.cn//tag/design)
- [Queue](https://leetcode.cn//tag/queue)

## Similar Questions


