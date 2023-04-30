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
     *
     * 数组其实就是一个简单哈希表，而且这道题目中字符串只有小写字符，那么就可以定义一个数组，来记录字符串s里字符出现的次数。
     *
     * 如果对哈希表的理论基础关于数组，set，map不了解的话可以看这篇：关于哈希表，你该了解这些！(opens new window)
     *
     * 需要定义一个多大的数组呢，定一个数组叫做record，大小为26 就可以了，初始化为0，因为字符a到字符z的ASCII也是26个连续的数值。
     *
     * 为了方便举例，判断一下字符串s= "aee", t = "eae"。
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
