package io.github.ztgoto.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Run {
	
	static final Logger LOG = LoggerFactory.getLogger(Run.class);
	
	static Wait w = new Wait();
	
	static {
		Runtime.getRuntime().addShutdownHook(new Thread(){

			@Override
			public void run() {
				LOG.info("close sign");
				w.down();
			}
			
		});
	}
	
	public static void main(String[] args) {
		
		SpringApplication app = new SpringApplication(Run.class);
		
		app.run(args);
		
		
		w.waiting();
		LOG.info("---shutdown---");
	}

	static class Wait {
		
		public synchronized void down() {
			this.notifyAll();
		}

		public synchronized void waiting() {
			try {
				this.wait();
			} catch (InterruptedException e) {}
		}
	}
}
