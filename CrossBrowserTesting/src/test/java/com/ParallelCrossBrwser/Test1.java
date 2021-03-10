package com.ParallelCrossBrwser;

import org.testng.annotations.Test;

public class Test1 extends SingleTest{


  @Test
public void workDayTest() {
	driver.get("https://www.facebook.com/");
	System.out.println(driver.getTitle());
}

}
