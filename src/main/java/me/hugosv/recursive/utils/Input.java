package me.hugosv.recursive.utils;

import java.util.Scanner;

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
