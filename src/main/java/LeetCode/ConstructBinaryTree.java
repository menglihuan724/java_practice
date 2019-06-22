package LeetCode;

/**
 * @author:menglihuan
 * @data:2018/12/20
 * @ds:根据中序排列和后序排列生成原有树
 */
public class ConstructBinaryTree {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
            return buildTree(inorder,0,
                    inorder.length-1,postorder,0,postorder.length-1);
    }
    public TreeNode buildTree(int[] in, int inStart, int inEnd, int[] post, int postStart, int postEnd){
        if(inStart > inEnd || postStart > postEnd){
            return null;
        }
        int rootVal = post[postEnd];
        int rootIndex=0;
        for (int i = inStart; i <=inEnd ; i++) {
            if (in[i]==rootVal){
                rootIndex=i;
                break;
            }
        }
        int len = rootIndex - inStart;
        TreeNode root = new TreeNode(rootVal);
        root.left = buildTree(in, inStart, rootIndex-1, post, postStart, postStart+len-1);
        root.right = buildTree(in, rootIndex+1, inEnd, post, postStart+len, postEnd-1);

        return root;
    }
}