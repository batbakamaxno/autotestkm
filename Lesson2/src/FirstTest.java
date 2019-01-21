import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.xml.bind.Element;
import java.net.URL;
import java.util.List;

public class FirstTest {

    private AppiumDriver driver;

    @Before
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "AndroidTestDevice");
        capabilities.setCapability("platformVersion", "6.0");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("appPackage", "org.wikipedia");
        capabilities.setCapability("appActivity", ".main.MainActivity");
        capabilities.setCapability("app", "/Users/MBPro/Documents/JavaAppiumAutomation/Lesson2/apks/org.wikipedia.apk");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test

    public void firstTest()
    {
        waitForElementAndClick(
                By.xpath("//*[contains(@text,'Search Wikipedia')])"),
                "Cannot find 'Search Wikipedia' input",
                5
        );
        waitForElementAndSendKey(
               By.xpath("//*[contains(@text,'Search…')]") ,
                "Java",
                "Cannot find search input",
                5
        );

        waitForElementPresent(
               By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Object-oriented programming language']"),
                "Cannot find 'Object-oriented programming language' topic searching by 'Java'",
                15
                );



    }
    @Test
    public void testCancelSearch()
    {

        waitForElementAndClick(
                By.id("org.wikipedia:id/search_container"),
                "Cannot find 'Search Wikipedia' input",
                10
        );
//        waitForElementPresentById(
//                "org.wikipedia:id/search_container",
//                "Cannot find 'Search Wikipedia' input",
//                10
//
//        );
        waitForElementAndSendKey(
                By.xpath("//*[contains(@text,'Search…')]") ,
                "Java",
                "Cannot find search input",
                5
        );
        waitForElementAndClear(
                By.id("org.wikipedia:id/search_src_text"),
                "Cannot find search field",
                5

        );

        waitForElementAndClick(
                By.id("org.wikipedia:id/search_close_btn"),
                "Cannot find X to cancel search",
                10
        );

//        waitForElementPresentById(
//                "org.wikipedia:id/search_close_btn",
//                "Cannot find X to cancel search",
//                5
//
//        );

        waitForElementNotPresent(
               By.id("org.wikipedia:id/search_close_btn") ,
                "X is still present on the page",
                5
        );

    }
     @Test
     public  void testCompareArticleTitle()
     {
         waitForElementAndClick(
                 By.id("org.wikipedia:id/search_container"),
                 "Cannot find 'Search Wikipedia' input",
                 10
         );

         waitForElementAndSendKey(
                 By.xpath("//*[contains(@text,'Search…')]") ,
                 "Java",
                 "Cannot find search input",
                 5
         );

         waitForElementAndClick(
                 By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Object-oriented programming language']"),
                 "Cannot find 'Search Wikipedia' input",
                 10
         );

       WebElement title_element =  waitForElementPresent(
                 By.id("org.wikipedia:id/view_page_title_text"),
                 "Cannot find article title",
                 15

         );
       String article_title= title_element.getAttribute("text");
         Assert.assertEquals(
                 "We see unexpected title",
                 "Java (programming language)",
                 article_title
         );


     }
     @Test
     public void ex2TestCreatingMethod() {

         waitForElementAndClick(
                 By.id("org.wikipedia:id/search_container"),
                 "Cannot find 'Search Wikipedia' input",
                 10
         );

//         waitForElementAndSendKey(
//                 By.xpath("//*[contains(@text,'Search…')]"),
//                 "Java",
//                 "Cannot find search input",
//                 5
//         );

         WebElement title_element =  waitForElementPresent(
                 By.id("org.wikipedia:id/search_src_text"),
                 "Cannot find article title",
                 15
         );
         String article_title= title_element.getAttribute("text");
       //  System.out.println(article_title);
         Assert.assertEquals("We see unexpected title",
                 "Search…",article_title
                 );

     }

     @Test
     public void ex3TestCancelSearch()
     {

         waitForElementAndClick(
                 By.id("org.wikipedia:id/search_container"),
                 "Cannot find 'Search Wikipedia' input",
                 10
         );

         waitForElementAndSendKey(
                 By.xpath("//*[contains(@text,'Search…')]") ,
                 "Java",
                 "Cannot find search input",
                 5
         );

         //org.wikipedia:id/search_results_list
         WebElement title_element =  waitForElementPresent(
                 By.id("org.wikipedia:id/search_results_list"),
                 "Cannot find article title",
                 15
         );
         List<WebElement> listResult=title_element.findElements(By.id("org.wikipedia:id/page_list_item_container"));
         listResult.size();
         int L= listResult.size();
       //  System.out.println(listResult.size());
         Assert.assertTrue("List result is empty",
         L>0);


         waitForElementAndClear(
                 By.id("org.wikipedia:id/search_src_text"),
                 "Cannot find search field",
                 5

         );

         waitForElementAndClick(
                 By.id("org.wikipedia:id/search_close_btn"),
                 "Cannot find X to cancel search",
                 10
         );

         waitForElementNotPresent(
                 By.id("org.wikipedia:id/search_close_btn") ,
                 "X is still present on the page",
                 5
         );







     }
     @Test
     public void ex4TestWordCheck()
     {
         waitForElementAndClick(
                 By.id("org.wikipedia:id/search_container"),
                 "Cannot find 'Search Wikipedia' input",
                 10
         );
         String searchvalue = "Java";
         waitForElementAndSendKey(
                 By.xpath("//*[contains(@text,'Search…')]") ,
                 searchvalue,
                 "Cannot find search input",
                 5
         );

         //org.wikipedia:id/search_results_list
         WebElement title_element =  waitForElementPresent(
                 By.id("org.wikipedia:id/search_results_list"),
                 "Cannot find article title",
                 15
         );
//         List<WebElement> listResult=title_element.findElements(By.id("org.wikipedia:id/page_list_item_container"));
//         listResult.size();
//         int L= listResult.size();
//         //  System.out.println(listResult.size());
//         Assert.assertTrue("List result is empty",
//                 L>0);

         List<WebElement> layoutResult = title_element.findElements(By.id("org.wikipedia:id/page_list_item_title"));
         for (WebElement el :layoutResult) {

             String s = el.getText();
             Assert.assertTrue("error",s.equals(searchvalue));

         }





     }

    private WebElement waitForElementPresent(By by, String error_message, long timeoutInSeconds)
    {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");

        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    private WebElement waitForElementPresent(By by, String error_message)
    {
      return waitForElementPresent(by,error_message,5);
    }

    private WebElement waitForElementAndClick(By by, String error_message, long timeoutInSeconds)
    {
        WebElement element = waitForElementPresent(by,error_message,5);
        element.click();
        return element;

    }
    private WebElement waitForElementAndSendKey(By by, String value, String error_message, long timeoutInSeconds) {
        WebElement element = waitForElementPresent(by, error_message, 5);
        element.sendKeys(value);
        return element;
    }

//    private WebElement waitForElementPresentById(String id, String error_message, long timeoutInSeconds)
//    {
//        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
//        wait.withMessage(error_message + "\n");
//        By by = By.id(id);
//        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
//    }
//
//    private WebElement waitForElementByIdAndClick(String id, String error_message, long timeoutInSeconds)
//    {
//        WebElement element = waitForElementPresentById(id,error_message,5);
//        element.click();
//        return element;
//    }

    private boolean waitForElementNotPresent(By by, String error_message, long timeoutInSecond)
    {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSecond);
        wait.withMessage(error_message +"\n");

        return wait.until(
                ExpectedConditions.invisibilityOfElementLocated(by)
        );
    }
    private WebElement waitForElementAndClear(By by, String error_message, long timeoutInSecond)
    {
    WebElement element = waitForElementPresent(by,error_message,timeoutInSecond);
    element.clear();
    return element;
    }


}