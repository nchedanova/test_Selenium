import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
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

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
        // прописываем путь к chromedriver и geckodriver (firefox)
        //  System.setProperty("webdriver.gecko.driver", "C:\\Users\\1\\IdeaProjects\\testselenium\\src\\main\\resources\\geckodriver.exe");

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //     driver.manage().window().maximize();


        JavascriptExecutor jse = (JavascriptExecutor) driver;
//        jse.executeScript("window.scrollBy(0, 1000)", ""); // откроет страницу и проскроллит её вниз на 1000px
//        jse.executeScript("window.scrollBy(0, -500)", ""); // откроет страницу и проскроллит её вверх на 500px

        driver.get("https://www.ebay.com/");

        //TODO виден ли элемент на странице (isDisplayed)
        WebElement hiddenLink = driver.findElement(By.xpath("//a[text()='Бижутерия']"));
        WebElement availableLink = driver.findElement(By.xpath("//li/a[text()='Красота и здоровье']"));

        System.out.println("This link is available now: " + hiddenLink.isDisplayed());
        System.out.println("This link is available now: " + availableLink.isDisplayed());
        System.out.println("This link is available now: " + availableLink.isDisplayed());

        // if (availableLink.equals(driver.findElement(By.xpath("")))) System.out.println("error");

        if (hiddenLink.isDisplayed()) hiddenLink.click();
        else availableLink.click();

        WebElement searchInput = driver.findElement(By.xpath("//input[@id='gh-ac']"));

        String select = Keys.chord(Keys.CONTROL, "a"); //ctrl+a выделить
        String cut = Keys.chord(Keys.CONTROL, "x"); //ctrl+x вырезать
        String paste = Keys.chord(Keys.CONTROL, "v"); //ctrl+v вставить

        searchInput.sendKeys("Гель для лица");
        searchInput.sendKeys(Keys.ENTER);

        searchInput.sendKeys(select);
        searchInput.sendKeys(cut);

        searchInput.sendKeys(Keys.chord(Keys.SHIFT, "гель для лица")); //написать всё сообщение заглавными буквами
        searchInput.sendKeys(Keys.ENTER);

        //TODO сделать скриншот

        Date dateNow = new Date();
        SimpleDateFormat format = new SimpleDateFormat("hh_mm_ss");
        String fileName = format.format(dateNow) + ".png";

        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(screenshot, new File("C:\\Users\\1\\Desktop\\" + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }

        driver.quit();

        //TODO немного JavaScript
//        jse.executeScript("alert('This is alert wrote in JS');"); // откроет браузер и выведет сообщение с этим текстом
//        try {
//            Thread.sleep(3000); //написать эту строку, потом добавить try/catch. Ждёт 3 секунды
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        driver.switchTo().alert().accept(); //в открывшемся алерт окне нажать "принять"
//
//        jse.executeScript("confirm('This is alert wrote in JS');"); // окно с опциями да или отмена
//
//        try {
//            Thread.sleep(3000); //написать эту строку, потом добавить try/catch. Ждёт 3 секунды
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        driver.switchTo().alert().dismiss(); //в открывшемся окне подтвержения нажать "отклонить"

//        driver.get("https://www.ebay.com/");
//
//        WebElement link = driver.findElement(By.xpath("//li[@class='hl-cat-nav__js-tab']//a[text()='Электроника']"));
//        WebElement element = driver.findElement(By.xpath("//li[@class='hl-cat-nav__js-tab']//a[text()='Электроника']"));
//
//        Actions actions = new Actions(driver);
//
//        actions.moveToElement(link).build().perform(); //навестись на элемент не кликая на него
//
//        actions.dragAndDrop(element, link).build().perform(); // перетащить из одного окна в другое
//
//        actions.clickAndHold(element).moveToElement(link).release().build().perform(); // навестись и держать кнопку нажатой, перенести к другому окну и отпустить
//
//        actions.doubleClick(element); // двойной клик
//        actions.contextClick(element); //клик правой кнопкой мыши
//
//        Action action = actions.clickAndHold(element).moveToElement(link).release().build();
//        action.perform();
    }
}