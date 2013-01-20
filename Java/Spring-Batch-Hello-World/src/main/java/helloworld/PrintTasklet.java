package helloworld;

import org.apache.log4j.Logger;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.ExitStatus;

/**
 *
 * @author tareq.abedrabbo
 */
public class PrintTasklet implements Tasklet{
	Logger logger = Logger.getLogger(PrintTasklet.class);
    private String message;

    public void setMessage(String message) {
        this.message = message;
    }
    
    public ExitStatus execute() throws Exception {
    
    	System.out.println("\n" + message + "\n");

    	logger.debug(message);
        return ExitStatus.FINISHED;
    }
}
