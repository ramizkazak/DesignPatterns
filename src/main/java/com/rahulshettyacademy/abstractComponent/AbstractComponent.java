package com.rahulshettyacademy.abstractComponent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public abstract class AbstractComponent {

  WebElement sectionElement;
  WebDriver driver;

    public AbstractComponent(WebDriver driver, By selectionElement) {
        this.driver=driver;
        this.sectionElement =driver.findElement(selectionElement);

    }

    public WebElement findElement(By findElement ){

       return sectionElement.findElement(findElement);
    }

    public List<WebElement> findElements(By findElementBy){
        return  sectionElement.findElements(findElementBy);
    }

    public void  waitForElementToDisappear(By findBy){
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(findBy));
    }
    public void waitElementToClickable(By findBy){
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.elementToBeClickable(findBy));
    }
}
