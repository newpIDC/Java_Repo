
package com.ibm.jms;
import java.util.Enumeration;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.QueueBrowser;
import javax.jms.Session;

import com.ibm.msg.client.jms.JmsConnectionFactory;
import com.ibm.msg.client.jms.JmsFactoryFactory;
import com.ibm.msg.client.wmq.WMQConstants;

/**
 * A JMS queue browser application that looks at all available messages on the named queue, without
 * removing them, in the order they would be received by a consumer application.
 * 
 * Tip: A browser is not applicable for topics.
 * 
 * Notes:
 * 
 * API type: IBM JMS API (v1.1, unified domain)
 * 
 * Messaging domain: Point-to-point
 * 
 * Provider type: WebSphere MQ
 * 
 * Connection mode: Client connection
 * 
 * JNDI in use: No
 * 
 * Usage:
 * 
 * JmsBrowser -m queueManagerName -d queueName [-h host -p port -l channel]
 * 
 * for example:
 * 
 * JmsBrowser -m QM1 -d Q1
 * 
 * JmsBrowser -m QM1 -d Q1 -h localhost -p 1414
 */
public class JmsBrowser {

  private static String host = "localhost";
  private static int port = 1414;
  private static String channel = "SYSTEM.DEF.SVRCONN";
  private static String queueManagerName = null;
  private static String queueName = null;

  // System exit status value (assume unset value to be 1)
  private static int status = 1;

  /**
   * Main method
   * 
   * @param args
   */
  public static void main(String[] args) {
    // Parse the arguments
    parseArgs(args);

    // Variables
    Connection connection = null;
    Session session = null;
    Queue destination = null;
    QueueBrowser browser = null;

    try {
      // Create a connection factory
      JmsFactoryFactory ff = JmsFactoryFactory.getInstance(WMQConstants.WMQ_PROVIDER);
      JmsConnectionFactory cf = ff.createConnectionFactory();

      // Set the properties
      cf.setStringProperty(WMQConstants.WMQ_HOST_NAME, host);
      cf.setIntProperty(WMQConstants.WMQ_PORT, port);
//      cf.setStringProperty(WMQConstants.WMQ_CHANNEL, channel);
      cf.setStringProperty(WMQConstants.WMQ_CHANNEL, "SYSTEM.DEF.SVRCONN");
      
      cf.setIntProperty(WMQConstants.WMQ_CONNECTION_MODE, WMQConstants.WMQ_CM_CLIENT);
//      cf.setIntProperty(WMQConstants.WMQ_CONNECTION_MODE, WMQConstants.WMQ_CM_CLIENT_UNMANAGED);
      cf.setStringProperty(WMQConstants.WMQ_QUEUE_MANAGER, queueManagerName);
      cf.setStringProperty(WMQConstants.WMQ_QUEUE_MANAGER, "IBM.MQ");
//      cf.setStringProperty(WMQConstants.USERID, "abhay");
//      cf.setStringProperty(WMQConstants.PASSWORD, "abhay");

      // Create JMS objects
      connection = cf.createConnection();
      session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
//      destination = session.createQueue(queueName);
      destination = session.createQueue("Q1");
      browser = session.createBrowser(destination);

      // Start the connection
      connection.start();

      // And, browse the message
      Enumeration messages = browser.getEnumeration();
      int count = 0;
      Message current;
      System.out.println("Browse starts");
      while (messages.hasMoreElements()) {
        current = (Message) messages.nextElement();
        System.out.println("\nMessage " + ++count + ":\n");
        System.out.println(current);
      }
      System.out.println("\nNo more messages\n");

      recordSuccess();
    }
    catch (JMSException jmsex) {
      recordFailure(jmsex);
    }
    finally {
      if (browser != null) {
        try {
          browser.close();
        }
        catch (JMSException jmsex) {
          System.out.println("Browser could not be closed.");
          recordFailure(jmsex);
        }
      }

      if (session != null) {
        try {
          session.close();
        }
        catch (JMSException jmsex) {
          System.out.println("Session could not be closed.");
          recordFailure(jmsex);
        }
      }

      if (connection != null) {
        try {
          connection.close();
        }
        catch (JMSException jmsex) {
          System.out.println("Connection could not be closed.");
          recordFailure(jmsex);
        }
      }
    }
    System.exit(status);
    return;
  } // end main()

  /**
   * Process a JMSException and any associated inner exceptions.
   * 
   * @param jmsex
   */
  private static void processJMSException(JMSException jmsex) {
    System.out.println(jmsex);
    Throwable innerException = jmsex.getLinkedException();
    if (innerException != null) {
      System.out.println("Inner exception(s):");
    }
    while (innerException != null) {
      System.out.println(innerException);
      innerException = innerException.getCause();
    }
    return;
  }

  /**
   * Record this run as successful.
   */
  private static void recordSuccess() {
    System.out.println("SUCCESS");
    status = 0;
    return;
  }

  /**
   * Record this run as failure.
   * 
   * @param ex
   */
  private static void recordFailure(Exception ex) {
    if (ex != null) {
      if (ex instanceof JMSException) {
        processJMSException((JMSException) ex);
      }
      else {
        System.out.println(ex);
      }
    }
    System.out.println("FAILURE");
    status = -1;
    return;
  }

  /**
   * Parse user supplied arguments.
   * 
   * @param args
   */
  private static void parseArgs(String[] args) {
    try {
      int length = args.length;
      if (length == 0) {
        throw new IllegalArgumentException("No arguments! Mandatory arguments must be specified.");
      }
      if ((length % 2) != 0) {
        throw new IllegalArgumentException("Incorrect number of arguments!");
      }

      int i = 0;

      while (i < length) {
        if ((args[i]).charAt(0) != '-') {
          throw new IllegalArgumentException("Expected a '-' character next: " + args[i]);
        }

        char opt = (args[i]).toLowerCase().charAt(1);

        switch (opt) {
          case 'h' :
            host = args[++i];
            break;
          case 'p' :
            port = Integer.parseInt(args[++i]);
            break;
          case 'l' :
            channel = args[++i];
            break;
          case 'm' :
            queueManagerName = args[++i];
            break;
          case 'd' :
            queueName = args[++i];
            break;
          default : {
            throw new IllegalArgumentException("Unknown argument: " + opt);
          }
        }

        ++i;
      }

      if (queueManagerName == null) {
        throw new IllegalArgumentException("A queueManager name must be specified.");
      }

      if (queueName == null) {
        throw new IllegalArgumentException("A queue name must be specified.");
      }
    }
    catch (Exception e) {
      System.out.println(e.getMessage());
      printUsage();
      System.exit(-1);
    }
    return;
  }

  /**
   * Display usage help.
   */
  private static void printUsage() {
    System.out.println("\nUsage:");
    System.out.println("JmsBrowser -m queueManagerName -d queueName [-h host -p port -l channel]");
    return;
  }

} // end class
