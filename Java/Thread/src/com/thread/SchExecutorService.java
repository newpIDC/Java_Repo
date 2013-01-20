package com.thread;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import static java.util.concurrent.TimeUnit.*;

public class SchExecutorService {
	private final ScheduledExecutorService scheduler =
		       				Executors.newScheduledThreadPool(1);
	
	public void beepForAnHour() {
        final Runnable beeper = new Runnable() {
                public void run() { System.out.println("beep"); }
            };
            
        final ScheduledFuture<?> beeperHandle = scheduler.scheduleAtFixedRate(beeper, 2, 2, SECONDS);
        scheduler.schedule(new Runnable() {
                		public void run() { beeperHandle.cancel(true); }
            }, 2 * 2, SECONDS);
        
        
    }
}
