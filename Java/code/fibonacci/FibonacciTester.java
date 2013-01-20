package fibonacci;

public class FibonacciTester {
  public static void main(String [] args) throws Exception {
    // Make a service
    fibonacci.ws.FibonacciService service = new fibonacci.ws.FibonacciServiceLocator();


    // Now use the service to get a stub which implements the SDI.
    fibonacci.ws.Fibonacci fib = service.getFibonacci();

    // Make the actual call
    System.out.println("Fibonacci(10) = " + fib.calculateFibonacci(10));
    }
}
