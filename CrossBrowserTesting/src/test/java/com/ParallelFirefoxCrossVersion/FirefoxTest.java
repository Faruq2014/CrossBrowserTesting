package com.ParallelFirefoxCrossVersion;

import org.testng.annotations.Test;

public class FirefoxTest extends FirefoxBaseTest {
@Test
public void urlTest() {
	System.out.println(driver.getCurrentUrl());
}
}
