JAVA(TM) MESSAGE SERVICE (JMS) CODE EXAMPLES

Notes for use with Sun Java(tm) System Message Queue
----------------------------------------------------

These notes describe the example applications provided in this
directory and explain how to use these examples in a Sun Java(tm) 
System Message Queue environment. The examples consist of the fifteen 
JMS examples included in the JMS Sample Programs bundle available 
from the JMS website and four additional examples supplied by the
Sun Java(tm) System Message Queue product.

For the most part, the following notes preserve the text that
accompanies the JMS Sample Programs; however, new sections have
been added to provide information specific to Sun Java(tm) System 
Message Queue.

#####hpux-dev#####
On Windows HP-UX and Linux, IMQ_HOME is the top level directory in
which the Sun Java(tm) System Message Queue product has been 
installed.

Note that in the Solaris Platform Edition, the different
components of Sun Java(tm) System Message Queue are distributed in 
the system directories and not under a single top level 'IMQ_HOME' directory.
Each mention of IMQ_HOME will also list where the relevant component
can be found in the Solaris Platform Edition.

You should install Sun Java(tm) System Message Queue and start the broker
(imqbrokerd)
before attempting to compile and/or run the example applications.
imqbrokerd is located in the <IMQ_HOME>/bin directory.
In the Solaris Platform Edition, imqbrokerd is located in
the /usr/bin/ directory.

The examples have already been compiled using JDK1.4.

To run the examples with JDK1.4, you will need to ensure that
the following jar files are in your CLASSPATH -
    <IMQ_HOME>/lib/imq.jar
    <IMQ_HOME>/lib/jms.jar
#####hpux-dev#####
    <IMQ_HOME>/share/lib/imq.jar (HP-UX)
    <IMQ_HOME>/share/lib/jms.jar (HP-UX)
The other required jar files from the <IMQ_HOME>/lib ( <IMQ_HOME>/share/lib for HP-UX) directory will be automatically included in the CLASSPATH.
In the Solaris Platform Edition, the jars files are found in
/usr/share/lib/

To recompile the examples, (using JDK1.4) you will need to ensure
that the following jar files are in your CLASSPATH -
    <IMQ_HOME>/lib/jms.jar
    <IMQ_HOME>/lib/imq.jar
#####hpux-dev#####
    <IMQ_HOME>/share/lib/jms.jar (HP-UX)
    <IMQ_HOME>/share/lib/imq.jar (HP-UX)
In the Solaris Platform Edition, the jars files are found in
/usr/share/lib/

If you are using JDK1.2 or JDK1.3 to compile and run
Sun Java(tm) System Message Queue, you will need to explicitly specify 
all the required jars files in your CLASSPATH.
In addition, you will need to include the JNDI jar file in your
CLASSPATH -
    <IMQ_HOME>/lib/jndi.jar
#####hpux-dev#####
    <IMQ_HOME>/share/lib/jndi.jar (HP-UX)
In the Solaris Platform Edition, the jar file is found in
/usr/share/lib/imq/
Note that the Solaris package SUNWiqsup needs to be installed.

For running a client application that uses JNDI with File System
Provider, fscontext.jar should be added to the CLASSPATH.
/usr/share/lib/fscontext.jar

Additional CLASSPATH requirements (if any) are noted with the
description of each example in these notes.

The material in these notes is organized into the following sections:

1. List of example applications
2. Using JMS examples in a Sun Java(tm) System Message Queue 
environment
   - Modification of JMS Sample Programs
   - Using Sun Java(tm) System Message Queue administered objects and JNDI
   - Automatic destination creation
3. JMS Sample Programs
4. Sun Java(tm) System Message Queue supplied examples

===============================
1. List of Example Applications
===============================

The example applications consist of the fifteen JMS examples
included in the JMS Sample Programs bundle available from the
JMS website and four additional examples supplied by
Sun Java(tm) System Message Queue.


JMS Sample Programs
===================

The JMS Sample Programs bundle can be downloaded in original form
from the JMS website at http://java.sun.com/products/jms/docs.html

The example applications included in the JMS Sample Programs are
the following:
- SenderToQueue
- SynchQueueExample
- SynchTopicExample
- AsynchQueueExample
- AsynchTopicExample
- MessageFormats
- MessageConversion
- ObjectMessages
- BytesMessages
- MessageHeadersTopic
- TopicSelectors
- DurableSubscriberExample
- AckEquivExample
- TransactedExample
- RequestReplyQueue
These examples are described in Section 3 of these notes:
"JMS Sample Programs."

