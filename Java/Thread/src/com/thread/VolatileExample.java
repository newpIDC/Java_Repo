/*package com.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class VolatileExample extends Thread {
	  private int countDown = 100;
	 // private static int d = 0;
	  private static final AtomicInteger d = new AtomicInteger(0);
	  public VolatileExample(String name) {
	    super(name);
	  }

	  public String toString() {
	    return super.getName() + ": countDown " + countDown;
	  }

	  public void run() {
	    while(true) {
	      //d = d + 1;
	       d.incrementAndGet();
	       System.out.println(this + ". Value of d is " + d);
	      if(--countDown == 0) return;
	    }
	  }

	  public static void main(String[] args) {
	    VolatileExample ve1 = new VolatileExample("first thread");
	    VolatileExample ve2 = new VolatileExample("second thread");
	    ve1.start();
	    ve2.start();
	  }
	}*/