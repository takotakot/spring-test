package com.example.tdd.closedLongInterval;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.security.InvalidParameterException;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
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

    @ParameterizedTest
    @ValueSource(longs = {2, 9})
    void 閉区間_3_8_に属さない(long value) {
      assertFalse(interval.contains(value));
    }
  }

  @Nested
  class 文字列表記 {
    @ParameterizedTest
    @CsvSource({"3, 8, '[3, 8]'", "0, 0, '[0, 0]'"})
    void 区間の文字列表記が返される(long lowerLimit, long upperLimit, String expected) {
      var interval = new ClosedLongInterval(lowerLimit, upperLimit);
      assertEquals(expected, interval.toString());
    }
  }

  @Nested
  class 等価な閉区間 {
    @ParameterizedTest
    @CsvSource({"3, 8, 3, 8, true", "3, 8, 0, 8, false", "3, 8, 3, 5, false"})
    void 等価な閉区間が判定できる(long lowerLimit, long upperLimit, long otherLowerLimit, long otherUpperLimit,
        boolean expected) {
      var interval = new ClosedLongInterval(lowerLimit, upperLimit);
      var other = new ClosedLongInterval(otherLowerLimit, otherUpperLimit);
      assertEquals(expected, interval.equals(other));
    }

    @Test
    void nullとは等しくない() {
      ClosedLongInterval interval = new ClosedLongInterval(3, 8);
      assertFalse(interval.equals(null));
    }
  }

  @Nested
  class 包含 {
    @ParameterizedTest
    @CsvSource({"3, 8, 3, 8, true", "3, 8, 4, 7, true", "3, 8, 0, 4, false"})
    void 包含関係が判定できる(long lowerLimit, long upperLimit, long otherLowerLimit, long otherUpperLimit,
        boolean expected) {
      var interval = new ClosedLongInterval(lowerLimit, upperLimit);
      var other = new ClosedLongInterval(otherLowerLimit, otherUpperLimit);
      assertEquals(expected, interval.contains(other));
    }

    @Test
    void nullとは包含関係にない() {
      ClosedLongInterval interval = new ClosedLongInterval(3, 8);
      assertFalse(interval.contains(null));
    }
  }
}
