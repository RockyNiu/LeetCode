package leetcode.java;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

	/**
	 * Given preorder and inorder traversal of a tree, construct the binary
	 * tree.
	 * 
	 * Note: You may assume that duplicates do not exist in the tree.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution105 {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder.length == 0 || inorder.length == 0
				|| preorder.length != inorder.length)
			return null;

		return buildTreeWithPreorderAndInorder(preorder, inorder, 0,
				preorder.length - 1, 0, inorder.length - 1);

	}

	TreeNode buildTreeWithPreorderAndInorder(int[] preorder, int[] inorder,
			int startPreOrder, int endPreOrder, int startInOrder, int endInOrder) {
		// if startPreOrder out of range of preorder
		if (startPreOrder >= preorder.length)
			return null;
		TreeNode root = new TreeNode(preorder[startPreOrder]);

		int indexRootInOrder = startInOrder;

		// find root in inorder
		while (inorder[indexRootInOrder] != preorder[startPreOrder]
				&& indexRootInOrder <= endInOrder) {
			indexRootInOrder++;
		}

		int distance = indexRootInOrder - startInOrder;
		if (indexRootInOrder > startInOrder) {
			root.left = buildTreeWithPreorderAndInorder(preorder, inorder,
					startPreOrder + 1, startPreOrder + distance, startInOrder,
					indexRootInOrder - 1);
		}
		if (indexRootInOrder < endInOrder) {
			root.right = buildTreeWithPreorderAndInorder(preorder, inorder,
					startPreOrder + distance + 1, endPreOrder,
					indexRootInOrder + 1, endInOrder);
		}

		return root;
	}
}
