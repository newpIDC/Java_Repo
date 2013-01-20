import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.security.*;

public class MyServlet implements Filter 
{
  public void doFilter(ServletRequest request, ServletResponse response,
    FilterChain chain)
    throws IOException, ServletException 
  {

    System.out.println("In filter");
    chain.doFilter(request, response);
    System.out.println("Leaving filter");
  }

  public void destroy() 
  { 
  }

  public void init(FilterConfig filterConfig) 
  {
  }

}
