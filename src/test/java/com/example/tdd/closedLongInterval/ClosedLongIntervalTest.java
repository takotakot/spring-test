package com.example.tdd.closedLongInterval;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.security.InvalidParameterException;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

    @Test
    void 下端と上端が等しい場合はインスタンスが作成できる() {
      var instance = new ClosedLongInterval(3, 3);
      assertInstanceOf(ClosedLongInterval.class, instance);
    }
  }

  @Nested
  class _3_8_に属する {
    ClosedLongInterval interval = new ClosedLongInterval(3, 8);

    @ParameterizedTest
    @ValueSource(longs = {3, 5, 8})
    void 閉区間_3_8_に属する(long value) {
      assertTrue(interval.contains(value));
    }
  }
}
