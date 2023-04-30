package 哈希表;

/**
 * @Title: demo01
 * @Author 笑霸fianl
 * @Package 哈希表
 * @Date 2023/4/30 16:01
 * @描述:   242.有效的字母异位词
 */

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 注意：若s 和 t中每个字符出现的次数都相同，则称s 和 t互为字母异位词。
 *
 * 提示:
 * 1 <= s.length, t.length <= 5 * 104
 * s 和 t 仅包含小写字母
 */
public class demo01 {
    public static void main(String[] args) {
        System.out.println(isAnagram("abcdt","bcda"));
    }


    /**
     * 数组解法
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram(String s, String t) {
        //字母异位词。说明长度至少相同
        if (s.length()!=t.length()){
            return false;
        }
        int[] sn=new int[26];
        int[] tn=new int[26];

        //字符串转化为数组
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();

        for (int i = 0; i < t.length(); i++) {
            //a的ASCII码值 为97
            sn[sChar[i]-97]++;
            tn[tChar[i]-97]++;
        }
        //判断是否相等
        for (int i = 0 ; i < 26 ; i++ ){
            if(sn[i]!=tn[i]){
                return false;
            }
        }

        return true;

    }

}
