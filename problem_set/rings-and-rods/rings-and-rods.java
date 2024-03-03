
```
// @Title: 环和杆 (Rings and Rods)
// @Author: robert.sunq
// @Date: 2023-11-02 20:56:21
// @Runtime: 0 ms
// @Memory: 39.2 MB

class Solution {
    public int countPoints(String rings) {
        HashMap<Character, Integer> map = new HashMap<>();

        map.put('R', 1);
        map.put('G', 2);
        map.put('B', 4);

        int[] ring = new int[10];

        for (int i = 0; i < rings.length(); i+=2) {
            char c = rings.charAt(i);
            int index = rings.charAt(i + 1) - '0';
            ring[index] = ring[index] | map.get(c);
        }

        int ans = 0;
        for (int i : ring) {
            if (i == 7) {
                ans++;
            }
        }

        return ans;
    }
}