Additional examples supplied by Sun Java(tm) System Message Queue
=================================================================

The additional examples supplied by Sun Java(tm) System Message Queue 
are the following:
- XMLMessageExample
These examples are described below, in Section 4 of these notes:
"Additional examples supplied by Sun Java(tm) System Message Queue."


========================================================================
2. Using JMS Examples in a Sun Java(tm) System Message Queue environment
========================================================================

This section provides information you need to run the JMS example
applications in a Sun Java(tm) System Message Queue environment.


Modifications to JMS Sample Programs
====================================

All of the examples in JMS Sample Programs use the utility class
SampleUtilities.java to obtain the ConnectionFactory and Destination
administered objects needed by a JMS client application.

As originally written, SampleUtilities.java uses the Java Naming and Directory
Interface (JNDI) to look up these administered objects, thus making the 
example applications provider-independent.

In the interest of not requiring JNDI in order to run the example 
applications, however, the SampleUtilities.java default behavior has been 
modified to directly instantiate Sun Java(tm) System Message Queue 
ConnectionFactory and Destination administered objects, rather than use a 
JNDI lookup. This means you can run the example applications without having 
to first add Sun Java(tm) System Message Queue administered objects to a JNDI 
directory service.

If you prefer, instead, to use a JNDI lookup, you have to first populate a 
JNDI directory service with the required administered objects. Then, when 
running an example application, you set the system property USE_JNDI to "true" 
on the command line, as shown below: 
  % java -DUSE_JNDI=true <-D JNDI_Initial_Context_Properties...> \
    <example_application> <parameters>

See the section "Using Sun Java(tm) System Message Queue Administered Objects 
and JNDI," below, for more details on running these examples with JNDI, including 
example values of the JNDI_Initial_Context_Properties.


Using Sun Java(tm) System Message Queue Administered Objects and JNDI
=====================================================================

When running the example programs using a JNDI lookup to access Sun 
Java(tm) System Message Queue administered objects, you have to perform 
the following steps:

1. Add the required Sun Java(tm) System Message Queue administered objects 
to an object store. Sun Java(tm) System Message Queue supports both a file 
system service provider and an LDAP service provider.

2. Run the example applications using the appropriate system properties for the JNDI service provider you are using

These steps are described in more detail below.

STEP 1:
Adding the required Sun Java(tm) System Message Queue administered objects to 
an object store.
-----------------------------------------------------------------------

The examples assume that the lookup name is prefixed with "cn="  that is, for
example, the Queue named "controlQueue" is stored under the lookup name
"cn=controlQueue"

This prefix is meant to satisfy the default Java Schema on most LDAP servers.
If you are using an LDAP server that is configured differently, you have to 
modify SampleUtilities.java accordingly.

The examples expect the following Sun Java(tm) System Message Queue Objects to 
have been created and stored using either a file system or LDAP directory service 
provider for JNDI:

1. cn=ConnectionFactory               a ConnectionFactory object
2. cn=QueueConnectionFactory          a QueueConnectionFactory object
3. cn=TopicConnectionFactory          a TopicConnectionFactory object
4. cn=controlQueue                    a Queue object
5. cn=A                               a Queue object
6. cn=B                               a Queue object
7. cn=C                               a Queue object
8. cn=D                               a Queue object
9. cn=E                               a Queue object

  (Other Queue and Topic objects of your choice might also be needed
   as parameters in running some of the example applications.)

Sun Java(tm) System Message Queue administered object support includes both a 
command line object manager utility (imqobjmgr) and a GUI tool (the Admin Console). 
You use these tools, as described in the Sun Java(tm) System Message Queue 
Administrator's Guide, to create and manage Sun Java(tm) System Message Queue 
administered objects. You can find examples in the <IMQ_HOME>/examples/imqobjmgr 
directory.
NOTE: In the Solaris Platform Edition, these example are in the
/usr/demo/imq/imqobjmgr/ directory.

The paragraphs below provide examples how to use imqobjmgr to create 
administered objects using the following Sun Java(tm) System Message 
Queue implementations:
- a file system JNDI service provider (A)
- an LDAP JNDI service provider (B).

