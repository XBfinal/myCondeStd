package 力扣;

import org.testng.annotations.Test;

import java.lang.reflect.Array;

/**
 * @Title: day01
 * @Author 笑霸fianl
 * @Package 力扣
 * @Date 2023/7/29 19:16
 * @描述:
 */
public class day01 {


    /**
     * 剑指 Offer 05. 替换空格
     */
    @Test
    public void Offer_05(){

        System.out.println(replaceSpace("    "));
    }
    public String replaceSpace(String s) {
        if(s==null || s.length()==0){
            return s;
        }
        char[] chars = s.toCharArray();
        StringBuilder ss=new StringBuilder();
        for (char c:chars) {
            if (c==' '){
                ss.append("%20");
            }else {
                ss.append(c);
            }
        }
        return ss.toString();
    }

    /**
     * 剑指 Offer 58 - II. 左旋转字符串
     */
    @Test
    public void Offer_58(){

        System.out.println(reverseLeftWords("abcdefg",2));
    }
    public String reverseLeftWords(String s, int n) {
        if(s==null || s.length()<=n){
            return s;
        }
       return s.substring(n)+s.substring(0,n);
    }

    @Test
    public void str_test(){
//        String s1="";
//        String s2=" ";
//        System.out.println(s1.equals(s2));
//        System.out.println(s1.length());
//        System.out.println(s2.length());
//
//        String[] split = s1.split(",");
//        System.out.println(split.length);

    }



}
