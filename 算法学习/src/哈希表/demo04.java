package 哈希表;

import java.util.HashMap;
import java.util.Map;

/**
 * @Title: demo04
 * @Author 笑霸fianl
 * @Package 哈希表
 * @Date 2023/5/1 15:03
 * @描述: 第454题.四数相加II   https://leetcode.cn/problems/4sum-ii/
 */
public class demo04 {
    public static void main(String[] args) {


    }

    /**
     * 给你四个整数数组 nums1、nums2、nums3 和 nums4 ，数组长度都是 n ，请你计算有多少个元组 (i, j, k, l) 能满足：
     *
     * 0 <= i, j, k, l < n
     * nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/4sum-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums1
     * @param nums2
     * @param nums3
     * @param nums4
     * @return
     *
     * ***************注意 可能出现多次
     */
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int count = 0 ;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int a:nums1) {
            for (int b:nums2){
                if (hashMap.containsKey(a+b)){
                    //存在则+1
                    hashMap.put(a+b,hashMap.get(a+b)+1);
                }else{
                    //这里的else 很重要
                    hashMap.put(a+b,1);
                }

            }
        }


        for (int c:nums3) {
            for (int d:nums4){
               if(hashMap.containsKey(0-c-d)){
                   count+=hashMap.get(0-c-d);
               }
            }
        }
        return count;
    }




}
