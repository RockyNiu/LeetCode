package com.rockyniu.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.

 For example,
 [1,1,2] have the following unique permutations:
 [1,1,2], [1,2,1], and [2,1,1].
 */
public class PermutationsII {

	public static void main(String[] args) {
		int[] num = new int[] { 1, 1, 2 };
		Solution046_2 solution = new Solution046_2();
		List<List<Integer>> permutation = solution.permute(num);
		for (int i = 0; i < permutation.size(); i++) {
			System.out.print('[');
			List<Integer> p = permutation.get(i);
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
class Solution046_2 {
	public List<List<Integer>> permute(int[] num) {
		List<List<Integer>> permutations = new ArrayList<List<Integer>>();
		if (num.length == 0)
			return permutations;

		Arrays.sort(num);
		do {
			List<Integer> unit = getList(num);
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

	List<Integer> getList(int[] num) {
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

class Solution046 {
	public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
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
		int indexPre = pre.length;
		int[] used = new int[post.length];
		int usedIndex = 0;
		for (int i = 0; i < post.length; i++) {
			int flag = 1;
			// update used
			for (int j = 0; j < usedIndex; j++) {
				if (post[i] == used[j]) {
					flag = -1;
					break;
				}
			}

			if (flag == 1) {
				used[usedIndex] = post[i];
				usedIndex++;
				
				// update pre
				int[] currentPre = new int[indexPre + 1];
				for (int j = 0; j < indexPre; j++) {
					currentPre[j] = pre[j];
				}
				currentPre[indexPre] = used[usedIndex-1];

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
		}
		return permutation;
	}
}