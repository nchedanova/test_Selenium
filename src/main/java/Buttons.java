import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Buttons {
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


        driver.get("http://gnatkovsky.com.ua/files/neaktivknopka/index.html");
        WebElement disabledButton = driver.findElement(By.xpath("//input[@value='Отправить']"));
        WebElement abledButton = driver.findElement(By.xpath("//input[@value='Отправить']"));


        System.out.println("The button is enable: " + disabledButton.isEnabled());

        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("1234");
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("1234");
        driver.findElement(By.xpath("//input[@type='tel']")).sendKeys("1234");

        System.out.println("The button is enable: " + abledButton.isEnabled());
        if (disabledButton.isEnabled()) disabledButton.click();
        if (abledButton.isEnabled()) abledButton.click();
        if (driver.findElements(By.xpath("//input[@type='tel']")).size() > 0) System.out.println("Such element is present");
        else System.out.println("Cannot find such element");


        driver.quit();
    }
}
