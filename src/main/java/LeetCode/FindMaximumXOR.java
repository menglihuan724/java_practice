package LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author:TERRY_MENG
 * @Date:2018-12-06
 */
public class FindMaximumXOR {
    class Trie {
        Trie[] children;
        public Trie() {
            children = new Trie[2];
        }

        @Override
        public String toString() {
            return "Trie{" +
                    "children=" + Arrays.toString(children) +
                    '}';
        }
    }
    public Integer findMaximumXOR(int[] nums) {
        Trie root = new Trie();
        for(int num: nums) {
            Trie curNode = root;
            for(int i = 31; i >= 0; i --) {
                int curBit = (num >>> i) & 1;
                if(curNode.children[curBit] == null) {
                    curNode.children[curBit] = new Trie();
                }
                curNode = curNode.children[curBit];
            }
        }
        int max = Integer.MIN_VALUE;
        for (int num:nums){
            Trie cur=root;
            int curNum=0;
            for(int i = 31; i >= 0; i --) {
                int curBit=(num>>>i) & 1;
                if(cur.children[curBit ^ 1] !=null){
                    curNum += (1 << i);
                    cur = cur.children[curBit ^ 1];
                }else{
                    cur=cur.children[curBit];
                }
            }
            max=Math.max(max,curNum);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums={3,10,5,25,2,8};
        FindMaximumXOR findMaximumXOR=new FindMaximumXOR();
        System.out.println(findMaximumXOR.findMaximumXOR(nums));
        System.out.println(1^29^29);
    }
}
