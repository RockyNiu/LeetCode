package leetcode.java;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * Given a collection of numbers, return all possible permutations.

 For example,
 [1,2,3] have the following permutations:
 [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 */
public class Permutations {

	public static void main(String[] args) {
		int[] num = new int[] { 1, 2, 3 };
		Solution045_2 solution = new Solution045_2();
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

// Albert Chen's solution
class Solution045_2 {
	public ArrayList<ArrayList<Integer>> permute(int[] num) {
		ArrayList<ArrayList<Integer>> permutations = new ArrayList<ArrayList<Integer>>();
		if (num.length == 0)
			return permutations;

		Arrays.sort(num);
		do {
			ArrayList<Integer> unit = getList(num);
			permutations.add(unit);
		} while (nextPermutation(num));

		return permutations;
	}

	boolean nextPermutation(int[] num) {
		for (int i = num.length - 1; i > 0; i--) {
			if (num[i - 1] < num[i]) {
				for (int j = num.length - 1; j >= i; j--) {
					if (num[i - 1] < num[j]) {
						swap(num, i - 1, j);
						reverse(num, i, num.length - 1);
						return true;
					}
				}
			}
		}
		reverse(num, 0, num.length - 1);
		return false;
	}

	ArrayList<Integer> getList(int[] num) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < num.length; i++)
			list.add(num[i]);
		return list;
	}

	void swap(int[] num, int n1, int n2) {
		int temp = num[n1];
		num[n1] = num[n2];
		num[n2] = temp;
	}

	void reverse(int[] num, int n1, int n2) {
		for (int i = n1; i <= n1 + (n2 - n1) / 2; i++) {
			swap(num, i, n2 + n1 - i);
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