package leetcode.java;

import java.util.Arrays;

/*Given an array S of n integers, find three integers in S such that the sum is closest to 
 * a given number, target. Return the sum of the three integers. You may assume that each 
 * input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
*/
public class ThreeSumClosest {
	public static void main(String[] args){
		int[] num = {-1, 2, 1, -4};
		int target = 1;
		Solution016 solution = new Solution016();
		System.out.println("sum:"+solution.threeSumClosest(num, target));
	}
}

class Solution016{
	public int threeSumClosest(int[] num, int target){
		int closest = num[0]+num[1]+num[2];
		for (int i = 0; i < num.length-2; i++) {
			for (int j = i+1; j < num.length-1; j++) {
				for (int k = j+1; k < num.length; k++) {
					int temp = num[i]+num[j]+num[k];
					
					if (temp == target)
						return target;
					
					if (Math.abs(temp - target) < Math.abs(closest - target))
						closest = temp;
				}
			}
		}
		
		return closest;
	}
}


class Solution016_1{
    public int threeSumClosest(int[] num, int target) {
    	assert num.length > 2:"the number of integers < 3!";
    	
    	if (num.length == 3)
    		return num[0]+num[1]+num[2];
    	
        Arrays.sort(num);    
        
        if (num[0] >= target) 
        	return num[0]+num[1]+num[2];
        
        if (num[num.length-1] <= target)
        	return num[num.length-1]+num[num.length-2]+num[num.length-3];
        
        int index = 0; // target at [num[pre],num[post]]
        while (num[index] < target){
        	index++;
        }
        
        int pre = index - 1;
        int post = index;
        int count = 0;
        int[] indexes = new int[]{-1,-1,-1};
        
        while (count < 3){
        	if (pre == 0){
        		for (int i = 0; i < indexes.length; i++) {
					if (indexes[i]==-1){
						indexes[i] = post;
						post++;
					}
				}
        		break;
        	}
        	
        	if (post == num.length){
        		for (int i = 0; i < indexes.length; i++) {
					if (indexes[i]==-1){
						indexes[i] = pre;
						pre--;
					}
        		}
        		break;
			}
        	
        	if (Math.abs(num[pre]-target) > Math.abs(num[post]-target)){
	        		indexes[count] = post;
					post ++;
	        		count ++;
        	} 
        	else {
        		indexes[count] = pre;
        		pre --;
        		count ++;
        	}
        }
        
        return num[indexes[0]]+num[indexes[1]]+num[indexes[2]];
    }
}