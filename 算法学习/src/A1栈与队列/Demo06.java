package A1栈与队列;

import java.util.*;
import java.util.stream.Stream;

/**
 * @Title: Demo06
 * @Author 笑霸fianl
 * @Package A1栈与队列
 * @Date 2023/5/11 15:11
 * @描述: 347.前 K 个高频元素 https://leetcode.cn/problems/top-k-frequent-elements/
 */
public class Demo06 {
    public static void main(String[] args) {
        int[] nums =new  int[]{1,1,1,2,2,3};
        for (int i : topKFrequent(nums, 2)) {
            System.out.println(i);
        }
    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for ( int i:nums) {
            Integer integer = map.get(i);
            if(integer==null){
                map.put(i,1);
            }else{
                map.put(i,integer+1);
            }

        }

        ArrayList<Integer> objects = new ArrayList<>();
        int[] nums1 =new  int[k];
        map.entrySet().stream()
                .sorted( Collections.reverseOrder(Map.Entry.comparingByValue())).forEach((a)->{
                    objects.add(a.getKey());
                });
        for (int i = 0; i < k; i++) {
            nums1[i]=objects.get(i);
        }

        return nums1;
    }

    public int[] topKFrequent1(int[] nums, int k) {

        Map<Integer,Integer> map = new HashMap<>();//key为数组元素值,val为对应出现次数
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        //在优先队列中存储二元组(num,cnt),cnt表示元素值num在数组中的出现次数
        //出现次数按从队头到队尾的顺序是从大到小排,出现次数最多的在队头(相当于大顶堆)
        PriorityQueue<int[]> pq = new PriorityQueue<>((pair1, pair2)->pair2[1]-pair1[1]);
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){//大顶堆需要对所有元素进行排序
            pq.add(new int[]{entry.getKey(),entry.getValue()});
        }
        int[] ans = new int[k];
        for(int i=0;i<k;i++){//依次从队头弹出k个,就是出现频率前k高的元素
            ans[i] = pq.poll()[0];
        }
        return ans;
    }
    //解法2：基于小顶堆实现
    public int[] topKFrequent2(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();//key为数组元素值,val为对应出现次数
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        //在优先队列中存储二元组(num,cnt),cnt表示元素值num在数组中的出现次数
        //出现次数按从队头到队尾的顺序是从小到大排,出现次数最低的在队头(相当于小顶堆)
        PriorityQueue<int[]> pq = new PriorityQueue<>((pair1,pair2)->pair1[1]-pair2[1]);
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){//小顶堆只需要维持k个元素有序
            if(pq.size()<k){//小顶堆元素个数小于k个时直接加
                pq.add(new int[]{entry.getKey(),entry.getValue()});
            }else{
                if(entry.getValue()>pq.peek()[1]){//当前元素出现次数大于小顶堆的根结点(这k个元素中出现次数最少的那个)
                    pq.poll();//弹出队头(小顶堆的根结点),即把堆里出现次数最少的那个删除,留下的就是出现次数多的了
                    pq.add(new int[]{entry.getKey(),entry.getValue()});
                }
            }
        }
        int[] ans = new int[k];
        for(int i=k-1;i>=0;i--){//依次弹出小顶堆,先弹出的是堆的根,出现次数少,后面弹出的出现次数多
            ans[i] = pq.poll()[0];
        }
        return ans;
    }


}
