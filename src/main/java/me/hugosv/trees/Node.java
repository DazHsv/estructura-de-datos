package me.hugosv.trees;

public class Node<T> {
	private Node<T> right;
	private Node<T> left;
	private T value;
	
	public Node() {
		
	}
	
	public Node(T value) {
		super();
		this.value = value;
	}

	public T getValue() {
		return value;
	}
	
	public void setValue(T value) {
		this.value = value;
	}
	
	public Node<T> getRight() {
		return right;
	}
	
	public void setRight(Node<T> right) {
		this.right = right;
	}
	
	public Node<T> getLeft() {
		return left;
	}
	
	public void setLeft(Node<T> left) {
		this.left = left;
	}
	
	@Override
	public String toString() {
		return "Node [value=" + value + "]";
	}
}