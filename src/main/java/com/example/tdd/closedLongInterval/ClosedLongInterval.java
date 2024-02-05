package com.example.tdd.closedLongInterval;

import java.security.InvalidParameterException;

public class ClosedLongInterval {
  private long lowerLimit, upperLimit;

  public ClosedLongInterval(long lowerLimit, long upperLimit) {
    if (lowerLimit > upperLimit) {
      throw new InvalidParameterException();
    }
    this.lowerLimit = lowerLimit;
    this.upperLimit = upperLimit;
  }

  public boolean contains(long value) {
    return lowerLimit <= value && value <= upperLimit;
  }

  public boolean contains(ClosedLongInterval other) {
    if (other == null) {
      return false;
    }
    return lowerLimit <= other.lowerLimit && other.upperLimit <= upperLimit;
  }

  @Override
  public String toString() {
    return String.format("[%d, %d]", lowerLimit, upperLimit);
  }

  public boolean equals(ClosedLongInterval other) {
    if (other == null) {
      return false;
    }
    return lowerLimit == other.lowerLimit && upperLimit == other.upperLimit;
  }
}
