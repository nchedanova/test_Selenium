import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class SomeActions {
    static WebDriver driver;
    private String cut;

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
        // прописываем путь к chromedriver и geckodriver (firefox)


        //  System.setProperty("webdriver.gecko.driver", "C:\\Users\\1\\IdeaProjects\\testselenium\\src\\main\\resources\\geckodriver.exe");

//        driver = new ChromeDriver();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://ru.ebay.com/");
//TODO Javascript

//        JavascriptExecutor jse = (JavascriptExecutor) driver;
//        jse.executeScript("alert('Good morning');");
//        jse.executeScript("window.scrollBy(0, 2000)", "");
//        jse.executeScript("window.scrollBy(0, -1500)", "");


//        driver.get("https://ru.ebay.com/");
//        jse.executeScript("alert('Good morning');");
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        driver.switchTo().alert().accept();
//        jse.executeScript("confirm('Good morning');");
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        driver.switchTo().alert().dismiss();
//        WebElement link = driver.findElement(By.xpath("//li[@class='hl-cat-nav__js-tab']//a[text()='Электроника']"));
//        WebElement element = driver.findElement(By.xpath("//li[@class='hl-cat-nav__js-tab']//a[text()='Электроника']"));
//
//        Actions actions = new Actions(driver);
//
//        actions.moveToElement(link).build().perform();

//        actions.dragAndDrop(element, link).build().perform();
//
//        actions.clickAndHold(element).moveToElement(link).build().perform();
//
//        actions.doubleClick(element);
//        actions.contextClick(element);
//        Action action = actions.clickAndHold(element).moveToElement(link).release().build();
//
//        action.perform();

        WebElement link1 = driver.findElement(By.xpath("//a[text()='Samsung']"));
        WebElement link2 = driver.findElement(By.xpath("//li/a[text()='Мода']"));

        System.out.println(link1.isDisplayed());
        System.out.println(link2.isDisplayed());
        if(link1.isDisplayed()) link1.click();
        else link2.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement searchInput = driver.findElement(By.xpath("//input[@id='gh-ac']"));
        String select = Keys.chord(Keys.CONTROL, "a");
        String cut = Keys.chord(Keys.CONTROL, "x");
        String paste = Keys.chord(Keys.CONTROL,"v");
        searchInput.sendKeys("Шорты");
        searchInput.sendKeys(select);
        searchInput.sendKeys(cut);
        searchInput.sendKeys(Keys.chord(Keys.SHIFT, "шорты")); //написать заглавными
        searchInput.sendKeys(Keys.ENTER);

        Date dateNow = new Date();
        SimpleDateFormat format = new SimpleDateFormat("hh_mm_ss");
        String fileName = format.format(dateNow) + ".png";

        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); //силениум сделает скриншот
        try {
            FileUtils.copyFile(screenshot,new File("C:\\Users\\raube\\OneDrive\\Рабочий стол\\" + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }


        driver.quit();





    }
}
