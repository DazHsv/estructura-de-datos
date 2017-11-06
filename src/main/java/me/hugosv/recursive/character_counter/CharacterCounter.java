package me.hugosv.recursive.character_counter;

import java.util.Scanner;
import org.apache.log4j.Logger;
import me.hugosv.utils.Input;

public class CharacterCounter {
	
	private static final Logger logger = Logger.getLogger(CharacterCounter.class);
	
	public int find(String subject, String target, int from) {
		int foundAt = subject.indexOf(target, from);
		logger.debug(" - from: " + from);
		
		if(foundAt > 0) {
			logger.debug(" - foundAt: " + foundAt);
			return 1 + this.find(subject, target, foundAt + 1);			
		}
		return 0;
	}

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
