package coding;

import java.util.ArrayDeque;

/*
 * A perfect binary tree is a binary tree in which all interior nodes have two children and all leaves have the same depth or same level.
 * Given a perfect binary tree which contains an extra next pointer in all the node, populate the next pointers of each node to its next right node.
 * In nodes with no right nodes, set next to null.
 */

class Node {
	public Node left;
    public Node right;
    public Node next;
    int data;

    Node(int data) {
        this.data = data;
    }
}

class Solution {
	void connect(Node root) {
    	ArrayDeque<Node> queue = new ArrayDeque<>();
		queue.offer(root);
		int l = 1;
		while(!queue.isEmpty()) {
			int n = queue.size();
            Node prev = null;
			for (int i = 0; i < n; i++) {
				Node current = queue.poll();
				if(prev == null) {
					prev = current;
				} else {
					prev.next = current;
				}
				if(current.left != null) {
					queue.offer(current.left);
				}
				if(current.right != null) {
					queue.offer(current.right);
				}
				prev = current;
			}
		}
	}
}