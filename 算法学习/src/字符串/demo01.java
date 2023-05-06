package 字符串;

/**
 * @Title: demo01
 * @Author 笑霸fianl
 * @Package 字符串
 * @Date 2023/5/3 13:53
 * @描述: 344.反转字符串   https://leetcode.cn/problems/reverse-string/
 */
public class demo01 {



    public  void reverseString2(char[] s) {
        int length = s.length;
        if(length==1) return ;
        int l=0,r=length-1;
        while (l<r){
            s[l] ^= s[r]; //a[l]=a[l]^a[r];
            s[r] ^= s[l]; //s[r] = a[r] ^ a[l]^a[r] =a[r];
            s[l] ^= s[r]; // a[l] = a[l]^ a[r] = a[l]^a[r]^ a[l] =a[r];
            l++;
            r--;
        }

    }

    /**
     * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
     *
     * 不要给另外的   '数组 '  分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/reverse-string
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param s
     */
    public static void reverseString(char[] s) {
        int l=0,r=s.length-1;
        while(l<r){
            s[l] ^= s[r]; //a[l]=a[l]^a[r];
            s[r] ^= s[l]; //s[r] = a[r] ^ a[l]^a[r] =a[r];
            s[l] ^= s[r]; // a[l] = a[l]^ a[r] = a[l]^a[r]^ a[l] =a[r];
            l++;
            r--;
        }
    }
}
