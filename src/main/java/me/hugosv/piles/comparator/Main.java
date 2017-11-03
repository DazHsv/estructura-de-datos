package me.hugosv.piles.comparator;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import org.apache.log4j.Logger;
import me.hugosv.piles.comparator.objects.ComparatorResult;
import me.hugosv.utils.Input;

public class Main {
	
	private static final Logger logger = Logger.getLogger(Main.class);

	public static void main(String[] args) {
		Main main = new Main();
		main.init();
	}

	public void init() {
		logger.debug("METHOD: Starting - init");
		final StackComparator<String> comparator = StackComparator.getInstance();
		final Scanner s = Input.getInstance();
		
		System.out.print("How many stacks? (default: 2): ");
		String stackQuantityStr = s.nextLine();
		if (stackQuantityStr == null || stackQuantityStr.equals(""))
			stackQuantityStr = "2";
		logger.debug(" - stackQuantityStr: " + stackQuantityStr);
		Integer stackQuantity = Integer.parseInt(stackQuantityStr);
		
		final List<Stack<String>> list_stacks = new ArrayList<Stack<String>>(stackQuantity);
		for (int i = 0; i < stackQuantity; i++) {
			list_stacks.add(new Stack<String>());
		}
		
		while (true) {
			logger.debug("\n" + printList(list_stacks));
			System.out.println(listAvailableStacks(stackQuantity));
			System.out.print("Stack index to push (type -1 to continue): ");
			String opt = s.nextLine();
			logger.debug(" -- opt: " + opt);
			if(opt.equals("-1"))
				break;
			Integer stack = Integer.parseInt(opt);
			try {
				Stack<String> current_stack = list_stacks.get(stack);	
				System.out.print("Value (comma separated for multiple values): ");
				String values = s.nextLine();
				for (String string : values.split(",")) {
					current_stack.push(string.replace(" ", ""));
				}
			} catch(Exception e) {
				System.err.println("Stack no existe.");
			}
		}
		
		ComparatorResult result = comparator.compare(list_stacks);
		System.out.println(result.getPassed() + ": " + result.getMessage());
		if (s != null)
			s.close();
		
		logger.debug("METHOD: Ending - init");
	}

	private <T> String listAvailableStacks(int list_size) {
		StringBuilder sb = new StringBuilder("Stacks { 0");
		
		for (int i = 1; i < list_size; i++)
			sb.append(", " + i);
		
		sb.append(" }");
		return sb.toString();
	}
	
	private <T> String printList(List<Stack<T>> list) {
		StringBuilder sb = new StringBuilder();
		for (Stack<T> stack : list) {
			sb.append(stack + "\n");
		}
		return sb.toString();
	}
}
