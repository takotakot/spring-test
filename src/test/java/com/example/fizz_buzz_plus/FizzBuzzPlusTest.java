package com.example.fizz_buzz_plus;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

/**
 * <pre>
 * - 入力した整数が3の倍数または3を含む数字の場合にFizz
 *   - 3の場合にFizz
 *   - 6の場合にFizz
 *   - 13の場合にFizz
 *   - 31の場合にFizz
 * - 入力した整数が5の倍数または5を含む数字の場合にBuzz
 *   - 5の場合にBuzz
 *   - 10の場合にBuzz
 *   - 35の場合にBuzz
 *   - 52の場合にBuzz
 *   - 51の場合にBuzz
 * - 入力した整数が3と5の倍数の場合にFizzBuzz
 *   - 15の場合にFizzBuzz
 *   - 30の場合にFizzBuzz
 *   - 90の場合にFizzBuzz
 * - それ以外の場合はアラビア数字をそのまま文字列で返す
 *   - 7の場合に"7"
 *   - 19の場合に"19"
 * ただし、優先度は、3と5の倍数 > 5の倍数 > 3の倍数の順である。
 * </pre>
 */
public class FizzBuzzPlusTest {
  @Nested
  class 入力した整数が3の倍数または3を含む数字の場合にFizz {
    @Test
    public void _3の倍数() {
    }
  }

  @Nested
  class 入力した整数が5の倍数または5を含む数字の場合にBuzz {
    @Test
    public void _5の倍数() {
    }
  }

  @Nested
  class 入力した整数が3と5の倍数の場合にFizzBuzz {
    @Test
    public void _3と5の倍数() {
    }
  }

  @Nested
  class それ以外の場合はアラビア数字をそのまま文字列で返す {
    @Test
    public void _アラビア数字をそのまま() {
    }
  }
}
