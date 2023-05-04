package 字符串;

/**
 * @Title: demo05
 * @Author 笑霸fianl
 * @Package 字符串
 * @Date 2023/5/4 9:21
 * @描述: 剑指Offer58-II.左旋转字符串 https://leetcode.cn/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/
 */
public class demo05 {
    public static void main(String[] args) {
        System.out.println(reverseLeftWords("abcdefg",2));
    }

    public static String reverseLeftWords(String s, int n) {
        int len=s.length();
        StringBuilder sb=new StringBuilder(s);
        reverseString(sb,0,n-1);
        reverseString(sb,n,len-1);
        return sb.reverse().toString();
    }
    public static void reverseString(StringBuilder sb, int start, int end) {
        while (start < end) {
            char temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);
            start++;
            end--;
        }
    }


    public static String reverseLeftWords1(String s, int n) {
        return s.substring(n, s.length()) + s.substring(0, n);//切片法
    }
}
