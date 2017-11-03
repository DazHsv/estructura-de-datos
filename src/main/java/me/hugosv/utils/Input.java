package me.hugosv.utils;

import java.util.Scanner;

/**
 * @author Hugo Sanchez Velazquez
 * @version 1.0.0
 */
public class Input {
	private static Scanner instance = null;
	
	private Input() {}
	
	public static Scanner getInstance() {
		return (instance == null ? new Scanner(System.in) : instance);
	}
	
	public static void close() {
		if(instance != null) {
			instance.close();
			instance = null;
		}
	}
}
