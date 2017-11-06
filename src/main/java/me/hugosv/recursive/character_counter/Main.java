package me.hugosv.recursive.character_counter;

import java.util.Scanner;
import org.apache.log4j.Logger;
import me.hugosv.utils.Input;

/**
 * 
 * @author Hugo Sanchez V
 * @version 1.0.0
 * @since CharacterCounter 1.0.0
 */
public class Main {
	
	private static final Logger logger = Logger.getLogger(Main.class);
	
	public static void main(String[] args) {
		logger.info("METHOD: Starting method - main");
		CharacterCounter characterCounter = new CharacterCounter();
		Scanner s = Input.getInstance();
		
		System.out.print("Cadena para probar: ");
		String subject = s.nextLine();
		
		System.out.print("Cadena a buscar(multiples separadas por coma): ");
		String targets = s.nextLine();
		
		logger.info("METHOD: Starting method - find");
		for (String target : targets.split(",")) {
			System.out.format("Ocurrencias de %s: %d%n", target, characterCounter.find(subject, target, 0));			
		}
		logger.info("METHOD: Ending find method");
		
		if(s != null)
			s.close();
		
		logger.info("METHOD: Ending method - main");
	}
}
