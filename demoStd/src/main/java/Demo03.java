import java.util.Arrays;
import java.util.Stack;

/**
 * @Title: Demo03
 * @Author 笑霸fianl
 * @Package PACKAGE_NAME
 * @Date 2023/9/19 15:38
 * @描述: 腾讯云笔试
 */
public class Demo03 {
    public static void main(String[] args) {
        Demo03 demo03 = new Demo03();
        System.out.println(demo03.isValidString("(*)"));
    }


    public boolean isValidString(String s) {

        // write code here
        char[] chars = s.toCharArray();

        Stack<Character> stack = new Stack<>();
        Stack<Character> stack2 = new Stack<>();//保存 *
        for (char c : chars) {
            if (c == ')') {
                if (stack.isEmpty()) {
//                    return false;
                    if (stack2.isEmpty()) {
                        return false;
                    } else {
                        stack2.pop();
                    }

                }
                Character pop = stack.pop();
                if (pop == null || pop == ')') {
                    return false;
                }
            } else if (c == '(') {
                stack.push(c);//进栈
            } else { // 为 *的情况
                if (stack.isEmpty()) {
                    stack.push(c);//进栈
                } else {
//                    stack.pop();//出栈
                    stack2.push(c);
                }

            }
        }

        while(!stack2.isEmpty()){
            stack2.pop();
            if(!stack.isEmpty()){
                stack.pop();
            }else{
                return true;
            }
        }

        return stack.isEmpty();
    }
}
