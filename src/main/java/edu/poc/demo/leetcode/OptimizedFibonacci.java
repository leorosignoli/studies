package edu.poc.demo.leetcode;

import edu.poc.demo.utils.ExecutionMeasure;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class OptimizedFibonacci {

  private static final int NTH_NUMBER = 30;

  public static void main(String[] args) {

    final AtomicInteger optimizedRes = new AtomicInteger();
    final AtomicInteger defaultRes = new AtomicInteger();
    ExecutionMeasure.measureExecutionTime(() -> optimizedRes.set(optimized(NTH_NUMBER)));
    ExecutionMeasure.measureExecutionTime(() -> defaultRes.set(defaultImplementation(NTH_NUMBER)));

    assert (optimizedRes.get() == defaultRes.get());
  }

  private static int optimized(int nthNumber) {
    final var valuesMap = new HashMap<Integer, Integer>();
    return optimizedImpl(valuesMap, nthNumber);
  }

  private static Integer optimizedImpl(Map<Integer, Integer> map, int nthNumber) {
    if (nthNumber <= 0) {
      return 0;
    }

    if (nthNumber == 1) {
      return 1;
    }

    if (map.containsKey(nthNumber)) {
      return map.get(nthNumber);
    } else {
      var res = optimizedImpl(map, nthNumber - 1) + optimizedImpl(map, nthNumber - 2);
      map.put(nthNumber, res);
      return res;
    }
  }

  private static int defaultImplementation(int nthNumber) {
    if (nthNumber == 0) {
      return 0;
    }

    if (nthNumber == 1) {
      return 1;
    }

    return defaultImplementation(nthNumber - 1) + defaultImplementation(nthNumber - 2);
  }
}
