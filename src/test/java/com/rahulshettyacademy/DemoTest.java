package com.rahulshettyacademy;


import com.rahulshettyacademy.pageObjects.TravelHomePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.List;

public class DemoTest extends BaseTest {
    WebDriver driver;
    TravelHomePage travelHomePage;

    @BeforeTest
    public void setup(){

        driver =initializerDriver();
       travelHomePage = new TravelHomePage(driver);
    }

    @Test(dataProvider = "getData")
    public void flightTest(HashMap<String,String > reservationDetails) {

        travelHomePage.goTo();
        System.out.println(travelHomePage.getFooterNavigation().getFlightAttribute());
        System.out.println(travelHomePage.getNavigationBar().getFlightAttribute());
        System.out.println(travelHomePage.getFooterNavigation().getLinkCount());
        System.out.println(travelHomePage.getNavigationBar().linkCount());

        travelHomePage.setBookingStrategy("multitrip");
        travelHomePage.checkAvail(reservationDetails);


    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }

    /**
     *we used hashmap, dataProvider, json, jackson, list
     *
     */

    @DataProvider
    public Object[][] getData(){

      List<HashMap<String,String>> list=  getJsonData(System.getProperty("user.dir")+"//src//test//java//com//rahulshettyacademy//dataLoads//reservationDetails.json");
        return new Object[][]{
                {list.get(0)}, {list.get(1)}
        };
    }
}
