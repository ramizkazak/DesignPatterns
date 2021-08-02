package com.rahulshettyacademy.pageObjects;

import com.rahulshettyacademy.abstractComponent.SearchFlightAvail;
import com.rahulshettyacademy.abstractComponent.StrategyFactor;
import com.rahulshettyacademy.pageComponents.FooterNav;
import com.rahulshettyacademy.pageComponents.NavigationBar;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;

public class TravelHomePage {

    WebDriver driver;
    By selectionElement = By.id("traveller-home");
    By headerNavSectionElement = By.id("buttons");
    SearchFlightAvail searchFlightAvail;

    public TravelHomePage(WebDriver driver) {
        this.driver=driver;
    }


    public void goTo(){
        driver.get("https://rahulshettyacademy.com/dropdownsPractise");
    }

    public NavigationBar getNavigationBar(){

        return new NavigationBar(driver,headerNavSectionElement );
    }

    public  FooterNav getFooterNavigation(){

        return new FooterNav(driver, selectionElement);
    }

    public void setBookingStrategy(String  strategyType){
        StrategyFactor strategyFactor = new StrategyFactor(driver);
        searchFlightAvail = strategyFactor.createStrategy(strategyType);
       this.searchFlightAvail= searchFlightAvail;

    }

    public void checkAvail(HashMap<String,String > reservationDetails){

        searchFlightAvail.checkAvail(reservationDetails);
    }
    public String getTitle(){
        System.out.println("Hello");
        return driver.getTitle();
    }



    }



