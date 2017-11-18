package me.hugosv.recursive.character_counter;

import org.apache.log4j.Logger;

/**
 * Recursive characters counter.
 * 
 * @author Hugo Sanchez V
 * @version 1.0.0
 * @since CharacterCounter 1.0.0
 */
public class CharacterCounter {
	
	private static final Logger logger = Logger.getLogger(CharacterCounter.class);
	
	public int find(String subject, String target, int from) {
		int foundAt = subject.indexOf(target, from);
		logger.debug(" - from: " + from);
		
		if(foundAt >= 0) {
			logger.debug(" - foundAt: " + foundAt);
			return 1 + this.find(subject, target, foundAt + 1);			
		}
		return 0;
	}
}
