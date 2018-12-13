package LeetCode;

import org.apache.storm.shade.com.google.common.collect.Lists;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Description:
 * @Author:TERRY_MENG
 * @Date:2018-12-11
 */
public class LevelOrder {
    public static void main(String[] args) {

    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue= Lists.newLinkedList();
        List<List<Integer>> res=Lists.newArrayList();
        if (root==null) {
            return res;
        }
        queue.offer(root);
        while(!queue.isEmpty()){
            int level=queue.size();
            List<Integer> subList = new LinkedList<>();
            for (int i = 0; i <level ; i++) {
                if(queue.peek().left!=null){
                    queue.offer(queue.peek().left);
                }
                if(queue.peek().right!=null){
                    queue.offer(queue.peek().right);
                }
                 subList.add(queue.peek().val);
            }
            res.add(subList);
        }
        return res;
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
