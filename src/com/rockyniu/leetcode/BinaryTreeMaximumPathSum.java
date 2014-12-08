package com.rockyniu.leetcode;

public class BinaryTreeMaximumPathSum {

	/**
	 * Given a binary tree, find the maximum path sum.

The path may start and end at any node in the tree.

For example:
Given the below binary tree,

       1
      / \
     2   3
Return 6.
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
class Solution124 {
    public int maxPathSum(TreeNode root) {
    	
    	int[] max = {Integer.MIN_VALUE};
    	maxPathToRoot(root, max);
    	return max[0];
    	
    } 
    
    int maxPathToRoot(TreeNode root, int[] max){
    	if (root == null)
    		return 0;
    	
    	int leftNum = maxPathToRoot(root.left, max);
    	int rightNum = maxPathToRoot(root.right, max);
    	int arch = leftNum + root.val + rightNum;
    	
    	int rootNum = Math.max(root.val, Math.max(leftNum, rightNum)+root.val);
    	max[0] = Math.max(max[0], Math.max(arch, rootNum));
    	return rootNum;    	
    }
}