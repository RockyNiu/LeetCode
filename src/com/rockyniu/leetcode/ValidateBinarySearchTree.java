package com.rockyniu.leetcode;

public class ValidateBinarySearchTree {

	/**
	 * Given a binary tree, determine if it is a valid binary search tree (BST).
	 * 
	 * Assume a BST is defined as follows:
	 * 
	 * The left subtree of a node contains only nodes with keys less than the
	 * node's key. The right subtree of a node contains only nodes with keys
	 * greater than the node's key. Both the left and right subtrees must also
	 * be binary search trees.
	 */
	public static void main(String[] args) {

	}

}

class Solution098{
	/**
	 * Definition for binary tree
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    boolean isValidBST(TreeNode root, int min, int max){
    	if (root == null)
    		return true;
    	
    	if (root.val > min && root.val < max && isValidBST(root.left, min, root.val)
    			&& isValidBST(root.right, root.val, max))
    		return true;

    	return false;
    }
}