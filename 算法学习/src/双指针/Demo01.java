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

        int[] ints = {0,1,2,2,3,0,4,2};

        System.out.println(removeElement2(ints,2));
    }

    //快慢双指针
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

    //相向双指针
    public static int removeElement2(int[] nums, int val) {
        int len =nums.length;
        int left=0,right=len-1;
        while(right >= 0 && nums[right] == val) right--;
        while(left <= right) {

            if(nums[left] == val) { //left位置的元素需要移除
                //将right位置的元素移到left（覆盖），right位置移除
                nums[left] = nums[right];
                right--;
            }
            left++;
            while(right >= 0 && nums[right] == val) right--;

        }
        return left;


    }
}
