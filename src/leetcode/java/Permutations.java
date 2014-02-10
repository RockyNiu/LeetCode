package leetcode.java;

import java.util.ArrayList;

/*
 * Given a collection of numbers, return all possible permutations.

 For example,
 [1,2,3] have the following permutations:
 [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 */
public class Permutations {

	public static void main(String[] args) {
		int[] num = new int[] { 1, 2, 3 };
		Solution045 solution = new Solution045();
		ArrayList<ArrayList<Integer>> permutation = solution.permute(num);
		for (int i = 0; i < permutation.size(); i++) {
			System.out.print('[');
			ArrayList<Integer> p = permutation.get(i);
			for (int j = 0; j < p.size(); j++) {
				if (j == p.size() - 1)
					System.out.println(p.get(j).toString() + ']');
				else
					System.out.print(p.get(j).toString() + ',');
			}
		}

	}

}

class Solution045 {
	public ArrayList<ArrayList<Integer>> permute(int[] num) {
		ArrayList<ArrayList<Integer>> permutation = new ArrayList<ArrayList<Integer>>();
		int[] pre = new int[0];
		permutation = permuteUnit(num, pre, num, permutation);
		return permutation;
	}

	ArrayList<ArrayList<Integer>> permuteUnit(int[] num, int[] pre, int[] post,
			ArrayList<ArrayList<Integer>> permutation) {

		// base case
		if (pre.length == num.length) {
			ArrayList<Integer> unit = new ArrayList<Integer>();
			for (int i = 0; i < pre.length; i++) {
				unit.add(pre[i]);
			}
			permutation.add(unit);
			return permutation;
		}
		int index = pre.length;
		for (int i = 0; i < post.length; i++) {
			// update pre
			int[] currentPre = new int[index + 1];
			for (int j = 0; j < index; j++) {
				currentPre[j] = pre[j];
			}
			currentPre[index] = post[i];

			// update post
			int[] currentPost = new int[post.length - 1];
			int j = 0;
			while (j != i) {
				currentPost[j] = post[j];
				j++;
			}
			while (j < currentPost.length) {
				currentPost[j] = post[j + 1];
				j++;
			}

			permuteUnit(num, currentPre, currentPost, permutation);
		}
		return permutation;
	}
}