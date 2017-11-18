package me.hugosv.queue.print_queue;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.UUID;
import org.apache.log4j.Logger;
import me.hugosv.queue.print_queue.objects.Client;
import me.hugosv.queue.print_queue.objects.Print;

/**
 * 
 * @author Hugo Sanchez V
 *
 */
public class Main {

	private final String system = "SimulacrumSystem";
	private final Logger logger = Logger.getLogger(system);

	public void init() {
		logger.debug("Initializing.");
		NetworkPrinter printer = new NetworkPrinter();
		List<Client> clients = ClientGenerator(10);
		for (Client client : clients) {
			client.setPrinter(printer);
			client.setPrintQueue(ToPrintFilesGenerator(2));
			logger.info(client.getIp() + ": conectando.");
		}
		logger.debug("Initialized.");
		logger.info("Printer online.");
		logger.info(clients.size() + " clients online.");
		logger.debug("Starting ThreadExecutor.");
		ThreadExecutor(clients);
		logger.debug("Finished ThreadExecutor");
	}

	private List<Client> ClientGenerator(int quantity) {
		List<Client> clients = new ArrayList<Client>(quantity);
		for (int i = 1; i <= quantity; i++) {
			Client client = new Client("10.1.1." + i);
			clients.add(client);
		}
		return clients;
	}

	private Queue<Print> ToPrintFilesGenerator(int quantity) {
		Queue<Print> queue = new ArrayDeque<Print>(quantity);
		for (int i = 0; i < quantity; i++) {
			Print print = new Print();
			print.setFilename(UUID.randomUUID().toString().substring(0, 7).concat(".docx"));
			print.setPages((short) Math.round(Math.random() * 4 + 1));
			print.setSize(Math.round(Math.random() * 1000));
			queue.offer(print);
		}
		return queue;
	}

	private void ThreadExecutor(List<? extends Client> runnables) {
		while (true) {
			logger.debug("Runnables left: " + runnables.size());
			if(runnables.isEmpty()) {
				break;
			}
			
			int random = (int) Math.round(Math.random() * (runnables.size() - 1));
			(new Thread(runnables.get(random))).start();
			
			if (runnables.get(random).isDone()) {
				runnables.remove(random);
			}
		}
	}

	public static void main(String[] args) {
		new Main().init();
	}
}
