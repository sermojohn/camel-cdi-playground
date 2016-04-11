Camel CDI Example
=================

This example shows how to work with Camel in the Java Container using CDI to configure components,
endpoints and beans.

The example generates messages using timer trigger, writes them to the standard output and the mock
endpoint (for testing purposes).

You will need to compile this example first:
  mvn clean package
  
You can deploy the application on wildfly 8.2.x:
  mvn wildfly:deploy

For more help see the Apache Camel documentation

    http://camel.apache.org/

