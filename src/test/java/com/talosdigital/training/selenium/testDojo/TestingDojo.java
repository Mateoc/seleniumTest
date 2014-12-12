package com.talosdigital.training.selenium.testDojo;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestingDojo {
	/**
	 * If any field cease to exist the test will fail
	 */
	@Test
	public void testAddDoctor() {
        //WebDriver driver = new SafariDriver();
    	//WebDriver driver = new FirefoxDriver();
    	//System.setProperty("webdriver.chrome.driver", "/Users/mateocarvajal/Downloads/chromedriver");
    	WebDriver driver = new ChromeDriver();
        // Go to page
        driver.get("http://evening-woodland-2196.herokuapp.com/mateo/home");
        //get and click the add doctor option
        WebElement element = driver.findElement(By.linkText("Agregar doctor"));
        element.click();
        //Get the name item and set the value with name
        String name = "Mateo";
        element = driver.findElement(By.id("name"));
        element.sendKeys(name);
        //Get the last_name item and set the value with lastName
        String lastNmae = "Carvajal";
        element = driver.findElement(By.id("last_name"));
        element.sendKeys(lastNmae);
        //Get the telephone item and set the value with phone
        String phone = "333333333";
        element = driver.findElement(By.id("telephone"));
        element.sendKeys(phone);
        //Get the identification_type item and select the second index (pasaportes)
        Select select = new Select(driver.findElement(By.id("identification_type")));
        select.selectByIndex(2);//.selectByVisibleText("Cédula de extrangería");
        //Get the identification item and set the value with id
        String id = "asd123asd";
        element = driver.findElement(By.id("identification"));
        element.sendKeys(id);
        //get the button and submit form
        element = driver.findElement(By.className("btn"));
        element.click();
        //if the next line discommented the test pass only if the user is a new user 
        //element = driver.findElement(By.className("panel-success"));
        //Getting the results and testing them
        assertEquals(name, driver.findElement(By.id("firstName")).getText());
        assertEquals(lastNmae , driver.findElement(By.id("lastName")).getText());
        assertEquals(phone, driver.findElement(By.id("telephone")).getText());
        assertEquals("Pasaportes", driver.findElement(By.id("identificationType")).getText());
        assertEquals(id, driver.findElement(By.id("doctorId")).getText());
	}
	
	@Test
	public void testAddUser() {
        //WebDriver driver = new SafariDriver();
    	//WebDriver driver = new FirefoxDriver();
    	//System.setProperty("webdriver.chrome.driver", "/Users/mateocarvajal/Downloads/chromedriver");
    	WebDriver driver = new ChromeDriver();
        // Go to page
        driver.get("http://evening-woodland-2196.herokuapp.com/mateo/home");
        //get and click the add doctor option
        WebElement element = driver.findElement(By.linkText("Agregar paciente"));
        element.click();
        //Get the name item and set the value with name
        List<WebElement> labels = driver.findElements(By.tagName("input"));
        labels.get(0).sendKeys("Andres");
        /*
        //if the next line discommented the test pass only if the user is a new user 
        //element = driver.findElement(By.className("panel-success"));
        //Getting the results and testing them
        assertEquals(name, driver.findElement(By.id("firstName")).getText());
        assertEquals(lastNmae , driver.findElement(By.id("lastName")).getText());
        assertEquals(phone, driver.findElement(By.id("telephone")).getText());
        assertEquals("Pasaportes", driver.findElement(By.id("identificationType")).getText());
        assertEquals(id, driver.findElement(By.id("doctorId")).getText());*/
	}

}
