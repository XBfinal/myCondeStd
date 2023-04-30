package 哈希表;

import java.util.HashSet;

/**
 * @Title: demo02
 * @Author 笑霸fianl
 * @Package 哈希表
 * @Date 2023/4/30 16:27
 * @描述: 349. 两个数组的交集  https://leetcode.cn/problems/intersection-of-two-arrays/
 * 给定两个数组 nums1 和 nums2 ，返回 它们的交集 。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序
 */
public class demo02 {


    public static void main(String[] args) {

    }
    public static int[] intersection(int[] nums1, int[] nums2) {

        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> retSet = new HashSet<>();//返回的set
        for (int i : nums1) {
            set.add(i);
        }
        for (int i : nums2) {
            if (set.contains(i)){
                //set.contains(i)当set中存在i时返回ture
                retSet.add(i);
            }
        }
        //转化为数组
        int[] ints = retSet.stream().mapToInt(x -> x).toArray();


        return ints;
    }

}
