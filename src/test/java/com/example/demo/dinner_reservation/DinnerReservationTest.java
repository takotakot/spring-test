package com.example.demo.dinner_reservation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

/**
 * <pre>
 * - 「予約」という概念をもつ
 * - コースと人数を受け付け、基本料金・総額を計算できる
 *   - 初期状態では総額が0円
 *   - 松は7,000円かける人数である
 *     - 松3人は21,000円
 *   - 竹は5,000円かける人数である
 *     - 竹4人は20,000円
 *   - 梅は3,000円かける人数である
 *     - 梅2人は6,000円
 *   - 複数のコースを受付可能
 *     - 松1人、竹2人、梅3人は26,000円
 * - クーポンを使用できる
 *   - 10,000円以上の総額の場合、クーポンが1枚まで使用でき、10,000円値引きされる
 *     - 梅3人はクーポン1枚を使用できない
 *     - 竹2人はクーポン1枚を使用でき、割引後0円
 *     - 梅4人はクーポン1枚を使用でき、割引後2,000円
 *   - 20,000円以上の総額の場合、クーポンが2枚まで使用でき、20,000円値引きされる
 *     - 梅4人はクーポン2枚を使用できない
 *     - 竹4人はクーポン2枚を使用でき、割引後0円
 *     - 梅7人はクーポン2枚を使用でき、割引後1,000円
 *   - 30,000円以上の総額の場合、クーポンが3枚まで使用でき、30,000円値引きされる
 *     - 梅7人はクーポン3枚を使用できない
 *     - 梅10人はクーポン3枚を使用でき、割引後0円
 *     - 梅11人はクーポン3枚を使用でき、割引後3,000円
 * </pre>
 */
public class DinnerReservationTest {
  DinnerReservation instance;

  @BeforeEach
  void setup() {
    instance = new DinnerReservation();
  }

  @Test
  public void 初期状態では総額が0円() {
    assertEquals(0, instance.getBasicFee());
  }

  @Nested
  class 松コース {
    @Test
    public void 松3人は21_000円() {
      instance.addCourse(DinnerReservation.Course.松, 3);
      assertEquals(21_000, instance.getBasicFee());
    }
  }

  @Nested
  class 竹コース {
    @Test
    public void 竹4人は20_000円() {
      instance.addCourse(DinnerReservation.Course.竹, 4);
      assertEquals(20_000, instance.getBasicFee());
    }
  }

  @Nested
  class 梅コース {
    @Test
    public void 梅2人は6_000円() {
      instance.addCourse(DinnerReservation.Course.梅, 2);
      assertEquals(6_000, instance.getBasicFee());
    }
  }

  @Nested
  class 複数のコース {
    @Test
    public void 松1人_竹2人_梅3人は26_000円() {
      instance.addCourse(DinnerReservation.Course.松, 1)//
          .addCourse(DinnerReservation.Course.竹, 2)//
          .addCourse(DinnerReservation.Course.梅, 3);
      assertEquals(26_000, instance.getBasicFee());
    }
  }

  @Nested
  class クーポンを1枚利用 {
    @Test
    public void 梅3人はクーポン1枚を使用できない() {
      instance.addCourse(DinnerReservation.Course.梅, 3)//
          .setCoupon(1);
      assertThrows(IllegalStateException.class, () -> instance.getDiscountedFee());
    }
  }
}
