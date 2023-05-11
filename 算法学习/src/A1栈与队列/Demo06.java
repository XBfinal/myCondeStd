package A1栈与队列;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
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
}
