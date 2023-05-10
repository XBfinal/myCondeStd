package 力扣每日一题.二三年5月;

/**
 * @Title: 五月10
 * @Author 笑霸fianl
 * @Package 力扣每日一题.二三年5月
 * @Date 2023/5/10 15:59
 * @描述: https://leetcode.cn/problems/smallest-integer-divisible-by-k/comments/
 */
public class 五月10 {

    public static void main(String[] args) {
        System.out.println(smallestRepunitDivByK(19));
    }


    public static int smallestRepunitDivByK(int k) {

// 若 k 能被 2 或 5 整除，则无解，返回 -1
        if (k % 2 == 0 || k % 5 == 0) {
            return -1;
        }
        // 初始化余数为 1，表示一个数的最低位是 1
        int resid = 1 % k, len = 1;
        // 若余数不为 0，继续迭代
        while (resid != 0) {
            // 计算下一个数的余数，下一个数在当前余数后加一个 1
            resid = (resid * 10 + 1) % k;
            len++;
        }
        // 返回数字 1 的最小重复次数
        return len;


    }
}
