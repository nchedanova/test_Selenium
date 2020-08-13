import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Mail_ru {

    static WebDriver driver;
    static WebDriverWait wait;
    static WebDriverWait longwait;

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
        // прописываем путь к chromedriver и geckodriver (firefox)
        //  System.setProperty("webdriver.gecko.driver", "C:\\Users\\1\\IdeaProjects\\testselenium\\src\\main\\resources\\geckodriver.exe");

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //     driver.manage().window().maximize();

        driver.get("https://account.mail.ru/signup?from=main&rf=auth.mail.ru");
        String mainTab = driver.getWindowHandle();

        wait = (new WebDriverWait(driver, 1));
        longwait = (new WebDriverWait(driver, 2));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[contains(text(), 'Регистрация')]")));

        //     selectOption("Имя аккаунта", "bk.ru");
        selectOption("Телефон", "Турция");

        WebElement terms = driver.findElement(By.xpath("//a[contains(text(),'Условия')]"));
        terms.click();

        for (String tab : driver.getWindowHandles()) {
            driver.switchTo().window(tab);
        }

        WebElement userAgreement = driver.findElement(By.xpath("//div[@class='h-header h-header_h3 color-blue']//a[contains(text(),'Пользовательское соглашение сервисов Mail.ru')]"));
        userAgreement.click();

        driver.switchTo().window(mainTab);

        WebElement userName = driver.findElement(By.xpath("//input[@name='username']"));
        userName.click();
        userName.sendKeys("chedanova1234");

        //TODO проверка isSelected на примере радиокнопок
        WebElement rbMen = driver.findElement(By.xpath("(//div[@class='c0194'])[1]"));
        WebElement rbWomen = driver.findElement(By.xpath("(//div[@class='c0194'])[2]"));

        rbMen.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Radio button men is selected: " + rbMen.isSelected());

        if(!rbWomen.isSelected()) rbWomen.click();
    }

    public static void selectOption(String listName, String option) {
        String listXpath = String.format("//div/label[contains(text(), '%s')]//ancestor::div[2]//div[@class='Select c0179 c0182 c0181 has-value Select--single'][1]", listName);
        String optionXpath = String.format("//span/p[contains(text(), '%s')]", option);
        //     String optionXpath1 = String.format("//span[contains(text(), '%s')]", option);

        driver.findElement(By.xpath(listXpath)).click();
        //       longwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(optionXpath)));
        driver.findElement(By.xpath(optionXpath)).click();
        //    longwait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(optionXpath)));
        //  driver.findElement(By.xpath(optionXpath1)).click();

        ////parent::span[@role='option']
    }
}
