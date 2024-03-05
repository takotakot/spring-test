package com.example.demo.dinner_reservation;

public class DinnerReservation {
  long getBasicFee() {
    return 0;
  }

  void addCourse(Course course, long numberOfPeople) {
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
