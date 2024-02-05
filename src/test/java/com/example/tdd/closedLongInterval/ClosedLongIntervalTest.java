package com.example.tdd.closedLongInterval;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.security.InvalidParameterException;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class ClosedLongIntervalTest {
  @Nested
  class インスタンス作成 {
    @Test
    void インスタンス作成ができる() {
      var instance = new ClosedLongInterval(3, 8);
      assertInstanceOf(ClosedLongInterval.class, instance);
    }

    @Test
    void 下端が上端より大きいとInvalidParameterException例外を投げる() {
      assertThrows(InvalidParameterException.class, () -> new ClosedLongInterval(8, 3));
    }
  }
}
