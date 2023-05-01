package 哈希表;


import java.util.HashMap;

/**
 * @Title: demo
 * @Author 笑霸fianl
 * @Package 哈希表
 * @Date 2023/5/1 14:35
 * @描述: 第202题. 快乐数  https://leetcode.cn/problems/happy-number/
 */
public class demo {

    public static void main(String[] args) {
        System.out.println(isHappy(2));
    }


    /**
     * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
     * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
     * 如果这个过程 结果为 1，那么这个数就是快乐数。
     *
     * 1 <= n <= 231 - 1
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/happy-number
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param n
     * @return
     */
    public static boolean isHappy(int n) {
        if(n==1){
            return true;
        }
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        hashMap.put(n,n);

        while(n != 1 ){

            int tepSum=0;

            while(n!=0){
                int tep=n%10;
                tepSum+=tep*tep;
                n=n/10;
            }
            if(tepSum!=1){
                //contains 包含
                if(!hashMap.containsKey(tepSum)){
                    //如果map里面没有此数字则加入
                    hashMap.put(tepSum,tepSum);
                    n=tepSum;
                    tepSum=0;
                }else{
                    //如果有 则直接返回false 会循环就永远不可能为1
                    return false;
                }

            }else{
                return true;
            }


        }

        return true;
    }


}
