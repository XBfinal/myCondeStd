package 字符串;

/**
 * @Title: demo04
 * @Author 笑霸fianl
 * @Package 字符串
 * @Date 2023/5/4 8:43
 * @描述: 151.翻转字符串里的单词 https://leetcode.cn/problems/reverse-words-in-a-string/
 */
public  class demo04 {
    public static void main(String[] args) {
        System.out.println(reverseWords("  the     sky is blue"));
    }


    /**
     * 给你一个字符串 s ，请你反转字符串中 单词 的顺序。
     *
     * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
     *
     * 返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
     *
     * 注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/reverse-words-in-a-string
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param s
     * @return
     */
    public static String reverseWords(String s) {

        // System.out.println("ReverseWords.reverseWords2() called with: s = [" + s + "]");
        // 1.去除首尾以及中间多余空格
        StringBuilder sb = removeSpace(s); //"the sky is blue"
        // 2.反转整个字符串
        reverseString(sb, 0, sb.length() - 1); //"eulb si yks eht"
        // 3.反转各个单词
        reverseEachWord(sb);//blue is sky the
        return sb.toString();
    }

    //1.去除首尾以及中间多余空格
    private static StringBuilder removeSpace(String s) {
        // System.out.println("ReverseWords.removeSpace() called with: s = [" + s + "]");
        int start = 0;
        int end = s.length() - 1;
        while (s.charAt(start) == ' ') start++;//去除头部的空格
        while (s.charAt(end) == ' ') end--; //去除尾部的空格
        StringBuilder sb = new StringBuilder();
        while (start <= end) {              //去除中间多余的空格
            char c = s.charAt(start);
            if (c != ' ' || sb.charAt(sb.length() - 1) != ' ') { //先加入中间的第一个空格 然后判断
                sb.append(c);
            }
            start++;
        }
        // System.out.println("ReverseWords.removeSpace returned: sb = [" + sb + "]");
        return sb;//  "the sky is blue"
    }



    //     // 3.反转各个单词
    private static void reverseEachWord(StringBuilder sb) {
        int start = 0;
        int end = 1;
        int n = sb.length();
        while (start < n) {
            while (end < n && sb.charAt(end) != ' ') {
                end++;
            }
            reverseString(sb, start, end - 1);
            start = end + 1;
            end = start+1;
        }
    }

    /**
     * 反转字符串指定区间[start, end]的字符
     */
    public static void reverseString(StringBuilder sb, int start, int end) {
        // System.out.println("ReverseWords.reverseString() called with: sb = [" + sb + "], start = [" + start + "], end = [" + end + "]");
        while (start < end) {
            char temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);
            start++;
            end--;
        }
        // System.out.println("ReverseWords.reverseString returned: sb = [" + sb + "]");
    }
}
