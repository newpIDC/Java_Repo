Fibonacci Web Service Code:
---------------------------

A few notes.

Make sure that you run setclasspath in the cmd.exe that you are using.
There are a few other batchfiles that help us be lazy and not have to type so much.
Check them out.

When you come to "Step 4 - FibonacciSoapBindingImpl: Fill in wrapper to call the existing Fibonacci code"
you can copy the file:

fibonacci/FibonacciSoapBindingImpl.java => fibonacci/ws

Take a peak in the original to see what the generator put in there.

Make sure that you run commands from the right directory.

E.g. 

From root directory:  javac fibonacci\*.java
(The SoapBinding will not compile yet, as we don't have the ws code generated)

From fibonacci\ws:    java org.apache.axis.client.AdminClient deploy.wsdd