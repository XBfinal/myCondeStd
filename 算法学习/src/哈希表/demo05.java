package 哈希表;

import java.util.HashMap;

/**
 * @Title: demo05
 * @Author 笑霸fianl
 * @Package 哈希表
 * @Date 2023/5/1 15:37
 * @描述: 383. 赎金信  https://leetcode.cn/problems/ransom-note/
 */
public class demo05 {
    public static void main(String[] args) {

    }


    /**

     * 给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
     *
     * 如果可以，返回 true ；否则返回 false 。
     *
     * magazine 中的每个字符只能在 ransomNote 中使用一次。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/ransom-note
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param ransomNote
     * @param magazine
     * @return
     */
    public boolean canConstruct(String ransomNote, String magazine) {

        char[] chars = ransomNote.toCharArray();//小范围
        char[] chars1 = magazine.toCharArray();//大范围

        int[] n= new int[26];
        int[] n1= new int[26];

        for (char a:chars){
            n[a-'a']++;
        }
        for (char b : chars1){
            n1[b-'a']++;
        }
        //开始比较
        for (int i = 0; i < 26; i++) {
            if(n[i]>n1[i]){
                return false;
            }
        }

        return true;
    }
}
