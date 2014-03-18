package leetcode.java;

public class UniqueBinarySearchTrees {

	/**
	 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

For example,
Given n = 3, there are a total of 5 unique BST's.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Solution095 {
    public int numTrees(int n) {
        if (n <= 0)
        	return 0;
        
        return numTrees(1, n);
    }

	int numTrees(int start, int end){
		if (start >= end)
			return 1;
		
		int num = 0;
		for (int i = start; i <= end; i++) {
			num = num + numTrees(start, i-1)*numTrees(i+1,end);
		}
		
		return num;
	}
	
}