package leetcode.java;

import java.util.ArrayList;
import java.util.Arrays;

/*Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
 * Find all unique triplets in the array which gives the sum of zero.

Note:
Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
The solution set must not contain duplicate triplets.
    For example, given array S = {-1 0 1 2 -1 -4},

    A solution set is:
    (-1, 0, 1)
    (-1, -1, 2)
*/
public class ThreeSum {
	public static void main(String[] args){
//		int[] num = {-9,-14,-3,2,0,-11,-5,11,5,-5,4,-4,5,-15,14,-8,-11,10,-6,1,-14,-12,-13,-11,9,-7,-2,-13,2,2,-15,1,3,-3,-12,-12,1,-2,6,14,0,-4,-13,-10,-12,8,-2,-8,3,-1,8,4,-6,2,1,10,2,14,4,12,1,4,-2,11,9,-7,6,-13,7,-3,8,14,8,10,12,11,-4,-13,10,14,1,-4,-4,2,5,4,-11,-7,3,8,-10,11,-11,-5,7,13,3,-2,8,-13,2,1,9,-12,-11,6};
//		int[] num = {-4, -2 ,-1};
//		int[] num = {0,0,0};
//		int[] num = {-1,0,1};
//		int[] num = {7,5,-8,-6,-13,7,10,1,1,-4,-14,0,-1,-10,1,-13,-4,6,-11,8,-6,0,0,-5,0,11,-9,8,2,-6,4,-14,6,4,-5,0,-12,12,-13,5,-6,10,-10,0,7,-2,-5,-12,12,-9,12,-9,6,-11,1,14,8,-1,7,-13,8,-11,-11,0,0,-1,-15,3,-11,9,-7,-10,4,-2,5,-4,12,7,-8,9,14,-11,7,5,-15,-15,-4,0,0,-11,3,-15,-15,7,0,0,13,-7,-12,9,9,-3,14,-1,2,5,2,-9,-3,1,7,-12,-3,-1,1,-2,0,12,5,7,8,-7,7,8,7,-15};
//		int[] num = {1,2,-2,-1};
//		int[] num = {3,0,-2,-1,1,2};
//		int[] num = {7,-1,14,-12,-8,7,2,-15,8,8,-8,-14,-4,-5,7,9,11,-4,-15,-6,1,-14,4,3,10,-5,2,1,6,11,2,-2,-5,-7,-6,2,-15,11,-6,8,-4,2,1,-1,4,-6,-15,1,5,-15,10,14,9,-8,-6,4,-6,11,12,-15,7,-1,-9,9,-1,0,-4,-1,-12,-2,14,-9,7,0,-3,-4,1,-2,12,14,-10,0,5,14,-1,14,3,8,10,-8,8,-5,-2,6,-11,12,13,-7,-12,8,6,-13,14,-2,-5,-11,1,3,-6};
		int[] num = {-1,0,1,2,-1,-4};
		Solution015 solution = new Solution015();
		ArrayList<ArrayList<Integer>> arrays = solution.threeSum(num);
		present(arrays);
	}
	
	static void present(ArrayList<ArrayList<Integer>> arrays){
		for (int i = 0; i < arrays.size(); i++) {
			System.out.print("\n{");
			for (int j = 0; j < arrays.get(i).size()-1; j++) {
				System.out.print(arrays.get(i).get(j)+",\t");
			}
			System.out.print(arrays.get(i).get(arrays.get(i).size()-1)+"}");
		}
	}
}

class Solution015{
	public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> arrays = new ArrayList<ArrayList<Integer>>();

        if (num.length < 3) 
        	return arrays;
		Arrays.sort(num); // sort
			
		//main loop
		for (int i = 0; i < num.length-2; i++) {
			int j = i+1;
			int k = num.length-1;
			while (j < k){
				if (num[i]+num[j]+num[k]<0)
					j++;
				else if (num[i]+num[j]+num[k]>0)
					k--;
				else {
					ArrayList<Integer> array = this.array2List(new int[]{num[i],num[j],num[k]});
					arrays.add(array);
					
					j++;
					while (j<k && num[j]==num[j-1])
						j++;
					
					k--;
					while (k>j && num[k]==num[k+1])
						k--;
				}
			}
			
			while (i+1<num.length-2 && num[i]==num[i+1])
				i++;
		}
		return arrays;
    }
	
	ArrayList<Integer> array2List(int[] nums){
		ArrayList<Integer> array = new ArrayList<Integer>();
		for (int i = 0; i < nums.length; i++) {
			array.add(nums[i]);
		}
		return array;
	}
}