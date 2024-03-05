package com.example.demo.dinner_reservation;

public class DinnerReservation {
  long matsuMembers;
  long takeMembers;
  long umeMembers;
  long coupon;

  final private long COUPON_VALUE = 10_000;
  final private long COUPON_LIMIT = 3;

  long getBasicFee() {
    return Course.松.getPrice() * matsuMembers
        + Course.竹.getPrice() * takeMembers
        + Course.梅.getPrice() * umeMembers;
  }

  long getDiscountedFee() {
    long basicFee = getBasicFee();
    if (coupon > COUPON_LIMIT) {
      throw new IllegalStateException();
    }
    if (basicFee < COUPON_VALUE * coupon) {
      throw new IllegalStateException();
    }
    return basicFee - COUPON_VALUE * coupon;
  }

  DinnerReservation addCourse(Course course, long numberOfPeople) {
    if (course == Course.松) {
      matsuMembers = numberOfPeople;
    } else if (course == Course.竹) {
      takeMembers = numberOfPeople;
    } else if (course == Course.梅) {
      umeMembers = numberOfPeople;
    } else {
      throw new IllegalArgumentException();
    }
    return this;
  }

  DinnerReservation setCoupon(long coupon) {
    this.coupon = coupon;
    return this;
  }

  enum Course {
    松(7_000), 竹(5_000), 梅(3_000);

    private final long price;

    Course(long price) {
      this.price = price;
    }

    long getPrice() {
      return price;
    }
  }
}
