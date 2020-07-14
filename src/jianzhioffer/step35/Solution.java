package jianzhioffer.step35;


import java.util.HashMap;
import java.util.Map;

/**
 * dfs 递归创建节点
 */
public class Solution {


    public Node copyRandomList(Node head) {

        if (head == null) {
            return head;
        }
        // key->old  value->new
        Map<Node, Node> map = new HashMap<>();

        return createNode(map,head);
    }

    private Node createNode(Map<Node, Node> map, Node node) {

        if (node == null) {
            return null;
        }
        if (map.get(node) != null) {
            return map.get(node);
        }

        //创建节点
        Node newNode = new Node(node.val);
        map.put(node,newNode);
        newNode.next = createNode(map, node.next);
        newNode.random = createNode(map, node.random);
        return newNode;
    }


    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
