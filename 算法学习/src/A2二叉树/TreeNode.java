package A2二叉树;

/**
 * @Title: TreeNode
 * @Author 笑霸fianl
 * @Package A2二叉树
 * @Date 2023/5/13 14:57
 * @描述:
 */

public class TreeNode {
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

