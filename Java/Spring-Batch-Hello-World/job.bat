mvn clean compile exec:java -Dexec.mainClass=org.springframework.batch.core.launch.support.CommandLineJobRunner -Dexec.args="simpleJob.xml simpleJob"
