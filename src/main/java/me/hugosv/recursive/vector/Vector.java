package me.hugosv.recursive.vector;

import java.util.Scanner;
import me.hugosv.recursive.utils.Input;

public class Vector {
    
    public int recursive(int position, int[] vector) {
        if(position < vector.length)
            return vector[position] + this.recursive(position + 1, vector);
        else
            return 0;
    }
    
    public static void main(String[] args) {
        Scanner s = Input.getInstance();
        
        System.out.print("Tamaño del vector: ");
        int length = Integer.parseInt(s.nextLine());
        
        int[] vector = new int[length];
        
        for(int i = 0; i < length; i++) {
            System.out.print("Valor para posicion [" + i + "]: ");
            vector[i] = Integer.parseInt(s.nextLine());
        }
        
        Vector v = new Vector();
        
        System.out.println("Resultado: " + v.recursive(0, vector));
        
        s.close();
    }
}
