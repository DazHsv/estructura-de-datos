package me.hugosv.recursive.russian_multiply;

import java.util.Scanner;

import me.hugosv.recursive.utils.Input;

/**
 * @author Hugo Sanchez Velazquez
 * @version 1.0.0
 */
public class Russian {
	
	public static void main( String[] args ) {
		Scanner s = Input.getInstance();
		
		System.out.print("Multiplicador: ");
		int multiplier = Integer.parseInt(s.nextLine());
		System.out.print("Multiplicando: ");
		int multiplying = Integer.parseInt(s.nextLine());
		
		System.out.print("Recursivo: ");
		Russian.recursive(multiplier, multiplying, 0);
		System.out.print("Iterativo: ");
		Russian.iterative(multiplier, multiplying);
		
		Input.close();
    }

	public static void recursive(int multiplier, int multiplying, int result) {
//		System.out.println(multiplier);
//		System.out.println(multiplying);
//		System.out.println(result);
//		System.out.println("---");
		
		if( multiplier != 0 ) {
			if( multiplier % 2 != 0 )
				recursive( multiplier / 2, multiplying * 2, multiplying + result );
			else
				recursive( multiplier / 2, multiplying * 2, result );
		} else {
			System.out.println( result );
		}
	}
	
	public static void iterative(int multiplier, int multiplying) {
		int r = 0;
		while( multiplier != 0 ) {
			if(multiplier % 2 != 0)
				r += multiplying;
			
			multiplier /= 2;
			multiplying *= 2;
		}
		
		System.out.println(r);
	}
}
