package me.hugosv.olympic_administrator.filters;

/**
 * Evaluates an object to be filtered in a query.
 *
 * @author Hugo Sanchez
 * @param <T> The type of the object to be evaluated.
 */
public interface Filter<T> {

	/**
	 * Evaluate each object and return whenever it passes the filter.
	 *
	 * @param current The current object being evaluated.
	 * @return {@code true} if the object passes the filter, {@code false}
	 * otherwise.
	 */
	boolean accept(T current);
}
