package leetcode.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Utils {

	// generate random int[] 1-n with input size n
	public static int[] generateRandoms(int n){
		int[] result = new int[n];
		for (int i = 0; i < result.length; i++) {
			result[i] = i+1;
		}
		Random r = new Random();
		for (int i = 0; i < n; i++) {
			int index1 = Math.abs(r.nextInt()) % n;
			int index2 = Math.abs(r.nextInt()) % n;
			if (index1 != index2){
				int temp = result[index1];
				result[index1] = result[index2];
				result[index2] = temp;
			}
		}
		return result;
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
