package me.hugosv.olympic_administrator.vo;

/**
 * Holds a value.
 * Specific use for lambda expressions.
 * @author Hugo Sanchez
 * @param <T> The type of the holded value.
 */
public class Holder<T> {
	private T value;

	public Holder() {
	}

	public Holder(T value) {
		this.value = value;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}
	
}
