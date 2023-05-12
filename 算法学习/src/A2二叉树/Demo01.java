package A2二叉树;

import java.util.ArrayList;
import java.util.List;

/**
 * @Title: Demo01
 * @Author 笑霸fianl
 * @Package A2二叉树
 * @Date 2023/5/12 19:05
 * @描述: 144. 二叉树的前序遍历   https://leetcode.cn/problems/binary-tree-preorder-traversal/
 */
public class Demo01 {


    /**
     * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList();
        dfs(root,list);
        return list;
    }

    public void dfs(TreeNode root, List<Integer> list){
        if(root==null)return ;
        list.add(root.val);
        dfs(root.left,list);
        dfs(root.right,list);
    }
}


 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
