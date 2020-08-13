import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class PalkiSkalki {
    static WebDriver driver;
   static WebDriverWait wait = (new WebDriverWait(driver, 5));

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
        // прописываем путь к chromedriver и geckodriver (firefox)


        //  System.setProperty("webdriver.gecko.driver", "C:\\Users\\1\\IdeaProjects\\testselenium\\src\\main\\resources\\geckodriver.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//        driver.manage().window().maximize();

        //TODO работа с чекбоксами и радиокнопками

//        driver.get("https://tykwa-food.ru/");
        driver.get("https://balashiha.palki-skalki.ru");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/button[text()='Еще']")));

        List<WebElement> cart = driver.findElements(By.xpath("//div[@data-section='recommend']/div[@class='col-xl-4 col-lg-4 col-sm-6 col-xs-12']//a[text()='В корзину']"));
        //    cart.get(3).click();//если нужно выбрать 3 элемент как пример
        if (cart.size() == 6) System.out.println("It's good! ");
        else System.out.println("Fall! ");

        for (WebElement element : cart) {
            element.click();
        }
        driver.findElement(By.xpath("//div[@class='not-empty-basket']")).click();

//        driver.findElement(By.xpath("//a[@data-id='information']")).click();
//        driver.findElement(By.xpath("//ul[@class='popover-nav']//a[text()='Доставка']")).click();
//        driver.findElement(By.xpath("//a[@data-id='information']")).click();
//        driver.findElement(By.xpath("//ul[@class='popover-nav']//a[text()='Франшиза']")).click();


//        information("Доставка");
//        information("Отзывы");
//        information("Акции и новости");
//        information("Франшиза");


//        driver.quit();
    }

    public static void information(String category) {
        String path = String.format("//ul[@class='popover-nav']//a[text()='%s']", category);

        driver.findElement(By.xpath("//a[@data-id='information']")).click();
        driver.findElement(By.xpath(path)).click();
    }
}