package me.hugosv.recursive.russian_multiply;

import java.util.Scanner;
import me.hugosv.utils.Input;

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
		
		System.out.println("Recursivo: " + Russian.recursive(multiplier, multiplying));
		System.out.println("Iterativo: " + Russian.iterative(multiplier, multiplying));
		
		Input.close();
    }

	public static int recursive(int multiplier, int multiplying) {
		
		if( multiplier != 0 ) {
			if( multiplier % 2 != 0 )
				return multiplying + recursive( multiplier / 2, multiplying * 2);
			else
				return recursive( multiplier / 2, multiplying * 2);
		} else {
			return multiplier;
		}
	}
	
	public static int iterative(int multiplier, int multiplying) {
		int r = 0;
		while( multiplier != 0 ) {
			if(multiplier % 2 != 0)
				r += multiplying;
			
			multiplier /= 2;
			multiplying *= 2;
		}
		
		return r;
	}
}
