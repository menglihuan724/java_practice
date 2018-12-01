package LeetCode;

import org.apache.storm.shade.com.google.common.collect.Lists;

import java.util.List;

/**
 * @author:menglihuan
 * @data:2018/12/1
 * @ds:
 */
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if ((head == null)||(head.next == null))
            return head;
        ListNode n = head.next;
        head.next = swapPairs(head.next.next);
        n.next = head;
        return n;
    }
}


class Pair {
    private List<Object> pairs=Lists.newArrayListWithExpectedSize(2);

    public   boolean  addElement(Object o){
        if (checkSize()){
            getPairs().add(o);
            return true;
        }else{
            return false;
        }
    }

    public List<Object> getPairs() {
        return pairs;
    }

    public void setPairs(List<Object> pairs) {
        this.pairs = pairs;
    }

    private boolean checkSize(){
        if (getPairs().size()<2){
            return true;
        }else{
            return false;
        }
    }
}
class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }