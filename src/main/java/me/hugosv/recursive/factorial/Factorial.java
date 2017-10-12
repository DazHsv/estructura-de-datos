package me.hugosv.recursive.factorial;


import java.util.Scanner;

import me.hugosv.recursive.utils.Input;

/**
 * @author Hugo Sanchez Velazquez
 * @version 1.0.0
 */
public class Factorial {
	public static long recursive(int n) {
		if(n != 0)
			return n * recursive(n - 1);
		else
			return 1;
	}
	
	public static long iterative(int n) {
		long f = 1;
		
		do {
//			System.out.println(n);
			f *= n;
		} while( (--n) > 0 );
		
		return f;
	}
	
	public static void main(String[] args) {
		Scanner s = Input.getInstance();
		
		System.out.print("Number: ");
		int n = Integer.parseInt(s.nextLine());
		
		System.out.println("Rescursive: " + Factorial.recursive(n));
		System.out.println("Iterative: " + Factorial.iterative(n));
		
		Input.close();
	}
}
