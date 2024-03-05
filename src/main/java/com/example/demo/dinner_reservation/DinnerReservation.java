package com.example.demo.dinner_reservation;

public class DinnerReservation {
  long matsuMembers;
  long takeMembers;

  long getBasicFee() {
    return Course.松.getPrice() * matsuMembers
        + Course.竹.getPrice() * takeMembers;
  }

  void addCourse(Course course, long numberOfPeople) {
    if (course == Course.松) {
      matsuMembers = numberOfPeople;
    } else if (course == Course.竹) {
      takeMembers = numberOfPeople;
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
