package 哈希表;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Title: demo06
 * @Author 笑霸fianl
 * @Package 哈希表
 * @Date 2023/5/1 16:03
 * @描述: 第15题. 三数之和 https://leetcode.cn/problems/3sum/
 */
public class demo06 {
    public static void main(String[] args) {
        int[] a =new int[]{1,-1,-1,0};
        System.out.println(threeSum(a));
    }

    /**
     * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
     *
     * 注意： 答案中不可以包含重复的三元组。
     * 3 <= nums.length <= 3000
     * -105 <= nums[i] <= 105
     *
     *
     * 这里 我们使用双指针算法
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        //先对nums排序
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<>();


        for (int i = 0; i < nums.length; i++) {
            if(nums[i]> 0){
                return lists;
            }
            if (i>0 && nums[i]==nums[i-1]){//去重
                continue;
            }

            int l=i+1,r= nums.length-1;//左 右指针
            while (l<r){ //左边必须小于 右边
                int temp=nums[l]+nums[r]+nums[i];
                if(temp==0){

                    lists.add(Arrays.asList(nums[l],nums[r],nums[i]));
                    //对 b c 去重
                    while( l<r && nums[l]==nums[l+1] )l++; //注意 nums[l]==nums[l+1] &&  l<r  这样不可取
                    while( l<r && nums[r]==nums[l-1] )r--;

                    r--;
                    l++;


                }else if(temp < 0){
                    l++;
                }else {
                    r--;
                }
            }

        }

        return lists;
    }

    public static List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        // 找出a + b + c = 0
        // a = nums[i], b = nums[left], c = nums[right]
        for (int i = 0; i < nums.length; i++) {
            // 排序之后如果第一个元素已经大于零，那么无论如何组合都不可能凑成三元组，直接返回结果就可以了
            if (nums[i] > 0) {
                return result;
            }

            if (i > 0 && nums[i] == nums[i - 1]) {  // 去重a
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;
            while (right > left) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 去重逻辑应该放在找到一个三元组之后，对b 和 c去重
                    while (right > left && nums[right] == nums[right - 1]) right--;
                    while (right > left && nums[left] == nums[left + 1]) left++;

                    right--;
                    left++;
                }
            }
        }
        return result;
    }

}

