package edu.poc.demo.utils;

import org.slf4j.Logger;

public class ExecutionMeasure {

  private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(ExecutionMeasure.class);

  public static void measureExecutionTime(MeasurableCode measurable) {
    long startTime = System.nanoTime();
    measurable.run();
    long endTime = System.nanoTime();
    long duration = (endTime - startTime);
    LOGGER.info("Execution time: {} nanoseconds", duration);
  }

  @FunctionalInterface
  public interface MeasurableCode {
    void run();

    default void andThen(MeasurableCode after) {
      run();
      after.run();
    }
  }
}
