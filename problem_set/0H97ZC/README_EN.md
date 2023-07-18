
| English | [简体中文](README.md) |

# [剑指 Offer II 075. 数组相对排序](https://leetcode.cn//problems/0H97ZC/)

## Description

<p>English description is not available for the problem. Please switch to Chinese.</p>


## Solutions


### Java

```Java
// @Title: 数组相对排序 (数组相对排序)
// @Author: robert.sunq
// @Date: 2023-07-18 23:16:58
// @Runtime: 4 ms
// @Memory: 40.4 MB

class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<>();
        int n2 = arr2.length;
        for (int i = 0; i < n2; i++) {
            map.put(arr2[i], i);
        }
        List<Integer> list = new ArrayList<>();
        for (int n : arr1) {
            list.add(n);
        }
        list.sort((a , b) -> {
            // 注意， 如果值不再 arr2 中，需要保持其为升序
            // 同时还要排在 arr2 中存在元素的最后面，所以改成 n2 + a.
            return map.getOrDefault(a, n2 + a) - map.getOrDefault(b, n2 + b);
        });

        for (int i = 0 ; i < arr1.length; i++) {
            arr1[i] = list.get(i);
        }
        return arr1;
    }
}
```



## Related Topics

- [Array](https://leetcode.cn//tag/array)
- [Hash Table](https://leetcode.cn//tag/hash-table)
- [Counting Sort](https://leetcode.cn//tag/counting-sort)
- [Sorting](https://leetcode.cn//tag/sorting)

## Similar Questions


