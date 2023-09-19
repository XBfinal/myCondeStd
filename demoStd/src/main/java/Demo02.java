import jdk.nashorn.internal.ir.CallNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @Title: Demo02
 * @Author 笑霸fianl
 * @Package PACKAGE_NAME
 * @Date 2023/9/16 15:30
 * @描述: 1
 */
public class Demo02 {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int x = in.nextInt();
//        int y = in.nextInt();
//        long tep=1;
//        long res=0;
//
//        for (int i = 0; i < y; i++) {
//            tep *=x;
//        }
//        res = tep % 10;
//        System.out.println(res);
//
//    }

    static int res=-1;
    static int count=0;
    static int tep=0;
    public static void main(String[] args) {


        Scanner in = new Scanner(System.in);
        //输入数组(字符串)
        String arr = in.next();
        //输入的长度
        String sLen= in.next();

        //转化为数字
        int len = Integer.parseInt(sLen);
        String[] split = arr.split(",");
        ArrayList<Integer> integers = new ArrayList<>();
        for (String s :split ) {
            integers.add(Integer.parseInt(s));
        }
        //对数组排序
        List<Integer> collect = integers.stream().sorted().collect(Collectors.toList());
        Integer integer = collect.get(collect.size()-1);
        bcking(integer,len);


    }

    public static void  bcking(int startIndex,int n){
        if(startIndex<0){
            System.out.println("-1");
            return ;
        }
        for (int i=startIndex ; i>=0;i--){
            tep+=i;
            count++;
            if(tep > n){
                tep -=i;//回溯
                count--;
                bcking(startIndex--,n);
            }
            if(tep==n){
                System.out.println(count);
                return;
            }
            if (tep <n){
                bcking(startIndex,n);
            }
        }


    }


}
