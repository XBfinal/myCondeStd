package 哈希表;

/**
 * @Title: Other01
 * @Author 笑霸fianl
 * @Package 哈希表
 * @Date 2023/5/7 15:06
 * @描述: 1010. 总持续时间可被 60 整除的歌曲 https://leetcode.cn/problems/pairs-of-songs-with-total-durations-divisible-by-60/
 */
public class Other01 {

    public static void main(String[] args) {

        int[] time = new int[]{60,60,60};
        System.out.println(numPairsDivisibleBy601(time));
    }


    /**
     * 提示：
     *
     * 1 <= time.length <= 6 * 104
     * 1 <= time[i] <= 500
     * @param time
     * @return
     */

    public static int numPairsDivisibleBy601(int[] time) {

       int[] hash = new int[60];
       int count=0;

        for (int t:time ) {

            count+= hash[ (60 - t % 60) % 60 ]; //(60 - t % 60)可能会下标越界
            hash[t % 60]++;//然后存入当前下标
        }
        return count;

    }

    public static int numPairsDivisibleBy60(int[] time) {

        int[] count =new int[60];
        int res=0;
        for(int i=0;i<time.length;i++){

            res+=count[ (60 - time[i] % 60)  % 60];

            count[ time[i] % 60 ]++;
        }
        return res;


    }
}
