package leetcode.java;

public class RecoverBinarySearchTree {

	/**
	 * Two elements of a binary search tree (BST) are swapped by mistake.
	 * 
	 * Recover the tree without changing its structure.
	 * 
	 * Note: A solution using O(n) space is pretty straight forward. Could you
	 * devise a constant space solution?
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
class Solution099 {
	// using Threaded Binary Tree to get O(1) solution
    public void recoverTree(TreeNode root) {
        if (root == null)
        	return;
        
        TreeNode pre = null; // inorder predecessor
        TreeNode parent = null; // parents node
        TreeNode current = root; // current node
        TreeNode node1 = null; // mistake node 1
        TreeNode node2 = null; // mistate node 2
        boolean found = false; // mistakenode1 is found
        
        while (current != null){
        	
        	if (current.left == null){
        		
        		// found mistakes
        		if (parent!=null && parent.val > current.val){
        			if (!found){
        				node1 = parent;
        				found = true;
        			}
        			node2 = current;
        		}
        		parent = current;
    			current = current.right;
        	}	
    		else{
    			
    			// find the inorder predecessor of current
    			pre = current.left;
    			while (pre.right!=null && pre.right != current){
    				pre = pre.right;
    			}
    			
    			// make current is the right child of its inorder predecessor
    			if (pre.right == null){
    				pre.right = current;
    				current = current.left;   				
    			}
    			else{
    				pre.right = null;
    				// found mistakes
            		if (parent!=null && parent.val > current.val){
            			if (!found){
            				node1 = parent;
            				found = true;
            			}
            			node2 = current;
            		}
            		parent = current;
        			current = current.right;
    			}
        		
        	}	
        }
        if (node1!=null && node2!=null){
        	int temp = node1.val;
        	node1.val = node2.val;
        	node2.val = temp;
        }
        return;
    }
}