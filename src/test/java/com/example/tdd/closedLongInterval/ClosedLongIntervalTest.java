package com.example.tdd.closedLongInterval;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class ClosedLongIntervalTest {
	@Nested
	class インスタンス作成 {
		@Test
		void インスタンス作成ができる() {
			var instance = new ClosedLongInterval(3, 8);
			assertInstanceOf(ClosedLongInterval.class, instance);
		}
	}
}
