package coding;

/*
 * There are different ways to traverse a binary tree. The zigzag level order traversal of a binary tree covers all the nodes of the tree such that each level is traversed left to right or right to left alternatively.
 * Given the root node of a binary tree, return an array depicting the zigzag level order traversal.
 * Note: The first level is traversed left to right.
 */

class Solution {
	/* This is the Node class definition
	
	class Node {
		public Node left;
		public Node right;
		public int data;

		public Node(int data) {
			this.data = data;
		}
	}
	*/
	
	int[] zigzagLevelOrderTraversal(Node root) {
	    ArrayDeque<Node> queue = new ArrayDeque<>();
		queue.offer(root);
		ArrayList<Integer> result = new ArrayList<>();
		result.add(root.data);
		int l = 1;
		while(!queue.isEmpty()) {
			int n = queue.size();
			for(int i = 0; i < n; i++) {
				Node node = l % 2 == 0 ? queue.pollLast() : queue.pollFirst();
				if(l % 2 != 0) {
					if(node.right != null) {
						queue.offerLast(node.right);
						result.add(node.right.data);
					}
					if(node.left != null) {
						queue.offerLast(node.left);
						result.add(node.left.data);
					}
				} else {
					if(node.left != null) {
						queue.offerFirst(node.left);
						result.add(node.left.data);
					}
					if(node.right != null) {
						queue.offerFirst(node.right);
						result.add(node.right.data);
					}
				}
			}
			l++;
		}
		
		int[] ans = new int[result.size()];
		for(int i = 0; i < result.size(); i++) {
			ans[i] = result.get(i);
		}
		return ans;
	}
}