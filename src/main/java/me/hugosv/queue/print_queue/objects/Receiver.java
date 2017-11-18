package me.hugosv.queue.print_queue.objects;

/**
 * All implementing classes will have the ability of receiving objects to work with.
 * 
 * @author Hugo Sanchez V
 *
 * @param <E> The type of the payload that the implementing class will handle.
 */
public interface Receiver<E> {
	
	/**
	 * 
	 * @param payload The payload that the implement class will receive.
	 */
	void receive(E payload);
}
