import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class PricesInMersin {
    static WebDriver driver;

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
        System.setProperty("phantomjs.binary.path", "src/main/resources/phantomjs.exe");
        // прописываем путь к chromedriver и geckodriver (firefox)
        //  System.setProperty("webdriver.gecko.driver", "C:\\Users\\1\\IdeaProjects\\testselenium\\src\\main\\resources\\geckodriver.exe");

        //  driver = new FirefoxDriver();
        driver = new ChromeDriver();
    //    driver = new PhantomJSDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();

//        driver.get("http://onequestiontr.simplesite.com/");
//        driver.get("https://market.yandex.ru/product--smartfon-samsung-galaxy-a51-64gb/650874000/offers?track=tabs&local-offers-first=0");
//        String mainWindow = driver.getWindowHandle();
          driver.get("http://hikersbay.com/prices/turkey/mersin?lang=ru");
//
//        driver.findElement(By.xpath("//div[@data-zone-name='to-shop']")).click();
//
//        driver.switchTo().window(mainWindow); //переход обратно к основному окну
//        WebElement dropdownArrow = driver.findElement(By.xpath("//a[text()='Полезная информация']/parent::li//i[@class='icon-caret-down']"));
//        WebElement tonkosti = driver.findElement(By.xpath("//a[text()='Тонкости']"));
//        WebElement pricesInMersin = driver.findElement(By.xpath("//div[@class='section article margins-on']//a[contains(text(), 'Цены в Мерсине')]"));
//
//        dropdownArrow.click();
//        tonkosti.click();
//
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        //TODO переключиться на новую вкладку или окно
//        for (String windowHandle : driver.getWindowHandles()) {
//            driver.switchTo().window(windowHandle);
//        }
//
//        Open a new tab using Ctrl + t
//        driver.findElement(By.xpath("//p/a[contains(text(), 'Цены в Мерсине')]")).sendKeys(Keys.CONTROL +"t");
//        Switch between tabs using Ctrl + \t
//             driver.findElement(By.xpath("//p/a[contains(text(), 'Цены в Мерсине')]")).sendKeys(Keys.CONTROL + "\t");
//
//
//        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
//        driver.switchTo().window(tabs2.get(1));
//        driver.close();
//        driver.switchTo().window(tabs2.get(0));
//
//        pricesInMersin.sendKeys(Keys.CONTROL + "\t");
//
//        pricesInMersin.click();
//
//
        WebElement tableElement = driver.findElement(By.xpath("//table [@class='table table-striped table-responsive table-hover table-bordered']"));

        Table table = new Table(tableElement, driver);
        System.out.println("Rows number is: " + table.getRows().size());

        System.out.print(table.getValueFromCell(6, "Средняя цена проживания в Мерсин составляет: "));
        System.out.println(table.getValueFromCell(6, 2));

//        driver.quit();
    }
}
