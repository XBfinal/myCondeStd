package A1栈与队列;

import java.util.Arrays;
import java.util.Stack;

/**
 * @Title: Demo04
 * @Author 笑霸fianl
 * @Package A1栈与队列
 * @Date 2023/5/10 15:25
 * @描述: 150. 逆波兰表达式求值  https://leetcode.cn/problems/evaluate-reverse-polish-notation/
 */
public class Demo04 {

    public static void main(String[] args) {
        String[] token = new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(evalRPN(token));
    }

    /**
     * 给你一个字符串数组 tokens ，表示一个根据逆波兰表示法 表示的算术表达式。
     *
     * 请你计算该表达式。返回一个表示表达式值的整数。
     *
     * 注意：
     *
     * 有效的算符为 '+'、'-'、'*' 和 '/' 。
     * 每个操作数（运算对象）都可以是一个整数或者另一个表达式。
     * 两个整数之间的除法总是 向零截断 。
     * 表达式中不含除零运算。
     * 输入是一个根据逆波兰表示法表示的算术表达式。
     * 答案及所有中间计算结果可以用 32 位 整数表示。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/evaluate-reverse-polish-notation
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param tokens
     * @return
     */
    public static int evalRPN(String[] tokens) {


        Stack<Integer> stack1 = new Stack<>();//存放第一个数 或者 结果

        for (int i = 0; i < tokens.length; i++) {
            if(tokens[i].equals("+")){//注意 不能用 ==
                Integer int1 = stack1.pop();
                Integer int2 = stack1.pop();
                stack1.push(int1+int2);

            }else if(tokens[i].equals("-")){
                Integer int1 = stack1.pop();
                Integer int2 = stack1.pop();
                stack1.push(int2-int1);

            }else if(tokens[i].equals("*")){
                Integer int1 = stack1.pop();
                Integer int2 = stack1.pop();
                stack1.push(int1*int2);

            }else if(tokens[i].equals("/")){
                Integer int1 = stack1.pop();
                Integer int2 = stack1.pop();
                stack1.push(int2/int1);

            }else{
                stack1.push(Integer.parseInt(tokens[i]));
            }
        }

        return stack1.pop();
    }
}
