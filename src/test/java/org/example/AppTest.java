package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.ResourceBundle;

public class AppTest {
    WebDriver driver;
    //make 3 methods for setup,close,getTitle
    @BeforeClass
    @Parameters({"browser","url"})
    void setDriver(String browser,String link){
        if(browser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver();
        }
        else if(browser.equalsIgnoreCase("edge")){
            WebDriverManager.firefoxdriver().setup();
            driver=new FirefoxDriver();
        }


        driver.get(link);
        driver.manage().window().maximize();
    }
    @Test
    public void getLogin()  {
        ResourceBundle r= ResourceBundle.getBundle("config");
        String username=r.getString("username");
        String password=r.getString("password");
        driver.findElement(By.xpath("//*[@id=\"identifierId\"]")).sendKeys(username);// relative path
        driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button/span")).click();
        driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")).sendKeys(password);// relative path
        driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/div/button/span")).click();

    }
}