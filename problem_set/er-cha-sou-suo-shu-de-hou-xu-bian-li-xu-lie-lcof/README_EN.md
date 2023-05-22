
| English | [简体中文](README.md) |

# [剑指 Offer 33. 二叉搜索树的后序遍历序列 LCOF](https://leetcode.cn//problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/)

## Description

English description is not available for the problem. Please switch to Chinese.

## Solutions


### Java

```Java
// @Title: 二叉搜索树的后序遍历序列 (二叉搜索树的后序遍历序列 LCOF)
// @Author: robert.sunq
// @Date: 2021-05-27 22:56:15
// @Runtime: 0 ms
// @Memory: 36.1 MB

class Solution {
    public boolean verifyPostorder(int[] postorder) {
        if(postorder.length == 0) return true;
        return recur(postorder,0,postorder.length-1);
    }

    boolean recur(int[] postorder , int star , int end){
        if (star >= end) return true;
        int leftLast = 0;
        int i = star;
        while(i<=end && postorder[i] < postorder[end]){
            i++;
        }
        leftLast = i;
        while(i<=end && postorder[i] > postorder[end]){
            i++;
        }
        return i == end && recur(postorder,star,leftLast-1) && recur(postorder ,leftLast,end-1);
    }
}
```



## Related Topics

- [Stack](https://leetcode.cn//tag/stack)
- [Tree](https://leetcode.cn//tag/tree)
- [Binary Search Tree](https://leetcode.cn//tag/binary-search-tree)
- [Recursion](https://leetcode.cn//tag/recursion)
- [Binary Tree](https://leetcode.cn//tag/binary-tree)
- [Monotonic Stack](https://leetcode.cn//tag/monotonic-stack)

## Similar Questions


