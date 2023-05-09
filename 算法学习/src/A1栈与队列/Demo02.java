package A1栈与队列;

import java.util.Stack;

/**
 * @Title: Demo02
 * @Author 笑霸fianl
 * @Package A1栈与队列
 * @Date 2023/5/9 14:40
 * @描述: 20. 有效的括号  https://leetcode.cn/problems/valid-parentheses/
 */
public class Demo02 {

    public static void main(String[] args) {
        System.out.println(isValid("{[]}"));
    }

    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
     *
     * 有效字符串需满足：
     *
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 每个右括号都有一个对应的相同类型的左括号。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/valid-parentheses
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param s
     * @return
     */
    public static boolean isValid(String s) {
        if (s.length()%2!=0)return  false;

        char[] chars = s.toCharArray();

        Stack<Character> stack = new Stack<>();

        for ( char c: chars ) {
           if(!stack.isEmpty()){
               if(c==')'){
                   if(stack.peek()=='('){
                       //弹出
                       stack.pop();
                   }else{
                       //入栈
                       stack.push(c);
                   }
               }
               else if(c==']'){
                   if(stack.peek()=='['){
                       //弹出
                       stack.pop();
                   }else{
                       //入栈
                       stack.push(c);
                   }

               }
               else if(c=='}'){
                   if(stack.peek()=='{'){
                       //弹出
                       stack.pop();
                   }else{
                       //入栈
                       stack.push(c);
                   }

               }else {
                   stack.push(c);
               }
           }
           else{
               stack.push(c);
           }

        }

        return stack.isEmpty();
    }
}
