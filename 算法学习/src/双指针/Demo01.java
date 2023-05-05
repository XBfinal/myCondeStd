package 双指针;

/**
 * @Title: Demo01
 * @Author 笑霸fianl
 * @Package 双指针
 * @Date 2023/5/5 19:25
 * @描述: 27. 移除元素 https://leetcode.cn/problems/remove-element/
 */
public class Demo01 {

    public static void main(String[] args) {


    }

    public static int removeElement(int[] nums, int val) {
        int len =nums.length;
        int f=0,s=0;
        while (f<len){
            if(nums[f]==val){
                f++;
            }else{
                nums[s++]=nums[f++];
            }

        }
        return s;

    }
}
