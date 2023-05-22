
```
// @Title: 根据身高重建队列 (Queue Reconstruction by Height)
// @Author: robert.sunq
// @Date: 2021-06-20 23:39:52
// @Runtime: 29 ms
// @Memory: 39.5 MB

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        // 当第一个选择相同时，根据第二个元素升序
        // 否则，以第一大数字为主进行降序
        Arrays.sort(people,(person1,person2)->{
            if (person1[0] == person2[0]){
                return person1[1]-person2[1];
            }else {
                return person2[0]-person1[0];
            }
        });

        // 遍历people 根据第二个元素的数值，表示其插入位置.
        // 在结果序列中，所有的元素均大于当前元素，故，所在位置前就由几个大于当前元素的数
        LinkedList<Integer[]> temp = new LinkedList<>();
        for(int i=0;i<people.length;i++){
            // System.out.println(people[i][0] + "   "+people[i][1]);
            Integer[] t = new Integer[]{people[i][0],people[i][1]};
            temp.add(t[1],t);
        }
        int[][] res = new int[people.length][2];
        for(int i=0;i<people.length;i++){
            res[i][0] = temp.get(i)[0];
            res[i][1] = temp.get(i)[1];
        }
        return res;

    }


}
