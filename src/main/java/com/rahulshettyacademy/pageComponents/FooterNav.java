package com.rahulshettyacademy.pageComponents;

import com.rahulshettyacademy.abstractComponent.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FooterNav extends AbstractComponent {

    WebDriver driver ;
    By flights = By.cssSelector("[title='Flights']");
    By links = By.cssSelector("a");

    public FooterNav(WebDriver driver, By selectionElement) {
        super(driver, selectionElement );        //when you inherit parent class - you should invoke parents class constructor
                        //in your own child constructor
    }


    //method to handle flights
    //when selenium executes any method in this class scope of selenium
    //should be in the footer only


    public String getFlightAttribute(){

        return findElement(flights).getAttribute("class");
        // driver.findElement(flights).click();
    }

    public int getLinkCount(){
        return findElements(links).size();
    }
}
