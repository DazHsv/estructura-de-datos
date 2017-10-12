package me.hugosv.recursive.fibonacci;

import java.util.Scanner;

import me.hugosv.recursive.utils.Input;

public class Fibonacci {
	public static String recursive(int a, int b, int limit) {
		return (limit > 0 ? a + " " + recursive(b, a + b, limit - 1) : a + " ");
	}
	
	public static String iterative(int a, int b, int limit) {
		StringBuilder f = new StringBuilder(a);
		
		while( limit >= 0 ) {
//			System.out.println(limit + " " + a);
			f.append(a + " ");
			int temp = b;
			b = a + b;
			a = temp;
			limit--;
		}
		
		return f.toString();
	}
	
	public static void main(String[] args) {
		Scanner s = Input.getInstance();
		
		System.out.print("Limit: ");
		int limit = Integer.parseInt(s.nextLine());
		
		System.out.println("Recursive: " + Fibonacci.recursive(1, 1, limit));
		System.out.println("Iterative: " + Fibonacci.iterative(1, 1, limit));
		
		Input.close();
	}
}
