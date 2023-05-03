package 字符串;

/**
 * @Title: demo02
 * @Author 笑霸fianl
 * @Package 字符串
 * @Date 2023/5/3 14:05
 * @描述: 541. 反转字符串II  https://leetcode.cn/problems/reverse-string-ii/
 */
public class demo02 {

    public static void main(String[] args) {
        String abcdefg = reverseStr("abcdefg", 8);
        System.out.println(abcdefg);
    }


    public static String reverseStr(String s, int k) {

        char[] ch = s.toCharArray();
        for(int i = 0; i < ch.length; i += 2 * k){
            int start = i;
            //这里是判断尾数够不够k个来取决end指针的位置
            int end = Math.min(ch.length - 1, start + k - 1);
            //用异或运算反转
            while(start < end){
                ch[start] ^= ch[end];
                ch[end] ^= ch[start];
                ch[start] ^= ch[end];
                start++;
                end--;
            }
        }
        return new String(ch);
    }



}
