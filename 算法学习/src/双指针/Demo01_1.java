package 双指针;

/**
 * @Title: Demo01_1
 * @Author 笑霸fianl
 * @Package 双指针
 * @Date 2023/5/5 20:19
 * @描述: 26. 删除有序数组中的重复项   https://leetcode.cn/problems/remove-duplicates-from-sorted-array/
 */
public class Demo01_1 {



    public int removeDuplicates(int[] nums) {

        int len= nums.length;
        int s=0,f=s+1;//快慢指针
        while (f<len){
            if (f<len && nums[s]==nums[f]){
                f++;
            }else{

                //nums[s] != nums[f]
                nums[++s]=nums[f++];
            }

        }


        return s+1;
    }

}
