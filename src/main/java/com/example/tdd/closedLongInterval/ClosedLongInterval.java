package com.example.tdd.closedLongInterval;

import java.security.InvalidParameterException;

/**
 * 閉区間を表すクラス
 */
public class ClosedLongInterval {
  private long lowerLimit, upperLimit;

  /**
   * コンストラクタ
   *
   * @param lowerLimit 下端
   * @param upperLimit 上端
   * @throws InvalidParameterException 下端が上端より大きい場合
   */
  public ClosedLongInterval(long lowerLimit, long upperLimit) {
    if (lowerLimit > upperLimit) {
      throw new InvalidParameterException();
    }
    this.lowerLimit = lowerLimit;
    this.upperLimit = upperLimit;
  }

  /**
   * 閉区間に含まれるかどうか判定
   *
   * @param value 判定する値
   * @return 値が閉区間に含まれる場合は{@code true}、そうでない場合は{@code false}
   */
  public boolean contains(long value) {
    return lowerLimit <= value && value <= upperLimit;
  }

  /**
   * 指定した閉区間がこの閉区間に含まれるかどうか判定
   *
   * @param other 判定する閉区間
   * @return 閉区間がこの閉区間に含まれる場合は{@code true}、そうでない場合は{@code false}
   */
  public boolean contains(ClosedLongInterval other) {
    if (other == null) {
      return false;
    }
    return lowerLimit <= other.lowerLimit && other.upperLimit <= upperLimit;
  }

  /**
   * 閉区間の文字列表現
   *
   * @return 閉区間の文字列表現
   */
  @Override
  public String toString() {
    return String.format("[%d, %d]", lowerLimit, upperLimit);
  }

  /**
   * 指定した閉区間がこの閉区間と等しいかどうか判定
   *
   * @param other 比較する閉区間
   * @return 閉区間が等しい場合は{@code true}、そうでない場合は{@code false}
   */
  public boolean equals(ClosedLongInterval other) {
    if (other == null) {
      return false;
    }
    return lowerLimit == other.lowerLimit && upperLimit == other.upperLimit;
  }
}
