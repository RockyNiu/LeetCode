package com.rockyniu.leetcode;

public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if ((int)1==(float)1)
			System.out.println(""+ 3/-2);

		String name = "ab.com";
		String[] splitName = name.split("@");
		System.out.println(splitName[0]);
		
		name = "Due 2014-04-11T16:41:00.000-04:00";
		System.out.println(Boolean.toString(name.matches("^Due .*")));
	}

}
