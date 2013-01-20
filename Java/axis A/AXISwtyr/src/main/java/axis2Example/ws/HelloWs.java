package axis2Example.ws;
 
public class HelloWs {
 
  public String sayHello(String name) {
 
	  if (name == null) {
		  return "Hello";
	  }
    return "Hello, " + name + "!";
  }
}