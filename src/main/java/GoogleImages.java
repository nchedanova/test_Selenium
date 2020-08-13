import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class GoogleImages {
    static WebDriver driver;
    static WebDriverWait wait;

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
        // прописываем путь к chromedriver и geckodriver (firefox)


//          System.setProperty("webdriver.gecko.driver", "C:\\Users\\1\\IdeaProjects\\testselenium\\src\\main\\resources\\geckodriver.exe");

//        driver = new ChromeDriver();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();


        driver.get("https://www.google.com/imghp?hl=en");
        driver.findElement(By.xpath("//div[@aria-label='Search by image']")).click();
        driver.findElement(By.xpath("//a[text()='Upload an image']")).click();
        driver.findElement(By.xpath("//input[@type='file']")).sendKeys("C:\\Users\\raube\\OneDrive\\Рабочий стол\\03_51_02.png");

    }
}
