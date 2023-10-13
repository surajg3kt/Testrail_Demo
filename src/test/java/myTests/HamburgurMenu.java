package myTests;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import base.baseTest;

public class HamburgurMenu extends baseTest
{
 @Test()
 public void menutest()
 {
	 testcaseid="3";
	 driver.findElement(By.xpath("//*[@id='guide-button'])[1]")).click();
	 System.out.println("menu list displayed");
 }
}
