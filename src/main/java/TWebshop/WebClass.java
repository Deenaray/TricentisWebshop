package TWebshop;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;

public class WebClass {
    static WebDriver driver;

    public void openURL() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\DEENARAY\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();
        JavascriptExecutor js=((JavascriptExecutor) driver);
        js.executeScript("window.scrollBy(0,400)", "");
        Thread.sleep(2000);
    }
    public void lapTop() throws InterruptedException {//clicking on laptop
        driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[3]/div/div/div[3]/div[3]/div/div[1]/a/img")).click();
        //adding to cart
        driver.findElement(By.xpath("//input[@id=\"add-to-cart-button-31\"]")).click();
        JavascriptExecutor js=((JavascriptExecutor) driver);
        js.executeScript("window.scrollBy(400,0)", "");
        Thread.sleep(2000);
        //Clicking on cart
        driver.findElement(By.xpath("//*[@id=\"topcartlink\"]/a/span[1]")).click();
        js.executeScript("window.scrollBy(0,300)", "");
        driver.findElement(By.xpath("//input[@id=\"termsofservice\"]")).click();
        driver.findElement(By.xpath("//button[@id=\"checkout\"]")).click();
        Thread.sleep(3000);
    }
    public void book() throws IOException {
        WebElement book=driver.findElement(By.partialLinkText("Books"));
        book.click();
        WebElement drd= driver.findElement(By.xpath("//select[@id=\"products-orderby\"]"));
        Select dropdown=new Select(drd);
        dropdown.selectByIndex(1);
        WebElement dropdwn=  driver.findElement(By.xpath("//Select[@id=\"products-pagesize\"]"));
        Select drpdwn=new Select(dropdwn);
        drpdwn.selectByVisibleText("12");
        TakesScreenshot screenshot=((TakesScreenshot) driver);
        File source=screenshot.getScreenshotAs(OutputType.FILE);
        File destination=new File("src\\main\\java\\TWebshop\\WebClass.java.png");
        FileUtils.copyFile(source,destination);
        driver.getPageSource();
    }
    public void registerPage() throws IOException {
        driver.findElement(By.partialLinkText("Register")).click();
        driver.findElement(By.xpath("//input[@id=\"gender-female\"]")).click();
        driver.findElement(By.xpath("//input[@id=\"FirstName\"]")).sendKeys("Deepika");
        driver.findElement(By.xpath("//input[@id=\"LastName\"]")).sendKeys("Narayan");
        driver.findElement(By.xpath("//input[@id=\"Email\"]")).sendKeys("deepikanarayanappa@gmail.com");
        driver.findElement(By.xpath("//input[@id=\"Password\"]")).sendKeys("1234567890");
        driver.findElement(By.xpath("//input[@id=\"ConfirmPassword\"]")).sendKeys("1234567890");
        driver.findElement(By.xpath("//input[@id=\"register-button\"]")).click();
       // driver.findElement(By.xpath("//input[@class=\"button-1 register-continue-button\"]")).click();
        TakesScreenshot screenshot=((TakesScreenshot) driver);
        File source2=screenshot.getScreenshotAs(OutputType.FILE);
        File destination2=new File("src/test/java/Webshop.feature.java.png");
        FileUtils.copyFile(source2,destination2);

    }
}
