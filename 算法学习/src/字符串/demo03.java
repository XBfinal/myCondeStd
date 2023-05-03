package 字符串;

/**
 * @Title: demo03
 * @Author 笑霸fianl
 * @Package 字符串
 * @Date 2023/5/3 15:10
 * @描述: 剑指Offer 05.替换空格 https://leetcode.cn/problems/ti-huan-kong-ge-lcof/
 */
public class demo03 {


    public String replaceSpace(String s) {

        if(s == null || s.length() == 0){
            return s;
        }
        //统计空格
        int count=0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)==' '){
                count+=2;
            }
        }
        if(count==0){
            return s;
        }
        char[] chars = new char[s.length() + count];

        int j=0;
        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i)==' '){
                chars[j++]='%';
                chars[j++]='2';
                chars[j]='0';
            }else{
                chars[j]=s.charAt(i);
            }
            j++;
        }

        return String.valueOf(chars);
    }


}
