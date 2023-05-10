package A1栈与队列;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Title: Demo03
 * @Author 笑霸fianl
 * @Package A1栈与队列
 * @Date 2023/5/10 14:47
 * @描述: 1047. 删除字符串中的所有相邻重复项 https://leetcode.cn/problems/remove-all-adjacent-duplicates-in-string/
 */
public class Demo03 {

    public static void main(String[] args) {
        System.out.println(removeDuplicates("abbaca"));
    }

    /**
     * 给出由小写字母组成的字符串S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
     *
     * 在 S 上反复执行重复项删除操作，直到无法继续删除。
     *
     * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/remove-all-adjacent-duplicates-in-string
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param s
     * @return
     */
    public static String removeDuplicates(String s) {

        if (s.length()<2) {
            return s;
        }
        char[] chars = s.toCharArray();
        Stack<Character> strStack = new Stack<>();//创建栈

        for (char c:chars) {
            if(strStack.isEmpty()){
                strStack.push(c);
                continue;
            }
           if (strStack.peek()==c){
               strStack.pop();//弹出栈顶元素
           }else{
               strStack.push(c);
           }
        }
        //得到string;
       StringBuilder str = new StringBuilder();
        while (!strStack.isEmpty()){
            str.append(strStack.pop());
        }

        return str.reverse().toString();
    }
}
