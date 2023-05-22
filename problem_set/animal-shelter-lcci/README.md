
| [English](README_EN.md) | 简体中文 |

# [面试题 03.06. 动物收容所](https://leetcode.cn//problems/animal-shelter-lcci/)

## 题目描述

<p>动物收容所。有家动物收容所只收容狗与猫，且严格遵守&ldquo;先进先出&rdquo;的原则。在收养该收容所的动物时，收养人只能收养所有动物中&ldquo;最老&rdquo;（由其进入收容所的时间长短而定）的动物，或者可以挑选猫或狗（同时必须收养此类动物中&ldquo;最老&rdquo;的）。换言之，收养人不能自由挑选想收养的对象。请创建适用于这个系统的数据结构，实现各种操作方法，比如<code>enqueue</code>、<code>dequeueAny</code>、<code>dequeueDog</code>和<code>dequeueCat</code>。允许使用Java内置的LinkedList数据结构。</p>

<p><code>enqueue</code>方法有一个<code>animal</code>参数，<code>animal[0]</code>代表动物编号，<code>animal[1]</code>代表动物种类，其中 0 代表猫，1 代表狗。</p>

<p><code>dequeue*</code>方法返回一个列表<code>[动物编号, 动物种类]</code>，若没有可以收养的动物，则返回<code>[-1,-1]</code>。</p>

<p><strong>示例1:</strong></p>

<pre><strong> 输入</strong>：
[&quot;AnimalShelf&quot;, &quot;enqueue&quot;, &quot;enqueue&quot;, &quot;dequeueCat&quot;, &quot;dequeueDog&quot;, &quot;dequeueAny&quot;]
[[], [[0, 0]], [[1, 0]], [], [], []]
<strong> 输出</strong>：
[null,null,null,[0,0],[-1,-1],[1,0]]
</pre>

<p><strong>示例2:</strong></p>

<pre><strong> 输入</strong>：
[&quot;AnimalShelf&quot;, &quot;enqueue&quot;, &quot;enqueue&quot;, &quot;enqueue&quot;, &quot;dequeueDog&quot;, &quot;dequeueCat&quot;, &quot;dequeueAny&quot;]
[[], [[0, 0]], [[1, 0]], [[2, 1]], [], [], []]
<strong> 输出</strong>：
[null,null,null,null,[2,1],[0,0],[1,0]]
</pre>

<p><strong>说明:</strong></p>

<ol>
	<li>收纳所的最大容量为20000</li>
</ol>


## 题解


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



## 相关话题

- [设计](https://leetcode.cn//tag/design)
- [队列](https://leetcode.cn//tag/queue)

## 相似题目



