package leetcode.java;

import java.util.Arrays;

/*There are two sorted arrays A and B of size m and n respectively. 
Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
*/
public class FindMedianSortedArrays {

	public static void main(String[] args) {
		int[] A = {1,1,2,2,3,3,4,4,5,5}, B = {3,5,6};
		Solution002 solution = new Solution002();
		double s = solution.findMedianSortedArrays(A, B);
		System.out.println(s);
	}

}

class Solution002 {
    public double findMedianSortedArrays(int[] A, int[] B) {
        int sizeA = A.length;
        int sizeB = B.length;
        if ((sizeA + sizeB)%2 == 1){
        	return getKth(A, B, (sizeA+sizeB+1)/2);
        }
        else{
        	return (getKth(A,B,(sizeA+sizeB)/2) + getKth(A,B,(sizeA+sizeB)/2+1))/2.0;
        }
    }
    
    double getKth(int[] a, int[] b, int k)  
    {  
    	int m = a.length;
    	int n = b.length;

    	if (n == 0)
    		return a[k-1];
        if (m == 0)  
            return b[k - 1];  
        if (k == 1)  
            return Math.min(a[0], b[0]);  
        
        //divide k into two parts  
        int p1 = Math.min(k / 2, m);
        int p2 = Math.min(k - p1,n);
        
        if (a[p1 - 1] < b[p2 - 1])  
            return getKth(Arrays.copyOfRange(a,p1,m), b, k - p1);  
        else if (a[p1 - 1] > b[p2 - 1])  
            return getKth(a,Arrays.copyOfRange(b,p2,n), k - p2);  
        else  
            return a[p1 - 1];  
        
    }  
}