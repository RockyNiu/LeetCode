package leetcode.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Utils {

	/**
	 * generate random int[] 1-n with input size n
	 * @param n, a int, the number of different numbers (0,1,2..n)
	 * @return int[], with random 0,1,2,3...,num
	 */
	public static int[] generateRandoms(int n){
		return generateRandomMatrix(1, n);
	}

	/**
	 * generate random int[] matrix
	 * @param n, a int, the repeated times
	 * @param num, a int, the number of numbers (0,1,2,3,... ,num)
	 * @return int[], with random 0,1,2,3...,num, each number repeated n times.
	 */
	public static int[] generateRandomMatrix(int n, int num){
		int[] A = new int[n*num];
		for (int i = 0; i < num; i++) {
			for (int j = 0; j < n; j++) {
				A[j+i*n] = i;
			}
		}
		Random r = new Random();
		for (int i = 0; i < A.length; i++) {
			int index1 = Math.abs(r.nextInt()) % A.length;
			int index2 = Math.abs(r.nextInt()) % A.length;
			if (index1 != index2){
				int temp = A[index1];
				A[index1] = A[index2];
				A[index2] = temp;
			}
		}
		return A;
	}
	
	public static ArrayList<Integer> readSystemInToIntArrayList() {
		ArrayList<Integer> array = new ArrayList<Integer>();

		Scanner sc = new Scanner(System.in);
		while (sc.hasNextInt()) {
			array.add(sc.nextInt());
		}
		sc.close();

		return array;
	}

	public static void print(int[] A){
		for (int i = 0; i < A.length; i++) {
			System.out.print(A[i]+"\t");
		}
		System.out.println();
	}

	public static void print(List A, String mode){
		for (int i = 0; i < A.size(); i++) {
			System.out.print(A.get(i)+mode);
		}
		System.out.println();
	}
	
	public static void print(List A){
		print(A, "\t");
	}

	public static int[] convertArrayListToArray(ArrayList<Integer> array){
		int[] A = new int[array.size()];
		for (int i = 0; i < A.length; i++) {
			A[i] = array.get(i);
		}
		return A;
	}

	public static int[] convertStringToArray(String str){
		int[] A = new int[str.length()];
		for (int i = 0; i < A.length; i++) {
			A[A.length - i - 1] = Integer.parseInt(str.substring(i,i+1));
		}
		return A;
	}

	public static ArrayList<Integer> convertStringToArrayList(String str){
		ArrayList<Integer> array = new ArrayList<Integer>();
		for (int i = str.length() - 1; i >= 0 ; i--) {
			array.add(Integer.parseInt(str.substring(i,i+1)));
		}
		return array;
	}
}
