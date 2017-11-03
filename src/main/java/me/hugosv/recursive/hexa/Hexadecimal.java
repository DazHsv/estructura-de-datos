package me.hugosv.recursive.hexa;

import me.hugosv.utils.Input;

public class Hexadecimal {
	
	private final int DIVISOR = 16;
    
    private final String[] elements = {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};
    
    public String recursive(int number) {
    	System.out.println(number);
    	if(number > 16)
    		return this.elements[this.remainder(number / 16)] + this.elements[this.remainder(number)];
    	
    	return this.elements[number];
    }
    
    private int remainder(int number) {
    	int quotient = number / DIVISOR;
    	return number - (quotient * DIVISOR);
    }
    
    public static void main(String[] args) {
        System.out.print("Numero: ");
        System.out.println("Resultado: " + new Hexadecimal().recursive(Integer.parseInt(Input.getInstance().nextLine())));
    }
}
