package me.hugosv.recursive.reverse;

import java.util.Scanner;
import me.hugosv.utils.Input;

public class ReverseNumber {
	private static void recursive(int number) {
		if(number < 10)
			System.out.print(number);
		else {
			System.out.print(number % 10);
			recursive(number / 10);
		}
			
	}
	
	private static int iterative(int number) {
		int r = 0;
		
		while(number != 0) {
			r *= 10;
			r += (number % 10);
			number /= 10;
		}
		
		return r;
	}
	
	public static void main(String[] args) {
		
		Scanner s = Input.getInstance();
		
		System.out.print("Numero: ");
		int number = Integer.parseInt(s.nextLine());
		
		System.out.println("Iterative: " + iterative(number));
		System.out.print("Recursive: ");
		recursive(number);
		
		s.close();
	}
}
