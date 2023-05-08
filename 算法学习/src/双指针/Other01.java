package 双指针;

/**
 * @Title: Other01
 * @Author 笑霸fianl
 * @Package 双指针
 * @Date 2023/5/8 14:56
 * @描述: 面试题 02.07. 链表相交 https://leetcode.cn/problems/intersection-of-two-linked-lists-lcci/
 */
public class Other01 {


//        0
//        [1]
//        []
//        1
//        0

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode index1=headA,index2=headB; //头节点有数据

        while(index1!=null){
            if(index1 == index2){
                return  index1;
            }
            if(index2==null){
                index2=headB;
                if(index1==null){
                    break;
                }
                index1=index1.next;
            }else{
                index2=index2.next;
            }
        }
        return null;
    }
}


class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }
 }