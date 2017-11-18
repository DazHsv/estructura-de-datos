package me.hugosv.list.ordered;

import me.hugosv.list.Node;

/**
 * A list where all its elements are ordered from minus to more when they are
 * added.
 *
 * @author Hugo Sanchez
 * @param <T> The type of elements inside this list, must implements the
 * {@link Comparable} interface for ordering.
 */
public class OrderedLinkedList<T extends Comparable<T>> {

	private Node<T> first;
	private int size;

	/**
	 * Add the given element to the list ordered it by its value.
	 *
	 * @param element The element to add.
	 * @return
	 */
	public boolean add(T element) {
		Node<T> n = new Node<T>(element);
		if (this.isEmpty()) {
			first = n;
		} else {
			orderedInsert(n);
		}

		size++;
		return true;
	}

	/**
	 * Removes the value at the given index.
	 *
	 * @param index A {@link Integer} that represents the position of the value
	 * in the list.
	 * @return The value removed from the list.
	 */
	public T remove(int index) {
		verifyIndex(index);
		size--;
		return remove(find(index));
	}

	/**
	 * Get the node at the given index.
	 *
	 * @param index A {@link Integer} that represents the position of the value
	 * in the list.
	 * @return The value on the given position.
	 */
	public T get(int index) {
		verifyIndex(index);
		return find(index).getValue();
	}

	/**
	 * Updates the value on the given position.
	 *
	 * @param index The index of the value to edit.
	 * @param element The new value for the index.
	 * @return The new value for the index.
	 */
	public T set(int index, T element) {
		if (isEmpty() || index > size || index < 0) {
			throw new IndexOutOfBoundsException("Index " + index + " is out of the list limits.");
		}
		return set(find(index), element);
	}

	/**
	 * Gets the amount of elements on this list.
	 *
	 * @return A {@link Integer} with the total elements count in this list.
	 */
	public int size() {
		return this.size;
	}

	/**
	 * Whenever the list has elements on it.
	 *
	 * @return True if the list has at least 1 element on it, false otherwise.
	 */
	public boolean isEmpty() {
		return this.first == null;
	}

	/**
	 * Ereases the contents of this list.
	 */
	public void clear() {
		this.first = null;
		this.size = 0;
	}

	private void verifyIndex(int index) {
		if (isEmpty() || index > size || index < 0) {
			throw new IndexOutOfBoundsException("Index " + index + " is out of the list limits.");
		}
	}

	/**
	 * Return the node at the given index.
	 *
	 * @param index A {@link Integer} that represents the position of the node
	 * in the list.
	 * @return The {@link Node} at the given position.
	 */
	private Node<T> find(int index) {
		Node<T> control = this.first;
		while ((index--) != 0 && control.hasNext()) {
			control = control.getNext();
		}
		return control;
	}

	/**
	 * Remove the nodes references to the given node.
	 *
	 * @param n The {@link Node} to be removed.
	 * @return The value of the removed node.
	 */
	private T remove(Node<T> n) {
		T value = n.getValue();
		Node prev = n.getPrev();
		Node next = n.getNext();
		if (prev != null && next == null) {
			prev.setNext(null);
		} else if (prev == null && next != null) {
			this.first = next;
			next.setPrev(null);
		} else {
			this.first = null;
		}
		return value;
	}

	/**
	 * Set the given value to the given {@link Node}.
	 *
	 * @param n The {@link Node} to be updated.
	 * @param value The new value.
	 * @return The value that was set.
	 */
	private T set(Node<T> n, T value) {
		n.setValue(value);
		return value;
	}

	/**
	 * Insert the given {@link Node} in the list, secuentially sorted by its
	 * value.
	 *
	 * @param n The {@link Node} to be sorted.
	 */
	private void orderedInsert(Node<T> n) {
		Node<T> control = this.first;
		T target = n.getValue();
		do {
			T current = control.getValue();
			int result = target.compareTo(current);
			if (result > 0) { // If new node is greater than current node
				if (control.hasNext()) { // If current node is not last one
					control = control.getNext(); // Eval next node
				} else { // If current node is last one
					this.insertAfter(control, n); // Set new node as last one
					break;
				}
			} else if (result < 0) { // If new node is less than current node
				this.insertBefore(control, n);
				break;
			} else { // If is equal, add getNext to.
				this.insertAfter(control, n);
				break;
			}
		} while (true);
	}

	/**
	 * Insert a {@link Node} after the current one.
	 *
	 * @param current The current {@link Node}.
	 * @param next The {@link Node} to be inserted after the current one.
	 */
	private void insertAfter(Node<T> current, Node<T> next) {
		if (current.hasNext()) {
			current.getNext().setPrev(next);
			next.setNext(current.getNext());
		}
		current.setNext(next);
		next.setPrev(current);
	}

	/**
	 * Insert a {@link Node} before the current one.
	 *
	 * @param current The current {@link Node}.
	 * @param prev The {@link Node} to be inserted before the current one.
	 */
	private void insertBefore(Node<T> current, Node<T> prev) {
		if (current.hasPrev()) {
			current.getPrev().setNext(prev);
			prev.setPrev(current.getPrev());
		} else {
			this.first = prev;
		}
		current.setPrev(prev);
		prev.setNext(current);
	}
}
