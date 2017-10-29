package me.hugosv.piles;

import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

public class Pila<T> {
	
	private Vector<T> stack;
	
	public Pila() {
		this.stack = new Vector<T>();
	}
	
	public void push(T item) {
		this.stack.addElement(item);
	}
	
	public void pop() throws EmptyStackException {
		if(this.isEmpty())
			throw new EmptyStackException();

		this.stack.remove(this.stack.size() - 1);
	}
	
	public boolean isEmpty() {
		return this.stack.isEmpty();
	}
}