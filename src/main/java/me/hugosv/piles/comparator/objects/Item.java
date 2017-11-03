package me.hugosv.piles.comparator.objects;


public class Item<T> {
	private T value;
	private int depth;
	
	public T getValue() {
		return value;
	}
	
	public void setValue(T value) {
		this.value = value;
	}
	
	public int getDepth() {
		return depth;
	}
	
	public void setDepth(int depth) {
		this.depth = depth;
	}
	
	@Override
	public String toString() {
		return new StringBuilder()
				.append("{ value=")
				.append(this.value)
				.append(", depth=")
				.append(this.depth)
				.append(" }")
				.toString();
	}
}
