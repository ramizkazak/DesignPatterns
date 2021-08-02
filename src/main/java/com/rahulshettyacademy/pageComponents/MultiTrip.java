package com.rahulshettyacademy.pageComponents;

import com.rahulshettyacademy.abstractComponent.AbstractComponent;
import com.rahulshettyacademy.abstractComponent.SearchFlightAvail;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.function.Consumer;

public class MultiTrip extends AbstractComponent implements SearchFlightAvail {
    
    

    private By rb = By.id("ctl00_mainContent_rbtnl_Trip_2");
    private By from =By.id("ctl00_mainContent_ddl_originStation1_CTXT");
    private By to = By.id("ctl00_mainContent_ddl_destinationStation1_CTXT");
    private By to2 = By.id("ctl00_mainContent_ddl_originStation2_CTXT");
    private By to3 = By.id("ctl00_mainContent_ddl_destinationStation2_CTXT");
    private By cb =By.id("ctl00_mainContent_chk_IndArm");
    private By search = By.id("ctl00_mainContent_btn_FindFlights");
    private By modalPopUp =By.id("MultiCityModelAlert");

    public MultiTrip(WebDriver driver, By selectionElement) {
        super(driver, selectionElement);
    }

    @Override
    public void checkAvail(HashMap<String, String> reservationDetails) {

        makeStateReady(s->selectOriginCity(reservationDetails.get("origin")));
        selectDestinationCity(reservationDetails.get("destination"));
        selectDestinationCity2(reservationDetails.get("destination2"));
        selectDestinationCity3(reservationDetails.get("destination3"));
        waitElementToClickable(cb);
        findElement(cb).click();
        findElement(search).click();
    }
    
    public void selectOriginCity(String origin){

        findElement(from).click();
        findElement(By.xpath("//a[@value='"+origin+"']")).click();
    }

    public void selectDestinationCity(String destination){

        findElement(to).click();
        findElement(By.xpath("(//a[@value='"+destination+"'])[2]")).click();
    }


    public void selectDestinationCity2(String destination2){

        findElement(to2).click();
        findElement(By.xpath("(//a[@value='"+destination2+"'])[3]")).click();
    }

    public void selectDestinationCity3(String destination2){

        findElement(to3).click();
        findElement(By.xpath("(//a[@value='"+destination2+"'])[4]")).click();
    }

    public void makeStateReady(Consumer<MultiTrip> consumer){

        System.out.println("I am inside Multi trip");
        findElement(rb).click();
        findElement(modalPopUp).click();
        waitForElementToDisappear(modalPopUp);
        consumer.accept(this);
        System.out.println("I am done");
        /**
         *   AroundMethod
         *   common pre-requires code
         *   execute actual function --> Book/calendar
         *   tear down method
         */
    }


}
