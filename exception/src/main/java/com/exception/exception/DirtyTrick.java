package com.exception.exception;

import java.io.IOException;

public class DirtyTrick {

	public void dirtyTrick() {
		  try {
		    throw new IOException("Ha ha");
		  } catch (IOException ioe) {
		    uncatch(RuntimeException.class, ioe);
		  }
		}

		private <T extends Throwable> T uncatch(Class<T> type, Throwable t) throws T {
		  throw (T) t;
		}
}
