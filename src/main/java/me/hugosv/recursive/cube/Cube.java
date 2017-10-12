package me.hugosv.recursive.cube;

import java.util.Scanner;

import me.hugosv.recursive.utils.Input;

public class Cube {
	public static String recursive(int limit) {
		return (limit > 0 ? cube(limit) + " " + recursive(limit - 1) : "");
	}
	
	public static String iterative(int limit) {
		StringBuilder c = new StringBuilder( cube(limit)  + " " );
		
		while( (--limit) > 0 ) c.append( cube(limit) + " ");
		
		return c.toString();
	}
	
	private static double cube(int n) {
		return Math.pow(n, 3);
	}
	
	public static void main(String[] args) {
		Scanner s = Input.getInstance();
		
		System.out.print("Limite: ");
		int limit = Integer.parseInt(s.nextLine());
		
		System.out.println("Recursive: " + recursive(limit));
		System.out.println("Iterative: " + iterative(limit));
		
		Input.close();
	}
}