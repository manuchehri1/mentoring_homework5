package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CalendarEventsPage;
import pages.LoginPage;
import utilities.BrowserUtils;
import utilities.Driver;

import java.util.List;

public class CalendarEventsTests extends AbstractTestBase {
    public WebDriver driver = Driver.getDriver();
    LoginPage loginPage=new LoginPage();
    CalendarEventsPage calendarEventsPage = new CalendarEventsPage();






    /**
     * Test Case #1
     * 1. Go to “https://qa1.vytrack.com/"
     * 2. Login as a store manager
     * 3. Navigate to “Activities -> Calendar Events”
     * 4. Hover on three dots “…” for “Testers meeting”
     * calendar event
     * 5. Verify that “view”, “edit” and “delete” options
     * are available
     */
    @Test
    public void test1(){

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        calendarEventsPage.navigateTo("Activities","Calendar Events");
        calendarEventsPage.hoverOverThreeDots();
        Assert.assertTrue(calendarEventsPage.view.isDisplayed());
        Assert.assertTrue(calendarEventsPage.edit.isDisplayed());
        Assert.assertTrue(calendarEventsPage.delete.isDisplayed());




    }

    /**
     * Test Case #2
     * 1. Go to “https://qa1.vytrack.com/"
     * 2. Login as a store manager
     * 3. Navigate to “Activities -> Calendar Events”
     * 4. Click on “Grid Options” button
     * 5. Deselect all options except “Title”
     * 6. Verify that “Title” column still displayed
     */
    @Test
    public void test2(){
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        calendarEventsPage.navigateTo("Activities","Calendar Events");
        calendarEventsPage.gridOptions.click();
        BrowserUtils.wait(2);
        List<WebElement> gridOptionCheckBox = driver.findElements(By.xpath("//input[@data-role='renderable']"));
        for (int i = 1; i <gridOptionCheckBox.size() ; i++) {
            BrowserUtils.wait(1);
            gridOptionCheckBox.get(i).click();
            BrowserUtils.wait(1);
        }
        Assert.assertTrue(calendarEventsPage.titleColumn.isDisplayed());

    }

    /**
     * Test Case #3
     * 1. Go to “https://qa1.vytrack.com/"
     * 2. Login as a store manager
     * 3. Navigate to “Activities -> Calendar Events”
     * 4. Click on “Create Calendar Event” button
     * 5. Expand “Save And Close” menu
     * 6. Verify that “Save And Close”, “Save And New”
     * and “Save” options are available
     */

    @Test
    public void test3(){
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        calendarEventsPage.navigateTo("Activities","Calendar Events");

    }

    /**
     * Test Case #4
     * 1. Go to “https://qa1.vytrack.com/"
     * 2. Login as a store manager
     * 3. Navigate to “Activities -> Calendar Events”
     * 4. Click on “Create Calendar Event” button
     * 5. Then, click on “Cancel” button
     * 6. Verify that “All Calendar Events” page subtitle is
     * displayed
     */


    @Test
    public void test4(){
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        calendarEventsPage.navigateTo("Activities","Calendar Events");
    }

    /**
     * Test Case #5
     * 1. Go to “https://qa1.vytrack.com/"
     * 2. Login as a store manager
     * 3. Navigate to “Activities -> Calendar Events”
     * 4. Click on “Create Calendar Event” button
     * 5. Verify that difference between end and start time
     * is exactly 1 hour
     */

    @Test
    public void test5(){

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        calendarEventsPage.navigateTo("Activities","Calendar Events");
        calendarEventsPage.clickToCreateCalendarEvent();
        Assert.assertTrue(calendarEventsPage.getTimeDiff()==1);

    }

    /**
     * Test Case #6
     * 1. Go to “https://qa1.vytrack.com/"
     * 2. Login as a store manager
     * 3. Navigate to “Activities -> Calendar Events”
     * 4. Click on “Create Calendar Event” button
     * 5. Select “9:00 PM” as a start time
     * 6. Verify that end time is equals to “10:00 PM”
     */

