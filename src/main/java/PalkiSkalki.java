import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class PalkiSkalki {

    static WebDriver driver;
  //  static WebDriverWait wait = (new WebDriverWait(driver, 5));

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
        // прописываем путь к chromedriver и geckodriver (firefox)
        //  System.setProperty("webdriver.gecko.driver", "C:\\Users\\1\\IdeaProjects\\testselenium\\src\\main\\resources\\geckodriver.exe");

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //     driver.manage().window().maximize();

        driver.get("https://balashiha.palki-skalki.ru/");

 //       wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='Еще']"))); //TODO явное ожидание

        List<WebElement> addToCart = driver.findElements(By.xpath("//div[@data-section='recommend']/div[@class='col-xl-4 col-lg-4 col-sm-6 col-xs-12']//a[text()='В корзину']"));

        if (addToCart.size() == 6) System.out.println("Test is passed");
        else System.out.println("Test is failed");

        //    addToCart.get(3).click(); // добавит в корзину третий по списку элемент

        for (WebElement element : addToCart) {
            element.click();
        }

        driver.findElement(By.xpath("//div[@class='not-empty-basket']")).click();
//        driver.findElement(By.xpath("//a[@data-id='information']")).click();

        //   Dimension d = new Dimension(900,1000);
        //  driver.manage().window().setSize(d);
//
//        driver.findElement(By.xpath("//button[text()='Еще']")).click();
//        driver.findElement(By.xpath("(//button[text()='Еще']/following-sibling::ul/li)[2]")).click();
//
//        driver.findElement(By.xpath("//button[text()='Еще']")).click();
//        if (driver.findElement(By.xpath("(//button[text()='Еще']/following-sibling::ul/li)[1]")).isDisplayed())
//            driver.findElement(By.xpath("//li/a/span[text()='Напитки']")).click();

        //a/span//parent::a[@data-id='information']

//        driver.findElement(By.xpath("//li/a/span[text()='Десерты']")).click();
//       // driver.findElement(By.xpath("(//button[text()='Еще']/following-sibling::ul/li)[2]")).click(); // выбирает второй (n-ый) элемент из выпадающего списка

//        driver.findElement(By.xpath("//button[text()='Еще']")).click();
//     //   driver.findElement(By.xpath("//button[text()='Еще']")).isSelected();
//        driver.findElement(By.xpath("(//button[text()='Еще']/following-sibling::ul/li)[1]")).isEnabled();
//        driver.findElement(By.xpath("//li/a/span[text()='Напитки']")).click();
//        //button[text()='Еще']/following-sibling::ul/li

//        driver.quit();
    }

    public static void selectCategoty(String category) {
        String categoryChooseNumber = "(//button[text()='Еще']/following-sibling::ul/li)['%s']";
        String categoryName = "//li/a/span[text()='%s']";

        driver.findElement(By.xpath("//button[text()='Еще']")).click();
        driver.findElement(By.xpath(categoryName)).click();

    }
}