A) Using the File System Service Provider

   The imqobjmgr command is run from the <IMQ_HOME>/bin directory.
   In the Solaris Platform Edition, imqobjmgr is in the /usr/bin/ directory.
   Objects are stored in a directory specified by java.naming.provider.url.

   Use the following imqobjmgr command to add an ConnectionFactory
   object to the file=based object store.
   The lookup name specified is "cn=ConnectionFactory".
   Other attributes assume the default connection factory configuration.

     % imqobjmgr add -t cf -l cn=ConnectionFactory \
       -j "java.naming.factory.initial=com.sun.jndi.fscontext.RefFSContextFactory" \
       -j "java.naming.provider.url=file:///var/imq/imq_admin_objects"

     When running on Windows the value of the "java.naming.provider.url"
     property would change to a win32 file url of the form
     "file:///C:/imq_admin_objects" which includes the drive letter and full
     directory name.

   Use the following imqobjmgr command to add a Queue object to the object
   store. The lookup name specified is "cn=Queue".
   The queue destination name set to "Queue1".
   Note: Always use the "JNDI lookup name" for a lookup and not the
         "imqDestinationName" that was assigned to the destination object.

     % imqobjmgr add -t q -l cn=Queue -o "imqDestinationName=Queue1" \
       -j "java.naming.factory.initial=com.sun.jndi.fscontext.RefFSContextFactory" \
       -j "java.naming.provider.url=file:///var/imq/imq_admin_objects"

B) Using the LDAP Service Provider

   The imqobjmgr command is run from the <IMQ_HOME>/bin directory.
   In the Solaris Platform Edition, imqobjmgr is in the /usr/bin/ directory.
   Objects are stored in an LDAP url specified by java.naming.provider.url.

   Use the following imqobjmgr command to add a ConnectionFactory
   object to the LDAP object store.
   The lookup name specified is "cn=ConnectionFactory".
   Other attributes assume the default connection factory configuration.

     % imqobjmgr add -t cf -l cn=ConnectionFactory \
       -j "java.naming.factory.initial=com.sun.jndi.ldap.LdapCtxFactory" \
       -j "java.naming.provider.url=ldap://<servername>:389/ou=JMSObj, ou=xxx, \
           o=JMQ" \
       -j "java.naming.security.authentication=simple" \
       -j "java.naming.security.principal=uid=xxx, ou=People, o=JMQ" \
       -j "java.naming.security.credentials=xxx"
   Substitute the <servername>, principal, and credential as appropriate.for
   Your LDAP installation.

STEP 2:
Run the example using the appropriate JNDI System properties
------------------------------------------------------------

An example of running SenderToQueue (the first JMS example application) with 
both the file system (A) and LDAP (B) service providers is included below.

A) Running SenderToQueue with the file system JNDI service provider:

   % java -DUSE_JNDI=true \
     -Djava.naming.factory.initial=com.sun.jndi.fscontext.RefFSContextFactory \
     -Djava.naming.provider.url=file:///var/imq/imq_admin_objects \
     SenderToQueue cn=Queue

B) Running SenderToQueue with the LDAP JNDI service provider.

   % java -DUSE_JNDI=true \
     -D"java.naming.factory.initial=com.sun.jndi.ldap.LdapCtxFactory" \
     -D"java.naming.provider.url=ldap://<servername>:389/ou=JMSObj, ou=xxx, o=JMQ" \
     -D"java.naming.security.authentication=simple" \
     -D"java.naming.security.principal=uid=xxx, ou=People, o=JMQ" \
     -D"java.naming.security.credentials=xxx" SenderToQueue cn=Queue
   Substitute the <servername>, principal and credentials as appropriate for
   your LDAP installation.

Automatic Destination Creation
==============================

By default, physical destinations for Topics and Queues are "auto-created" by 
a broker when a message producer or a message consumer is created, or when
messages are first produced for a destination. Hence, to run the examples,
there is no need to manually create destinations using an administrative tool
(per the JMS Sample Programs instructions in Section 3).