    @Test
    public void test6(){
        WebDriver driver= Driver.getDriver();
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        calendarEventsPage.navigateTo("Activities","Calendar Events");
        calendarEventsPage.clickToCreateCalendarEvent();
        calendarEventsPage.startTime.click();

        Actions actions = new Actions(driver);

        actions.moveToElement(calendarEventsPage.startTime900PM).pause(2000).click().perform();

        Assert.assertEquals(calendarEventsPage.getEndTime(),"10:00 PM");


    }

    /**
     * Test Case #7
     * 1. Go to “https://qa1.vytrack.com/"
     * 2. Login as a store manager
     * 3. Navigate to “Activities -> Calendar Events”
     * 4. Click on “Create Calendar Event” button
     * 5. Select “All-Day Event” checkbox
     * 6. Verify that “All-Day Event” checkbox is selected
     * 7. Verify that start and end time input boxes are
     * not displayed
     * 8. Verify that start and end date input boxes are
     * displayed
     */

    @Test
    public void test7() {

    }


    /**
     * Test Case #8
     * 1. Go to “https://qa1.vytrack.com/"
     * 2. Login as a store manager
     * 3. Navigate to “Activities -> Calendar Events”
     * 4. Click on “Create Calendar Event” button
     * 5. Select “Repeat” checkbox
     * 6. Verify that “Repeat” checkbox is selected
     * 7. Verify that “Daily” is selected by default and
     * following options are available in
     * “Repeats” drop-down:
     */

    @Test
    public void test8(){


    }


    /**
     * Test Case #9
     * 1. Go to “https://qa1.vytrack.com/"
     * 2. Login as a store manager
     * 3. Navigate to “Activities -> Calendar Events”
     * 4. Click on “Create Calendar Event” button
     * 5. Select “Repeat” checkbox
     * 6. Verify that “Repeat” checkbox is selected
     * 7. Verify that “Repeat Every” radio button is
     * selected
     * 8. Verify that “Never” radio button is selected as an
     * “Ends” option.
     * 9. Verify that following message as a summary is
     * displayed: “Summary: Daily every 1 day”
     */

    @Test
    public void test9(){


    }

    /**
     * Test Case #10
     * 1. Go to “https://qa1.vytrack.com/"
     * 2. Login as a store manager
     * 3. Navigate to “Activities -> Calendar Events”
     * 4. Click on “Create Calendar Event” button
     * 5. Select “Repeat” checkbox
     * 6. Select “After 10 occurrences” as an “Ends”
     * option.
     * 7. Verify that following message as a summary is
     * displayed: “Summary: Daily every 1 day, end
     * after 10 occurrences”
     */

    @Test
    public void test10(){

    }


    /**
     * Test Case #11
     * 1. Go to “https://qa1.vytrack.com/"
     * 2. Login as a store manager
     * 3. Navigate to “Activities -> Calendar Events”
     * 4. Click on “Create Calendar Event” button
     * 5. Select “Repeat” checkbox
     * 6. Select “By Nov 18, 2021” as an “Ends” option.
     * 7. Verify that following message as a summary is
     * displayed: “Summary: Daily every 1 day, end by
     * Nov 18, 2021”
     */


    @Test
    public void test11(){

    }

    /**
     * Test Case #12
     * 1. Go to “https://qa1.vytrack.com/"
     * 2. Login as a store manager
     * 3. Navigate to “Activities -> Calendar Events”
     * 4. Click on “Create Calendar Event” button
     * 5. Select “Repeat” checkbox
     * 6. Select “Weekly” options as a “Repeat” option
     * 7. Select “Monday and Friday” options as a
     * “Repeat On” options
     * 8. Verify that “Monday and Friday” options are
     * selected
     * 9. Verify that following message as a summary is
     * displayed: “Summary: Weekly every 1 week on
     * Monday, Friday”
     */

    @Test
    public void test12(){


    }

}
