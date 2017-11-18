package me.hugosv.list;

/**
* A double referenced list Node.
*
* @author Hugo Sanchez
* @param <T> The type of the node's value.
*/
public class Node<T> {

   private T value;
   private Node<T> next, prev;

   public Node(T value) {
	   this.value = value;
   }

   public T getValue() {
	   return value;
   }

   public void setValue(T value) {
	   this.value = value;
   }

   public Node<T> getNext() {
	   return next;
   }

   public void setNext(Node<T> next) {
	   this.next = next;
   }

   public Node<T> getPrev() {
	   return prev;
   }

   public void setPrev(Node<T> prev) {
	   this.prev = prev;
   }

   public boolean hasNext() {
	   return this.next != null;
   }

   public boolean hasPrev() {
	   return this.prev != null;
   }

   @Override
   public String toString() {
	   return new StringBuilder()
		   .append("Node[ ")
		   .append("value=")
		   .append(this.value)
		   .append(", prev=")
		   .append(this.prev.getValue())
		   .append(", next=")
		   .append(this.next.getValue())
		   .append(" ]")
		   .toString();
   }

   public String toString(boolean showNodes) {
	   return new StringBuilder()
		   .append("Node[ ")
		   .append("value=")
		   .append(this.value)
		   .append(", prev=")
		   .append(this.prev)
		   .append(", next=")
		   .append(this.next)
		   .append(" ]")
		   .toString();
   }

}