(The "auto-create" behavior can be changed by modifying the Broker properties
"imq.autocreate.queue" and "imq.autocreate.topic".


======================
3. JMS Sample Programs
======================

The Java Message Service (JMS) code examples show how to write a simple
application using JMS.  They demonstrate most of the important features of JMS.

The JMS examples are divided into three groups:

 - Basic examples provide a simple introduction to JMS.  They show how to send
   and synchronously receive a single message using either a queue or a topic.

 - Intermediate examples demonstrate somewhat more complex features of JMS:
     - using message listeners for asynchronous receiving of messages
     - using the five supported message formats

 - Advanced examples demonstrate still more advanced features of JMS:
     - using message headers
     - using message selectors
     - using durable subscriptions
     - using acknowledgement modes
     - using transactions
     - using the request/reply facility

You can run the simpler queue examples in pairs, each program in a separate
terminal window.  This allows you to simulate two separate applications, one
sending a message, the other receiving it.

For the other examples, the producer and consumer (or the publisher and the
subscriber, for topic examples) are each a separate class within the overall
program class.  When you run these examples, the two classes use threads to
send and receive messages within the same program.


Before You Start
================

Before you begin, follow the JMS Provider's instructions for starting up the
system.  Then create a queue and a topic.  Most of the examples take either a
queue name or a topic name as an argument.  To run some of the examples, you
should also create a queue named "controlQueue".

Compile the sample programs individually if you wish, or all at once by using
the command

  javac *.java


What All the Examples Have in Common
====================================

All the examples use the utility class SampleUtilities.java.  It contains the
following methods:

  - The methods getConnectionFactory, getQueueConnectionFactory, 
    getTopicConnectionFactory, getQueue,and getTopic, which obtain a 
    connection factory or destination either by directly instantiating 
    Sun Java(tm) System Message Queue Administered Objects or, if you 
    choose to use JNDI, by calling the method jndiLookup.

  - The methods sendSynchronizeMessage and receiveSynchronizeMessages, which
    are used to ensure that a publisher does not publish messages until its
    subscriber or subscribers are ready for message delivery.  These methods
    use a queue named "controlQueue".

  - The class DoneLatch, which allows a program to synchronize between an
    asynchronous consumer and another thread in the receiving class.

  - An exit method that all the examples call.

Most of the JMS examples execute the same basic setup steps:

  1.  They read a topic or queue name from the command line.
      See "Automatic Destination Creation" in Section 2 of these for 
      information about automatic destination creation in Sun Java(tm) System 
      Message Queue.

  2.  They directly instantiate Sun Java(tm) System Message Queue connection 
      factory objects unless the System property USE_JNDI is set to true in 
      which case they look them up using the jndiLookup method in the class 
      SampleUtilities.

  3.  They use the connection factory to create a connection.

  4.  They use the connection to create a session.

  5.  They use the session to create message producers and/or consumers for
      the topic or queue.

The publish/subscribe examples begin by calling the sendSynchronizeMessage and
receiveSynchronizeMessages methods to ensure that the consumer gets all the
messages the producer sends.  The consumer calls sendSynchronizeMessage 
when it is ready to receive messages.  The producer waits for the synchronize
message; when the message arrives, the producer starts sending its messages.

Most of the message-producing examples send an empty message at the end of the
program to indicate that they have finished sending messages.  The
message-consuming examples use this message as a signal to stop reading
messages.  The asynchronous message consumers use the DoneLatch class to pass
this signal from the message listener to the consuming class.

Each example contains comments that provide details on what it does and how it
works.


Basic Examples
==============

The most basic JMS examples do the following:

  - SenderToQueue.java and SynchQueueExample.java can be used to send and
    synchronously receive a single text message using a queue.

    If you run these programs in two different windows, the order in which you
    start them does not matter.  If you run them in the same window, run
    SenderToQueue first.  Each program takes a queue name as a command-line
    argument.

    The output of SenderToQueue looks like this (the queue name is SQ):

      % java SenderToQueue SQ
      Queue name is SQ
      Sending message: Here is a message 1

     If you use JNDI, the destination name parameter is required to be the
     JNDI lookup name and the command line would be:

       % java -DUSE_JNDI=true \
         <-D JNDI_Initial_Context_Properties...> SenderToQueue <queue_name>

     Note that <queue_name> is used without the "cn=" prefix.

     The output of SynchQueueReceiver looks like this:

       % java SynchQueueExample SQ
       Queue name is SQ
       Reading message: Here is a message

     If you use JNDI, the command line would be:

       % java -DUSE_JNDI=true \
         <-D JNDI_Initial_Context_Properties...> SynchQueueExample 
         <queue_name>

     Note that <queue_name> is used without the "cn=" prefix.


  - SynchTopicExample.java uses a producer class and a consumer class to
    publish and synchronously receive a single text message using a topic.  
    The program takes a topic name as a command-line argument.

    The output of SynchTopicExample looks like this (the topic name is ST):

      % java SynchTopicExample ST
      Topic name is ST
      PRODUCER THREAD: Publishing message: Here is a message 1
      CONSUMER THREAD: Reading message: Here is a message 1

     If you use JNDI, the command line would be:

       % java -DUSE_JNDI=true \
         <-D JNDI_Initial_Context_Properties...> SynchTopicExample 
         <topic_name>

     Note that <topic_name> is used without the "cn=" prefix.

These examples contain more detailed explanatory comments than the others.


Intermediate Examples
=====================

The intermediate JMS examples do the following:

  - SenderToQueue.java and AsynchQueueExample.java send a specified number of
    text messages to a queue and asynchronously receive them using a message
    listener (TextListener), which is in the file TextListener.java.

    To use SenderToQueue to send more than one message, specify a number after
    the queue name when you run the program.  For example:

      % java SenderToQueue SQ 3

     If you use JNDI, the command line would be:

       % java -DUSE_JNDI=true \
         <-D JNDI_Initial_Context_Properties...> SenderToQueue <queue_name> 
         <number>

     Note that <queue_name> is used without the "cn=" prefix.

    If you run these programs in two different windows, the order in which you
    start them does not matter.  If you run them in the same window, run
    SenderToQueue first.


  - AsynchTopicExample.java uses a producer class and a consumer class to
    publish five text messages to a topic and asynchronously get them using a
    message listener (TextListener).

      % java AsynchTopicExample <topic_name>

     If you use JNDI, the command line would be:

       % java -DUSE_JNDI=true \
         <-D JNDI_Initial_Context_Properties...> AsynchTopicExample
         <topic_name>

     Note that <topic_name> is used without the "cn=" prefix.
     Also, the example expects to find the control queue using the lookup name
     "cn=controlQueue".


  - MessageFormats.java writes and reads messages in the five supported message
    formats.  The messages are not sent, so you do not need to specify a queue
    or topic argument when you run the program.

      % java MessageFormats

     If you use JNDI, the command line would be:

       % java -DUSE_JNDI=true <-D JNDI_Initial_Context_Properties...> 
         MessageFormats


  - MessageConversion.java shows that for some message formats, you can write
    a message using one data type and read it using another.  The 
    StreamMessage format allows conversion between String objects and other 
    data types.  The BytesMessage format allows more limited conversions.  You 
    do not need to specify a queue or topic argument.

      % java MessageConversion

     If you use JNDI, the command line would be:

       % java -DUSE_JNDI=true <-D JNDI_Initial_Context_Properties...>
         MessageConversion


  - ObjectMessages.java shows that objects are copied into messages, not 
    passed by reference: once you create a message from a given object, you 
    can change the original object, but the contents of the message do not 
    change.  You do not need to specify a queue or topic argument.

      % java ObjectMessages

     If you use JNDI, the command line would be:

       % java -DUSE_JNDI=true <-D JNDI_Initial_Context_Properties...> 
         ObjectMessages


  - BytesMessages.java shows how to write, then read, a BytesMessage of
    indeterminate length.  It reads the message content from a text file, but
    the same basic technique can be used with any kind of file, including a
    binary one.  Specify a text file on the command line when you run the
    program:

      % java BytesMessages <filename>

     If you use JNDI, the command line would be:

       % java -DUSE_JNDI=true \
         <-D JNDI_Initial_Context_Properties...> BytesMessages <filename>


Advanced Examples
=================

The advanced examples do the following:

  - MessageHeadersTopic.java illustrates the use of the JMS message header
    fields.  It displays the values of the header fields both before and after
    a message is sent, and shows how the send method sets the fields.

      % java MessageHeadersTopic <topic_name>

     If you use JNDI, the command line would be:

       % java -DUSE_JNDI=true \
         <-D JNDI_Initial_Context_Properties...> MessageHeadersTopic 
         <topic_name>

     Note that <topic_name> is used without the "cn=" prefix.
     Also, the example expects to find the control queue using the lookup name
     "cn=controlQueue".


  - TopicSelectors.java shows how to use message header fields as message
    selectors.  The program consists of one publisher and several subscribers.
    Each subscriber uses a message selector to receive a subset of the 
    messages sent by the publisher.

      % java TopicSelectors <topic_name>

     If you use JNDI, the command line would be:

       % java -DUSE_JNDI=true \
         <-D JNDI_Initial_Context_Properties...> TopicSelectors <topic_name>

     Note that <topic_name> is used without the "cn=" prefix.
     Also, the example expects to find the control queue using the lookup name
     "cn=controlQueue".


  - DurableSubscriberExample.java shows how you can create a durable 
    subscriber that retains messages published to a topic while the subscriber 
    is inactive.

      % java DurableSubscriberExample <topic_name>

     If you use JNDI, the command line would be:

       % java -DUSE_JNDI=true \
         <-D JNDI_Initial_Context_Properties...> DurableSubscriberExample \
         <topic_name>

     Note that <topic_name> is used without the "cn=" prefix.


  - AckEquivExample.java shows that to ensure that a message will not be
    acknowledged until processing is complete, you can use either of the
    following methods:

    * An asynchronous receiver (message listener) in an AUTO_ACKNOWLEDGE 
      session
    * A synchronous receiver in a CLIENT_ACKNOWLEDGE session

    This example takes both a queue name and a topic name as arguments.

      % java AckEquivExample <queue_name> <topic_name>

     If you use JNDI, the command line would be:

       % java -DUSE_JNDI=true \
         <-D JNDI_Initial_Context_Properties...> AckEquivExample <queue_name> \
         <topic_name>

     Note that <queue_name> and <topic_name> is used without the "cn=" prefix.
     Also, the example expects to find the control queue using the lookup name
     "cn=controlQueue".


  - TransactedExample.java demonstrates the use of transactions in a simulated
    e-commerce application.  The classes within the example commit a transaction
    only after they have received messages they were expecting and have sent
    appropriate messages as a result.  This example takes an integer argument
    (the number of items being ordered).  It uses five queues named A, B, C,
    D, and E, which you must create in order to run the program.

      % java TransactedExample <integer>

     If you use JNDI, the command line would be:

       % java -DUSE_JNDI=true \
         <-D JNDI_Initial_Context_Properties...> TransactedExample <integer>

     Note that in this case, the lookup names "cn=A", "cn=B", "cn=C", "cn=D",
     and "cn=E" are expected to be available from JNDI.


  - RequestReplyQueue.java uses the JMS request/reply facility, which supports
    situations in which every message sent requires a response.  The sending
    application creates a QueueRequestor, which encapsulates the creation and
    use of a destination where a reply is sent.

      % java RequestReplyQueue <queue_name>

     If you use JNDI, the command line would be:

       % java -DUSE_JNDI=true \
         <-D JNDI_Initial_Context_Properties...> RequestReplyQueue 
         <queue_name>

     Note that <queue_name> is used without the "cn=" prefix.

====================================================================
4. Additional examples supplied by Sun Java(tm) System Message Queue
====================================================================

The additional examples supplied by Sun Java(tm) System Message Queue are 
the following:

  - XMLMessageExample.java reads an XML document from a file and uses the
    standard JMS API to send it to a queue. It then uses a receiver to process
    the message from the queue as an XML document and convert it to a DOM
    object using the JAXP API.

    To compile and run the example with JDK1.4, no additional jar libraries are
    required.

    To compile and run the example with JDK1.2 or JDK1.3, download the
    Java API for XML Parsing (JAXP) from

    http://java.sun.com/xml/

    and make sure the JAXP API and the XML parser jar files are in your
    CLASSPATH besides other jar files required as other examples.

       % java XMLMessageExample <queue_name> <xml_filename> [<systemid_url>]

     <queue_name> is the JMS queue to send the message to.
     <xml_filename> is the file containing the XML document.
     <systemid_url> is the url to use to resolve relative URLs present in the
               input source (i.e. the XML Document)

     There is a sample XML file (sample.xml) and its DTD file (sample.dtd) 
     provided.

     for example on a Unix platform -

       % java XMLMessageExample myxmlqueue sample.xml file:///<directory>/
       Queue name is myxmlqueue
       Write 771 bytes into message
       Read 771 bytes from message
       Root element of the doc is slideshow

     If you use JNDI, the command line would be:

       % java -DUSE_JNDI=true \
         <-D JNDI_Initial_Context_Properties...> XMLMessageExample 
         <queue_name> <xml_filename> [<systemid_url>]

After You Finish
================

After you run the examples, you can delete the topic and queues you created 
and shut down the broker.

