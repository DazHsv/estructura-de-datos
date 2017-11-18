package me.hugosv.queue.print_queue;

import java.util.Observable;
import java.util.Observer;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.apache.log4j.Logger;
import me.hugosv.queue.print_queue.objects.Message;
import me.hugosv.queue.print_queue.objects.Print;
import me.hugosv.queue.print_queue.objects.Receiver;

/**
 * 
 * @author Hugo Sanchez V
 *
 */
public class NetworkPrinter extends Observable implements Receiver<Print>, Observer{

	private volatile Queue<Print> queue;

	private final Logger logger = Logger.getLogger(NetworkPrinter.class);
	
	public NetworkPrinter() {
		this.queue = new ConcurrentLinkedQueue<Print>();
		this.addObserver(this);
	}
	
	public void receive(Print payload) {
		logger.info("=> Incomming payload.");
		if(this.queue.offer(payload)) {
			logger.info("Payload accepted.");
			this.onChange();
		} else {
			logger.error("Payload rejected.");
		}
	}
	
	private synchronized void print(Print payload) throws InterruptedException {
		System.out.println("Network Printer: Printing file: " + payload.getFilename());
		for (short i = 1, pages = payload.getPages(); i <= pages; i++) {
			System.out.format("Print page %d/%d%n", i, pages);
			Thread.sleep(1000);
		}
		System.out.println("Network Printer: Printed file.");
		Message message = new Message();
		message.setSender("Network Printer");
		message.setMessage("Printed file: " + payload.getFilename());
		payload.getSender().receive(message);
		if(this.queue.peek() != null) {
			this.setChanged();
			this.notifyObservers(this.queue.poll());
		} else {
			this.onFinish();
		}
	}

	private void onChange() {
		logger.info("=> Change detected. Checking for files for print.");
		Print print = this.queue.poll();
		if(print != null) {
			logger.info("==> File on queue.");
			logger.info("==> " + print);
			
			this.setChanged();
			this.notifyObservers(print);
		} else {
			logger.info("=> No file on queue.");
		}
	}
	
	private void onFinish() {
		System.out.println("All files printed.");
	}

	public void update(Observable arg0, Object arg1) {
		try {
			this.print((Print) arg1);
		} catch (InterruptedException e) {
			logger.error("Fail printing file. Aborting!");
		}
	}
}
