package 力扣每日一题.二三年5月;

/**
 * @Title: 五月9号
 * @Author 笑霸fianl
 * @Package 力扣每日一题.二三年5月
 * @Date 2023/5/9 15:14
 * @描述:
 */
public class 五月9号 {
    public static void main(String[] args) {

    }


    /**
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/number-of-valid-clock-times
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public int countTime(String time) {
        int countHour = 0;
        int countMinute = 0;
        for (int i = 0; i < 24; i++) {
            int hiHour = i / 10;
            int loHour = i % 10;
            if ((time.charAt(0) == '?' || time.charAt(0) == hiHour + '0') &&
                    (time.charAt(1) == '?' || time.charAt(1) == loHour + '0')) {
                countHour++;
            }
        }
        for (int i = 0; i < 60; i++) {
            int hiMinute = i / 10;
            int loMinute = i % 10;
            if ((time.charAt(3) == '?' || time.charAt(3) == hiMinute + '0') &&
                    (time.charAt(4) == '?' || time.charAt(4) == loMinute + '0')) {
                countMinute++;
            }
        }
        return countHour * countMinute;
    }
}
