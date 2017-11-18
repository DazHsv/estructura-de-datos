/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package me.hugosv.list.ordered;

import org.apache.log4j.Logger;
import org.junit.Test;

/**
 *
 * @author Hugo Sanchez
 */
public class OrderedLinkedListTest {

	private final Logger logger = Logger.getLogger(OrderedLinkedListTest.class);
	private final OrderedLinkedList<Integer> target;
	
    public OrderedLinkedListTest() {
		this.target = new OrderedLinkedList();
    }

	/**
	 * Test of add method, of class OrderedLinkedList.
	 */
	@Test
	public void testAdd() {
		logger.info("TEST: Starting method - testAdd");
		for(int x = 0; x < 20; x++) {
			Integer n = (int) Math.round(Math.random() * (Math.random() > 0.5 ? 100 : - 100));
			logger.debug(" - inserting: " + n);
			this.target.add(n);
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < this.target.size(); i++) {
				Integer y =  this.target.get(i);
				sb.append(y).append(" ");
			}
			if(logger.isTraceEnabled())
				logger.trace(sb.toString());
		}
	}

	/**
	 * Test of remove method, of class OrderedLinkedList.
	 */
	@Test
	public void testRemove() {
		logger.info("TEST: Starting method - testRemove");
		Integer i = 10;
		this.target.add(i);
		this.target.add(i + 5);
		
		System.out.println(this.target.remove(1));
		System.out.println(this.target.remove(0));
	}

	/**
	 * Test of get method, of class OrderedLinkedList.
	 */
	@Test
	public void testGet() {
		logger.info("TEST: Starting method - testGet");
		this.target.add(10);
		this.target.add(15);
		this.target.add(5);
		
		for (int j = 0; j < this.target.size(); j++) {
			System.out.println(this.target.get(j));
		}
	}

	/**
	 * Test of size method, of class OrderedLinkedList.
	 */
	@Test
	public void testSize() {
		logger.info("TEST: Starting method - testSize");
		this.target.add(1);
		this.target.add(2);
		this.target.add(3);
		System.out.println("Size: " + this.target.size());
	}

	/**
	 * Test of isEmpty method, of class OrderedLinkedList.
	 */
	@Test
	public void testIsEmpty() {
		logger.info("TEST: Starting method - testIsEmpty");
		System.out.println("isEmpty: " + this.target.isEmpty());
	}

	/**
	 * Test of clear method, of class OrderedLinkedList.
	 */
	@Test
	public void testClear() {
		logger.info("TEST: Starting method - testClear");
		this.target.add(0);
		this.target.clear();
		System.out.println("isEmpty: " + this.target.isEmpty());
	}

	/**
	 * Test of set method, of class OrderedLinkedList.
	 */
	@Test
	public void testSet() {
		logger.info("TEST: Starting method - testSet");
		this.target.add(10); //  Value [0] = 10
		this.target.set(0, 19); // Value [0] = 19
		System.out.println("Value: " + this.target.get(0));
	}
}