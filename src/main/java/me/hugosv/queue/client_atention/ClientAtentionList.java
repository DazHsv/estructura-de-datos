package me.hugosv.queue.client_atention;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import org.apache.log4j.Logger;
import me.hugosv.utils.Input;

/*
 * Hacer un programa que simule la fila de atención a servicio al cliente de una empresa X.
 * Mostrar el tiempo de espera al nuevo elemento que se agregará en la cola o fila.
 */

/**
 * 
 * @author Hugo Sanchez V
 * @version 1.0.0
 * @since ClientAtentionList 1.0.0
 */
public class ClientAtentionList {
	
	private static final Logger logger = Logger.getLogger(ClientAtentionList.class);
	
	private List<Turn> waitingList;
	
	public ClientAtentionList() {
		this.waitingList = new LinkedList<Turn>();
	}
	
	public int insert(String name) {
		
		Turn turn = new Turn();
		turn.setName(name);
		logger.debug(" - turn: " + this.waitingList.size());
		if(this.waitingList.size() > 0) {
			turn.setWaitingTime(this.waitingList.get(this.waitingList.size() - 1).getWaitingTime() + 20);
		} else {
			int randomWaitingTime = (int) (Math.round(Math.random() * 30) + 10);
			logger.debug(" - randomWaitingTime: " + randomWaitingTime);
			turn.setWaitingTime(randomWaitingTime);
		}
		logger.debug(" - turn: " + turn);
		this.waitingList.add(turn);
		
		return turn.getWaitingTime();
	}
	
	public int usedTurns() {
		return this.waitingList.size();
	}
	
	public static void main(String[] args) {
		ClientAtentionList clientAtentionList = new ClientAtentionList();
		Scanner s = Input.getInstance();
		
		while(true) {
			int usedTurns = clientAtentionList.usedTurns();
			System.out.println("Turnos ocupados: " + usedTurns);
			System.out.print("Nombre: ");
			String name = s.nextLine();
			int waitingTime = clientAtentionList.insert(name);
			System.out.format("%s tu turno es: %d con un tiempo de espera aproximado de: %d segundos.%n",
					name, usedTurns + 1, waitingTime);
		}
	}
}
