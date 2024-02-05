package com.example.tdd.closedLongInterval;

public class ClosedLongInterval {
  private long lowerLimit, upperLimit;

  public ClosedLongInterval(long lowerLimit, long upperLimit) {
    this.lowerLimit = lowerLimit;
    this.upperLimit = upperLimit;
  }

  public boolean contains(long value) {
    return true;
  }
}
