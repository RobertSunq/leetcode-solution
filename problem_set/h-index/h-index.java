
```
// @Title: H 指数 (H-Index)
// @Author: robert.sunq
// @Date: 2023-10-14 21:02:08
// @Runtime: 1 ms
// @Memory: 39 MB

class Solution {
    public int hIndex(int[] citations) {
        int left = 0;
        // 注意这里是 数组的长度, 因为下面是 left < right, 所以要从 n 开始，而不是 n - 1 开始
        int right = citations.length;
        int count = 0;
        while (left < right) {
            // 因为要找到最大的一个符合结果的数据，所以要找到最后，
            // 为了避免到最后 mid 一直等于 left 且 < right, 所以这里向上取整
            int mid = (left + right + 1) / 2; // mid 就是
            count = 0;

            for (int i = 0; i < citations.length; i++) {
                if (citations[i] >= mid) {
                    count++;
                }
            } 

            if (count >= mid) {
                // 大于 mid 的引用数量，大于mid个数, 已经符合要求什  要继续提高mid找更大的
                // 在 mid right 中找
                left = mid;
            } else {
                // 这时候  大于 mid 的文章少，所以降低mid的大小，找
                right = mid -  1;

            }
        }


        return left;
    }


    // public int hIndex(int[] citations) {
    //     Arrays.sort(citations);

    //     int h = 0;
    //     int i = citations.length - 1;
    //     while (i >= 0 && citations[i] > h) {
    //         h++;
    //         i--;
    //     }
    //     return h;
    // }
}
