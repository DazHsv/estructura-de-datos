package me.hugosv.recursive.ulam;

import java.util.Scanner;

import me.hugosv.recursive.utils.Input;

/**
 * @author Hugo Sanchez Velazquez
 * @version 1.0.0
 */
public class Ulam {
	
	public static String recursive(int number) {
		return (number != 1 ? 
				number + " " + Ulam.recursive(
						( (number % 2) == 0 ? 
								(number / 2) : 
								(number * 3) + 1 ) ) : 
				number + " ");
	}
	
	public static String iterative(int number) {
		StringBuilder sb = new StringBuilder(number + " ");
		
		while( number != 1) {
			number = ( ( number % 2 ) == 0 ? ( number / 2 ) : ( number * 3 ) + 1 );
			sb.append(number + " ");
		}
		
		return sb.toString();
	}

	public static void main(String[] args) {
		Scanner s = Input.getInstance();
		
		System.out.print("Numero: ");
		int number = Integer.parseInt(s.nextLine());
		
		System.out.println("Recursivo: ");
		System.out.println( Ulam.recursive(number) );
		
		System.out.println("Iterativo: ");
		System.out.println( Ulam.iterative(number) );
		
		Input.close();
	}

}
