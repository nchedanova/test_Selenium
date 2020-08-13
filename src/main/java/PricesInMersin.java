import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class PricesInMersin {
    static WebDriver driver;

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
        // прописываем путь к chromedriver и geckodriver (firefox)


//          System.setProperty("webdriver.gecko.driver", "C:\\Users\\1\\IdeaProjects\\testselenium\\src\\main\\resources\\geckodriver.exe");

//        driver = new ChromeDriver();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//        driver.manage().window().maximize();

        //TODO работа с чекбоксами и радиокнопками

        driver.get("https://market.yandex.ru/product--smartfon-honor-30-pro-8-256gb/661223003/offers?track=tabs&local-offers-first=0");
        String mainWindow = driver.getWindowHandle();

        driver.findElement(By.xpath("//div[@data-zone-name='to-shop']")).click();
        driver.switchTo().window(mainWindow);


////        driver.get("http://hikersbay.com/prices/turkey/mersin?lang=ru");
//        WebElement dropdownArow = driver.findElement(By.xpath("//a[text()='Полезная информация']/parent::li//i[@class='icon-caret-down']"));
//        WebElement tonkosti = driver.findElement(By.xpath("//a[text()='Тонкости']"));
//        WebElement price = driver.findElement(By.xpath("//div[@class='content']//a[contains(text(),'Цены в Мерсине')]"));
//
        WebElement tableElement = driver.findElement(By.xpath("//table[@class='table table-striped table-responsive table-hover table-bordered']"));
//
//        dropdownArow.click();
//        tonkosti.click();
//
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        for (String windowHandle : driver.getWindowHandles()){
            driver.switchTo().window(windowHandle);
        }

//        price.click();





        Table table = new Table(tableElement, driver);
        System.out.println("Rows number is " + table.getRows().size());
        System.out.println(table.getValueFromCell(4,3));
        System.out.println(table.getValueFromCell(3,2));
        System.out.println(table.getValueFromCell(3,"41 USD"));
        System.out.println(table.getValueFromCell(3,"35 EURO"));

//        driver.quit();
    }
}
//a[text()='Полезная информация']/parent::li//i[@class='icon-caret-down']








