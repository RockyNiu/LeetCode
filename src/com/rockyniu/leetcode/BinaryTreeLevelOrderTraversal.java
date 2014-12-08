package com.rockyniu.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {

	/**
	 * Given a binary tree, return the level order traversal of its nodes' values. 
	 * (ie, from left to right, level by level).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
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
class Solution102 {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
    	ArrayList<ArrayList<Integer>> order = new ArrayList<ArrayList<Integer>>();
    	if (root == null)
    		return order;
    	
    	Queue<TreeNode> queue = new LinkedList<TreeNode>();
    	queue.offer(root);
    	int currentLevelCount = 0;
    	int nextLevelCount = 1;
    	
    	while (queue.size() > 0){
    		ArrayList<Integer> level = new ArrayList<Integer>();
    		currentLevelCount = nextLevelCount;
    		nextLevelCount = 0;
    		for (int i = 0; i < currentLevelCount; i++) {
				
    			TreeNode node = queue.poll();
				level.add(node.val);
				
				if (node.left != null){
					queue.offer(node.left);
					nextLevelCount++;
				}
				
				if (node.right != null){
					queue.offer(node.right);
					nextLevelCount++;
				}
    			
    		}
    		order.add(level);
    		level = new ArrayList<Integer>();    		
    	}
    	
    	
    	return order;
    }
}
