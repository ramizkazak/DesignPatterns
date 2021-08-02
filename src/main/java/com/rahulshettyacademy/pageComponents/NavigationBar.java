package com.rahulshettyacademy.pageComponents;

import com.rahulshettyacademy.abstractComponent.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationBar extends AbstractComponent {

    By flights = By.cssSelector("[title='Flights']");
    By links = By.cssSelector("a");

    public NavigationBar(WebDriver driver, By selectionElement) {
        super(driver, selectionElement);
    }

    public String getFlightAttribute(){
      return  findElement(flights).getAttribute("class");

    }
    public int linkCount(){
      return  findElements(links).size();
    }
}
