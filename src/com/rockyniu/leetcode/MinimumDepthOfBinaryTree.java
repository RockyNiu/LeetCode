package com.rockyniu.leetcode;

public class MinimumDepthOfBinaryTree {
	/*
	 * Given a binary tree, find its minimum depth.
	 * 
	 * The minimum depth is the number of nodes along the shortest path from the
	 * root node down to the nearest leaf node.
	 */
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

class Solution111{
    public int minDepth(TreeNode root) {
    	if (root == null)
    		return 0;
    	if (root.left == null)
    		return  minDepth(root.right) + 1;
    	if (root.right == null)
    		return minDepth(root.left) + 1;    	
    	
        int leftDepth = minDepth(root.left) + 1;
        int rightDepth = minDepth(root.right) + 1;
    	if (leftDepth < rightDepth)
    		return leftDepth;
    	else
    		return rightDepth;   	
    	
    }		
}