package LeetCode;

/**
 * @author:menglihuan
 * @data:2018/12/12
 * @ds:
 */
public class IsSymmetric {
    public static void main(String[] args) {
    }
    public boolean isSymmetric(TreeNode root) {
        return isSame(root.left, root.right);
    }

    public boolean isSame(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        return (root1.val == root2.val) && isSame(root1.left, root2.right) && isSame(root1.right, root2.left);
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}