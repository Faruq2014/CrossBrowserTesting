package com.ParallelFramework;

import org.testng.annotations.Test;

public class FacebookTest extends BaseTest{


  @Test
public void titleTest() {
	driver.get("https://www.facebook.com/");
	System.out.println(driver.getTitle());
}
  @Test
  public void urlTest() {
  	driver.get("https://www.facebook.com/");
  	System.out.println(driver.getCurrentUrl());
  }

}
