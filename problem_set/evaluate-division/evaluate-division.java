
```
// @Title: 除法求值 (Evaluate Division)
// @Author: robert.sunq
// @Date: 2021-06-28 00:09:56
// @Runtime: 1 ms
// @Memory: 37.3 MB

class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int count=0;
        //统计出现的所有字符，并赋予对应的index
        Map<String,Integer> map=new HashMap<>();
        // 即节点信息
        for (List<String> list:equations){
            for (String s:list){
                if(!map.containsKey(s)){
                    // 此处的 count 即为字符在矩阵中的位置
                    map.put(s,count++);
                }
            }
        }
        
        //构建一个矩阵来代替图结构
        // graph[row][col] 表示 字符 row/col的值
        double[][] graph=new double[count+1][count+1];
        
        //初始化
        for (String s:map.keySet()){
            int x=map.get(s);
            graph[x][x]=1.0;
        }
        int index=0;
        // 将一直结果放入矩阵
        for (List<String> list:equations){
            // 获取字符
            String a=list.get(0);
            String b=list.get(1);
            // 获取字符对应的坐标
            int aa=map.get(a);
            int bb=map.get(b);
            // 将其放入矩阵中
            double value=values[index++];
            graph[aa][bb]=value;
            graph[bb][aa]=1/value;
        }
        
        //通过Floyd算法进行运算
        int n=count+1;
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                // 将所有可以计算的结果进行计算
                // 即  计算任意两个节点之间的值
                for (int k=0;k<n;k++){
                    if(j==k||graph[j][k]!=0) continue;
                    if(graph[j][i]!=0&&graph[i][k]!=0){
                        // j/k = j/i * i/k
                        graph[j][k]=graph[j][i]*graph[i][k];
                    }
                }
            }
        }
        
        //直接通过查询矩阵得到答案
        double[] res=new double[queries.size()];
        for (int i=0;i<res.length;i++){
            List<String> q=queries.get(i);
            // 获得需要计算的两个字符
            String a=q.get(0);
            String b=q.get(1);
            // 判断知否在节点中，并计算
            if(map.containsKey(a)&&map.containsKey(b)){
                double ans=graph[map.get(a)][map.get(b)];
                res[i]=(ans==0?-1.0:ans);
            }else {
                res[i]=-1.0;
            }
        }
        return res;
    }
}
