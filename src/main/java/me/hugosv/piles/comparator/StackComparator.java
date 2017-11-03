package me.hugosv.piles.comparator;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import org.apache.log4j.Logger;
import me.hugosv.piles.comparator.objects.ComparatorResult;
import me.hugosv.piles.comparator.objects.Item;

public class StackComparator<T> {

	private static Logger logger = Logger.getLogger(StackComparator.class);
	private int size;

	private StackComparator() {
	}

	public ComparatorResult compare(List<Stack<T>> stacks) {
		logger.info("METHOD: Starting - compare");
		for (int i = 0; i < stacks.size(); i++) {
			logger.trace(" - stack[" + i + "]: " + stacks.get(i));
		}
		ComparatorResult result = new ComparatorResult();
		result.setPassed(true);
		result.setMessage("Stacks are equals.");
		if (!sizeEquals(stacks)) {
			result.setPassed(false);
			result.setMessage("Size is not equal.");
			logger.warn(result.getMessage());
			logger.info("METHOD: Ending - compare: " + result.getPassed());
			return result;
		}
		this.size = stacks.get(0).size();
		logger.debug(" - size: " + this.size);
		List<List<Item<T>>> list_stack = new ArrayList<List<Item<T>>>();
		for (Stack<T> stack : stacks) {
			list_stack.add(toList(stack));
		}
		for (int i = 0; i < this.size; i++) {
			logger.trace(" -- i: " + i);
			if (!equals(i, list_stack)) {
				result.setPassed(false);
				result.setMessage("Item not equal on both stacks.");
				logger.warn(result.getMessage());
				logger.info("METHOD: Ending - compare: " + result.getPassed());
				return result;
			}
		}
		logger.info("METHOD: Ending - compare: " + result.getPassed());
		return result;
	}

	private boolean equals(int depth, List<List<Item<T>>> lists) {
		logger.debug("METHOD: Starting - equals");
		T target = lists.get(0).get(depth).getValue();
		logger.trace(" - target: " + target);
		for (int i = 1; i < lists.size(); i++) {
			List<Item<T>> current_list = lists.get(i);
			T value = current_list.get(depth).getValue();
			logger.trace(" -- value: " + value);
			if (!value.equals(target))
				return false;
		}
		return true;
	}

	private List<Item<T>> toList(Stack<T> stack) {
		logger.debug("METHOD: Starting - toList");
		List<Item<T>> list = new ArrayList<Item<T>>();
		logger.trace(" - stack: " + stack);
		for (int i = 0; i < stack.size(); i++) {
			Item<T> item = new Item<T>();
			T value = stack.get(i);
			logger.trace(" -- value: " + value);
			Integer depth = (this.size - stack.indexOf(value));
			logger.trace(" -- depth: " + depth);
			item.setDepth(depth);
			item.setValue(value);
			logger.debug(" -- item: " + item);
			list.add(item);
		}
		logger.debug("METHOD: Ending - toList");
		return list;
	}

	private boolean sizeEquals(List<Stack<T>> stacks) {
		Integer size = stacks.get(0).size();
		for (Stack<T> stack : stacks) {
			if (stack.size() != size)
				return false;
		}
		return true;
	}

	public static <T> StackComparator<T> getInstance() {
		return new StackComparator<T>();
	}
}
