/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.hugosv.sort;

import java.util.Arrays;
import java.util.List;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Hugo Sanchez
 */
public class SortHelperTest {

	private SortHelper<Integer> sorter;
	private Logger logger = Logger.getLogger(SortHelperTest.class);
	private int testQuantity;

	@Before
	public void setUp() {
		this.sorter = new SortHelper<>();

		this.testQuantity = 500000;
	}

	/**
	 * Test of shell method, of class SortHelper.
	 */
	@Test
	public void testShell() {
		logger.info("TEST: Starting method - testShell");
		Integer[] src = this.generateIntegers(testQuantity);

		if (logger.isTraceEnabled()) {
			this.print(src);
		}

		long start = System.currentTimeMillis();
		this.sorter.shell(src);
		long end = System.currentTimeMillis();

		System.out.println("Process finished on: " + (end - start) + " ms.");
		if (logger.isTraceEnabled()) {
			this.print(src);
		}
	}

	/**
	 * Test of quicksort method, of class SortHelper.
	 */
	@Test
	public void testQuicksort() {
		logger.info("TEST: Starting method - testQuickSort");
		List<Integer> arr = this.generateIntegersList(testQuantity);

		long start = System.currentTimeMillis();
		List<Integer> res = this.sorter.quickSort(arr);
		long end = System.currentTimeMillis();
		
		System.out.println("Process finished in: " + (end - start) + " ms.");

		if (logger.isTraceEnabled()) {
			this.print(arr.toArray());
			this.print(res.toArray());
		}
	}

	private Integer[] generateIntegers(int quantity) {
		Integer[] g = new Integer[quantity];

		for (int i = 0; i < g.length; i++) {
			g[i] = (int) Math.round(Math.random() * quantity);
		}

		return g;
	}

	private List<Integer> generateIntegersList(int quantity) {
		return Arrays.asList(this.generateIntegers(quantity));
	}

	private void print(Object[] a) {
		StringBuilder sb = new StringBuilder();
		for (Object i : a) {
			sb.append(i.toString()).append(" ");
		}

		System.out.println("src: " + sb.toString());
	}
}
