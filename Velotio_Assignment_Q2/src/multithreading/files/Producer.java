package multithreading.files;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {
	private Path fileToRead;
	private BlockingQueue<String> queue;
	
	public Producer(Path filePath, BlockingQueue<String> q) {
		fileToRead = filePath;
		queue = q;
	}
	
	@Override
	public void run() {
		try {
			BufferedReader reader = Files.newBufferedReader(fileToRead);
			Path fileName = fileToRead.getFileName();
			String name = fileName.toString();
			String line;
			String input ="file";
			String words[] = null;
			while((line = reader.readLine()) != null) {
				try {
					words = line.split(" ");
					for(String word: words) {
						if(word.equals(input)) {
							queue.put(name);
						}
						
					}
				} catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
					
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

}
