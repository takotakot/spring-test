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

/**
 * 閉区間を表すクラスのテスト
 *
 * <pre>
 * - [ ] 整数閉区間を示すクラス（構造体）を作る
 *   - [ ] コンストラクタに、上端・下端を与えるとインスタンスが作成される
 * 
 * - [ ] 下端点より上端点の方が小さい閉区間は作ることができない
 *   - [ ] [3, 8] を与えると例外を throw しない
 *   - [ ] [8, 3] を与えると例外を throw する 下端が上端より大きいとInvalidParameterException例外を投げる
 *   - [ ] [3, 3] を与えると例外を throw しない 下端と上端が等しい場合はインスタンスが作成できる
 *
 * - [ ] 任意の整数を入力すると、閉区間に含むかどうか判定できる
 *   - [ ] 閉区間が [3, 8] のときに、3 が与えられると true (3は)閉区間[3, 8]に属する
 *   - [ ] 閉区間が [3, 8] のときに、5 が与えられると true 閉区間[3, 8]に属する
 *   - [ ] 閉区間が [3, 8] のときに、8 が与えられると true 閉区間[3, 8]に属する
 *   - [ ] 閉区間が [3, 8] のときに、9 が与えられると false 閉区間[3, 8]に属さない
 *   - [ ] 閉区間が [3, 8] のときに、2 が与えられると false 閉区間[3, 8]に属さない
 *
 * - [ ] 整数閉区間を示す文字列表現を返すことができる
 *   - [ ] [3, 8] の文字列表記が "[3, 8]" を返す
 *   - [ ] [0, 0] の文字列表記が "[0, 0]" を返す
 *
 * - [ ] 任意の閉区間を与えると、閉区間と等価かどうかや、完全に含まれるかどうかを判定できる
 *   - [ ] 等価
 *     - [ ] [3, 8] は [3, 8] と等価である
 *     - [ ] [3, 8] は [0, 8] と等価ではない
 *     - [ ] [3, 8] は [3, 5] と等価ではない
 *     - [ ] + [3, 8] は null と等価ではない
 *   - [ ] 包含
 *     - [ ] [3, 8] は [3, 8] を含む
 *     - [ ] [3, 8] は [4, 7] を含む
 *     - [ ] [3, 8] は [0, 4] を含まない
 *     - [ ] + [3, 8] は null を含まない
 * </pre>
 */
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
