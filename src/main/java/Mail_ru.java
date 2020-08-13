import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Mail_ru {
    static WebDriver driver;
    static WebDriverWait wait;
    static WebDriverWait wait2;

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
        // прописываем путь к chromedriver и geckodriver (firefox)


        //  System.setProperty("webdriver.gecko.driver", "C:\\Users\\1\\IdeaProjects\\testselenium\\src\\main\\resources\\geckodriver.exe");

//        driver = new ChromeDriver();
        driver = new FirefoxDriver();

        driver.get("http://account.mail.ru/signup?from=navi&lang=ru_RU&siteid=169&rnd=100940567");
        String mainTab = driver.getWindowHandle();
        wait = (new WebDriverWait(driver, 0, 5));
        wait2 = (new WebDriverWait(driver, 0, 8));

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[contains(text(),'Регистрация')]")));

        selectOption("Телефон", "Турция");
        WebElement terms = driver.findElement(By.xpath("//a[contains(text(),'Условия использования')]"));
        terms.click();
        for (String tab : driver.getWindowHandles()){
            driver.switchTo().window(tab);
        }

        try {
            Thread.sleep(3500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement userAgreement = driver.findElement(By.xpath("//div[@class='h-header h-header_h3 color-blue']//a[contains(text(),'Пользовательское соглашение сервисов')]"));

        userAgreement.click();
        driver.switchTo().window(mainTab);

        WebElement userName = driver.findElement(By.xpath("//input[@name='username']"));
        userName.click();
        userName.sendKeys("raubezh18181818");

//        TODO is selected

        WebElement rbMen = driver.findElement(By.xpath("(//div[@class='c0194'])[1]"));
        WebElement rbWomen = driver.findElement(By.xpath("(//div[@class='c0194'])[2]"));
        rbWomen.click();
        System.out.println("Radio button Women is select: ");
        if (!rbMen.isSelected()) rbMen.click();
        System.out.println("Radio button Men is select: ");


    }

    public static void selectOption(String listName, String option) {
        String listXpath = String.format("//label[contains(text(),'%s')]//ancestor::div[2]//div[@class='Select c0179 c0182 c0181 has-value Select--single'][1]", listName);
        String optionXpath = String.format("//span/p[contains(text(),'%s')]", option);

        driver.findElement(By.xpath(listXpath)).click();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(optionXpath)));
        driver.findElement(By.xpath(optionXpath)).click();
//        wait2.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(optionXpath)));
        //div[@class='Select c0179 c0182 c0181 has-value Select--single']//span[@class='Select-value-label']

    }
}
