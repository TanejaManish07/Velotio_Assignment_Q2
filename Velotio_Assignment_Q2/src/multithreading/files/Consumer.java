package multithreading.files;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{
	private BlockingQueue<String> queue;
	
	public Consumer(BlockingQueue<String> q) {
		queue = q;
	}
	
	public void run() {
		while(true) {
			String file = queue.poll();
			
			if(file == null && !Controller.isProducerAlive())
				return;
			
			if(file != null) {
				System.out.println(file);
			}
		}
	}

}
