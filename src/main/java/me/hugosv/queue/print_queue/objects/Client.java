package me.hugosv.queue.print_queue.objects;

import java.util.Queue;
import org.apache.log4j.Logger;
import me.hugosv.queue.print_queue.NetworkPrinter;

/**
 * 
 * @author Hugo Sanchez V
 *
 */
public class Client implements Receiver<Message>, Runnable{

	private final String ip;
	private Queue<Print> printQueue;
	private NetworkPrinter printer;
	private boolean done;
	
	private final Logger logger;
	
	public Client(String ip) {
		this.ip = ip;
		this.logger = Logger.getLogger(Client.class);
	}
	
	public void run() {
		Print print = this.printQueue.poll();
		if(print == null) {
			logger.info("All files sended to print.");
			this.done = true;
			return;
		}
		
		System.out.println("Client@" + this.ip +": Sending to print file: " + print.getFilename());
		this.printer.receive(print);
	}

	public void receive(Message payload) {
		System.out.print("Client@" + this.ip + ": Recieved message from: " + payload.getSender());
		System.out.format(" - %s%n", payload.getMessage());
	}
	
	public String getIp() {
		return ip;
	}
	
	public void setPrintQueue(Queue<Print> printQueue) {
		for (Print print : printQueue) {
			print.setSender(this);
		}
		this.printQueue = printQueue;
	}
	
	public NetworkPrinter getPrinter() {
		return printer;
	}
	
	public void setPrinter(NetworkPrinter printer) {
		this.printer = printer;
	}
	
	public boolean isDone() {
		return done;
	}
	
}
