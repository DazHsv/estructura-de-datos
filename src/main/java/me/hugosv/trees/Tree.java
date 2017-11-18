package me.hugosv.trees;

import org.apache.log4j.Logger;

public class Tree<T extends Comparable<T>> {
	
	private Node<T> root;
	
	private static final Logger logger = Logger.getLogger(Tree.class);
	
	public Tree() {
		this.root = null;
	}
	
	private void insertImpl(T value, Node<T> rec) throws Exception {
		if(rec.getValue().equals(value)) {
			throw new Exception("Value already inserted.");
		}
		
		if(rec.getValue().compareTo(value) < 0) { // el valor se inserta a la derecha
			if(rec.getRight() == null) {
				rec.setRight(new Node<T>(value));
				logger.info("Inserted on right.");
			} else {
				this.insertImpl(value, rec.getRight());
			}
		} else { // el valor se inserta a la izquierda
			if(rec.getLeft() == null) {
				rec.setLeft(new Node<T>(value));
				logger.info("Inserted on left.");
			} else {
				this.insertImpl(value, rec.getLeft());
			}
		}
	}
	
	public boolean insert(T value, Node<T> rec) {
		if(this.isEmpty()) {
			this.root = new Node<T>(value);
		} else {
			try {
				this.insertImpl(value, rec);
			} catch (Exception e) {
				return false;
			}
		}
		
		return true;
	}
	
	public void remove(Integer value) {
		if(this.root.getValue().equals(value)) {
			if(!hasChilds(root)) {
				this.root = null;
			} else {
				
			}
		}
	}
	
	public boolean isEmpty() {
		return this.root == null;
	}
	
	private boolean hasChilds(Node<T> node) {
		return (node.getLeft() != null || node.getRight() != null);
	}
}
