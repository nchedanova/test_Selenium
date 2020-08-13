import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Buttons {
    static WebDriver driver;

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
        // прописываем путь к chromedriver и geckodriver (firefox)
        //  System.setProperty("webdriver.gecko.driver", "C:\\Users\\1\\IdeaProjects\\testselenium\\src\\main\\resources\\geckodriver.exe");

          driver = new FirefoxDriver();
//        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("http://gnatkovsky.com.ua/files/neaktivknopka/index.html");

        //TODO проверка кнопок (активная или неактивная)
        WebElement disabledButton = driver.findElement(By.xpath("//input[@value='Отправить']"));
        WebElement ableButton = driver.findElement(By.xpath("//input[@value='Отправить']"));

        System.out.println("The button is enable: " +  disabledButton.isEnabled());

        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("2147892348953");
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("744757");
        driver.findElement(By.xpath("//input[@type='tel']")).sendKeys("48586");

        System.out.println("The button is enable: " + ableButton.isEnabled());

        if (disabledButton.isEnabled()) disabledButton.click();
        if (ableButton.isEnabled()) ableButton.click();

        //TODO есть ли элемент на странице
        if (driver.findElements(By.xpath("//input[@type='tel']")).size() > 0) System.out.println("Element is presented");
        else System.out.println("Element not found");

        driver.quit();

    }
}
