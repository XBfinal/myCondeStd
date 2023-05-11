package A1栈与队列;


import java.util.*;

/**
 * @Title: Demo05
 * @Author 笑霸fianl
 * @Package A1栈与队列
 * @Date 2023/5/11 14:10
 * @描述: 239. 滑动窗口最大值 https://leetcode.cn/problems/sliding-window-maximum/
 */
public class Demo05 {

    public static void main(String[] args) {
        int[] nums =new  int[]{1,-1};

        int[] ints = maxSlidingWindow(nums, 1);


        for (int i:ints
             ) {
            System.out.println(i);
        }
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int n = nums.length;
        int[] res = new int[n - k + 1];
        int idx = 0;
        for(int i = 0; i < n; i++) {
            // 根据题意，i为nums下标，是要在[i - k + 1, i] 中选到最大值，只需要保证两点
            // 1.队列头结点需要在[i - k + 1, i]范围内，不符合则要弹出
            while(!deque.isEmpty() && deque.peek() < i - k + 1){
                deque.poll();
            }
            // 2.既然是单调，就要保证每次放进去的数字要比末尾的都大，否则也弹出
            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            deque.offer(i);

            // 因为单调，当i增长到符合第一个k范围的时候，每滑动一步都将队列头节点放入结果就行了
            if(i >= k - 1){
                res[idx++] = nums[deque.peek()];
            }
        }
        return res;
    }


}
