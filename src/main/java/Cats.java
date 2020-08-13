import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Cats {
    static WebDriver driver;

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");

//        driver = new ChromeDriver();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("https://playground.learnqa.ru/catalog");

        WebElement cat = driver.findElement(By.xpath("(//div[@class='card custom js_size_flipper'])[1]"));
        WebElement cat1 = driver.findElement(By.xpath("(//div[@class='card custom js_size_flipper'])[2]"));
        WebElement cat2 = driver.findElement(By.xpath("(//div[@class='card custom js_size_flipper'])[3]"));

        Actions actions = new Actions(driver);

        actions.moveToElement(cat).build().perform();
        if (cat.equals(driver.findElement(By.xpath("(//div[@class='card custom js_size_flipper'])[2]"))))
            System.out.println("ok");
        else System.out.println("Not ok");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        actions.moveToElement(cat1).build().perform();
        if (cat1.equals(driver.findElement(By.xpath("(//div[@class='card custom js_size_flipper'])[3]"))))
            System.out.println("ok");
        else System.out.println("Not ok");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        actions.moveToElement(cat2).build().perform();
        if (cat2.equals(driver.findElement(By.xpath("(//div[@class='card custom js_size_flipper'])[2]"))))
            System.out.println("ok");
        else System.out.println("Not ok");

        driver.quit();

    }
}
