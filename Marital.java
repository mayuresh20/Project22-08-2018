package com.datadriven.test;

import java.util.ArrayList;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.utility.util;

public class MaritalTest {

	WebDriver driver;

@BeforeMethod
public void setup() throws Exception{
	
	driver = new FirefoxDriver();
	driver.manage().window().maximize();
	Thread.sleep(5000);
	driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	driver.get("http://techbuzzbusinessgroup.com/amat/test/index.php");
	driver.findElement(By.xpath("html/body/div[2]/div/div/a")).click();
	
}	


@DataProvider
public Iterator<Object[]> getTestData(){
	ArrayList<Object[]> testdata = util.getDataFromExcel();
	return testdata.iterator();
	}

	
@Test(dataProvider = "getTestData")
	public void merital(String ProfileFor, String Name, String Gender, String day, String month, String year, String Age, String Religion, String MotherTongue) throws Exception{
		
	Select s = new Select(driver.findElement(By.xpath(".//*[@id='Profile_for']")));
	s.selectByVisibleText(ProfileFor);
	

	driver.findElement(By.xpath("//input[@name='name']")).clear();
	driver.findElement(By.xpath("//input[@name='name']")).sendKeys(Name);

	if(Gender.equals("Male")){
		driver.findElement(By.xpath("//input[@value='Male']")).click();
		} else if (Gender.equals("Female")){
			driver.findElement(By.xpath("//input[@value='Female']")).click();
				}
	driver.findElement(By.xpath("//input[@name='bdate']")).click();
	driver.findElement(By.xpath("//select[@data-handler='selectYear']")).sendKeys(year);
	
	driver.findElement(By.xpath("//select[@data-handler='selectMonth']")).click();
	driver.findElement(By.xpath("//select[@data-handler='selectMonth']")).sendKeys(month);
	Thread.sleep(2000);
	
	driver.findElements(By.xpath("//a[@class='ui-state-default']")).iterator();
	iterator E = new 
	
	Thread.sleep(2000);
		
	Select s4 = new Select(driver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/table/tbody/tr[1]/td[4]/a")));
	s4.selectByVisibleText(day);
   
	driver.findElement(By.xpath("//input[@name='age']")).clear();
	driver.findElement(By.xpath("//input[@name='age']")).sendKeys(Age);
	
	Select s1 = new Select(driver.findElement(By.xpath("//select[@name='religion']")));
	s1.selectByVisibleText(Religion);
	
	Select s2 = new Select(driver.findElement(By.xpath("//select[@name='Mothertounge']")));
	s2.selectByVisibleText(MotherTongue);
	
}
	
	@AfterTest
	public void tearDown(){
		driver.quit();
	}
	
}
