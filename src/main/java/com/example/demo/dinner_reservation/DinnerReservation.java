package com.example.demo.dinner_reservation;

public class DinnerReservation {
  long matsuMembers;

  long getBasicFee() {
    // return 0;
    return Course.松.getPrice() * matsuMembers;
  }

  void addCourse(Course course, long numberOfPeople) {
    if (course == Course.松) {
      matsuMembers = numberOfPeople;
    }
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
