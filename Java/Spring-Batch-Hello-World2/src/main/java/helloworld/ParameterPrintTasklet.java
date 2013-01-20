package helloworld;

import org.springframework.batch.repeat.ExitStatus;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.listener.StepExecutionListenerSupport;

public class ParameterPrintTasklet
      extends StepExecutionListenerSupport
      implements Tasklet {

  private String message;

  public ExitStatus execute() throws Exception {
      System.out.println(message);
      return ExitStatus.FINISHED;
  }

  public void beforeStep(StepExecution stepExecution) {
      JobParameters jobParameters = stepExecution.getJobParameters();
      message = jobParameters.getString("message");
  }
}