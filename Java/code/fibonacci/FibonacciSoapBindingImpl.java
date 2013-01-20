/**
 * FibonacciSoapBindingImpl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis Wsdl2java emitter.
 */

package fibonacci.ws;

import fibonacci.FibonacciImpl;

public class FibonacciSoapBindingImpl implements fibonacci.ws.Fibonacci {
	FibonacciImpl fib = new FibonacciImpl();

    public int calculateFibonacci(int in0) throws java.rmi.RemoteException {
        return fib.calculateFibonacci(in0);
    }

    public int[] calculateFibonacciRange(int in0, int in1) throws java.rmi.RemoteException {
        return fib.calculateFibonacciRange(in0, in1);
    }

}
