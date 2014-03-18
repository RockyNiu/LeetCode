package leetcode.java;

public class SymmetricTree {

	/**
	 * Given a binary tree, check whether it is a mirror of itself (ie,
	 * symmetric around its center).
	 * 
	 * For example, this binary tree is symmetric:
	 * 
	 * 1 / \ 2 2 / \ / \ 3 4 4 3 But the following is not: 1 / \ 2 2 \ \ 3 3
	 * Note: Bonus points if you could solve it both recursively and
	 * iteratively.
	 * 
	 * confused what "{1,#,2,3}" means? > read more on how binary tree is
	 * serialized on OJ.
	 * 
	 * 
	 * OJ's Binary Tree Serialization: The serialization of a binary tree
	 * follows a level order traversal, where '#' signifies a path terminator
	 * where no node exists below.
	 * 
	 * Here's an example: 1 / \ 2 3 / 4 \ 5 The above binary tree is serialized
	 * as "{1,2,3,#,#,4,#,#,5}".
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
class Solution101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
        	return true;
        
        return (isSymmetric(root.left,root.right));
    }
    
    boolean isSymmetric(TreeNode left, TreeNode right){
    	if (left == null)
    		return (right == null);
    	
    	if (right == null)
    		return (left == null);
    	
    	if (left.val != right.val)
    		return false;
    	
    	return (isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left));
    }
}
