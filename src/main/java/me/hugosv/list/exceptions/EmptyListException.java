package me.hugosv.list.exceptions;

/**
 *
 * @author Hugo Sanchez
 */
public class EmptyListException extends Exception {

	private static final long serialVersionUID = 6375721319178335352L;

	public EmptyListException() {
	}

	public EmptyListException(String message) {
		super(message);
	}

	public EmptyListException(String message, Throwable cause) {
		super(message, cause);
	}

	public EmptyListException(Throwable cause) {
		super(cause);
	}

}
