import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class MainClass {

    static WebDriver driver;

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
        // прописываем путь к chromedriver и geckodriver (firefox)
//
//
//        //  System.setProperty("webdriver.gecko.driver", "C:\\Users\\1\\IdeaProjects\\testselenium\\src\\main\\resources\\geckodriver.exe");
//
//        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//        driver.manage().window().maximize();

        //TODO работа с чекбоксами и радиокнопками

//        driver.get("https://tykwa-food.ru/");
//        driver.get("https://balashiha.palki-skalki.ru");
//        driver.findElement(By.xpath("//button[text()='Еще']")).click();
//
//        WebElement checkbox = driver.findElement(By.xpath("//a[@id='bx_2662763187_7969_buy_link']"));
//        if (driver.findElement(By.xpath("//a[text()='Мужская']")).isDisplayed())
//            driver.findElement(By.xpath("//a[@id='bx_2662763187_7969_buy_link']")).click();
//
//        WebElement checkbox1 = driver.findElement(By.xpath("//a[@id='bx_2662763187_7671_buy_link']"));
//        if (driver.findElement(By.xpath("//a[text()='4 сыра ']")).isDisplayed())
//            driver.findElement(By.xpath("//a[@id='bx_2662763187_7671_buy_link']")).click();
//
//        WebElement checkbox2 = driver.findElement(By.xpath("//a[@id='bx_2662763187_7784_buy_link']"));
//        if (driver.findElement(By.xpath("//a[text()='Мисо суп']")).isDisplayed())
//            driver.findElement(By.xpath("//a[@id='bx_2662763187_7784_buy_link']")).click();
//

//        selectFood("Мужская");
//        selectFood("4 сыра ");
//        selectFood("Ветчина и сыр");
//
//        WebElement basket = driver.findElement(By.xpath("//a[@id='bx_basketT0kNhm']"));
//        basket.click();
        //checkbox.click();

//        driver.get("https://myrusakov.ru/css3-custom-checkbox.html");
//
//           WebElement checkbox = driver.findElement(By.xpath("//body/label/span[@class='checkmark']"));
//        if (driver.findElement(By.xpath("//body/label/span[@class='checkmark']")).isDisplayed())
//            driver.findElement(By.xpath("//body/label/span[@class='checkmark']")).click();
//        checkbox.click();


//       driver.get("https://market.yandex.ru/");

        //       driver.get("https://market.yandex.ru/catalog--stiralnye-mashiny/16673392/list?hid=90566&onstock=1");

        //   WebElement fuckingButton = driver.findElement(By.xpath("//span[text()='Да, спасибо']"));
//        if (driver.findElement(By.xpath("//span[text()='Да, спасибо']")).isDisplayed())
//            driver.findElement(By.xpath("//span[text()='Да, спасибо']")).click();
//
//        WebElement selectCategory = driver.findElement(By.xpath("//span[text()='Бытовая техника']"));
        //    WebElement selectWashMachine = driver.findElement(By.xpath("//div/a[text()='Стиральные машины']"));
        //   WebElement sortByAtlant = driver.findElement(By.xpath("//span[text()='ATLANT']//parent::div"));


//        fuckingButton.isDisplayed();
//        fuckingButton.click();
//        selectCategory.click();
//
//        selectCheckbox("ATLANT");
//        selectCheckbox("Candy");
//        if (selectWashMachine.isDisplayed())
//             selectWashMachine.click();

        //   sortByAtlant.click();

//        driver.get("https://en.wikipedia.org/wiki/Main_Page");
//        WebElement link = driver.findElement(By.xpath("//li[@id='n-aboutsite']/a"));
//        System.out.println(link.getText());
//        link.click();
//
//        driver.get("https://github.com/");
//        WebElement git = driver.findElement(By.xpath("//nav[@class='mt-0 px-3 px-lg-0 mb-5 mb-lg-0']/ul/li/a[text()='Team']"));     //li[@class='border-bottom border-lg-bottom-0 mr-0 mr-lg-3']/a[text()='Team']
//        System.out.println(git.getText());
//        git.click();


//        driver.get("https://en.wikipedia.org/wiki/Main_Page");
//        driver.findElement(By.xpath("//input[@id='searchInput']")).sendKeys("selenide automation");
//        driver.findElement(By.xpath("//input[@id='searchButton']")).click();
//        System.out.println(driver.findElement(By.xpath("//div[@id='searchText']/input")).getAttribute("value"));
//        driver.findElement(By.xpath("//div[@id='searchText']/input")).clear();


//        driver.get("https://github.com/");
//
//        WebElement username = driver.findElement(By.xpath("//input [@id='user[login]']"));
//        WebElement email = driver.findElement(By.xpath("//input [@id='user[email]']"));
//        WebElement password = driver.findElement(By.xpath("//input [@id='user[password]']"));
//        WebElement button = driver.findElement(By.xpath("//form[starts-with(@class, 'home-hero-signup text-gray-dark')]//button[contains(text(), 'Sign up for GitHub')]"));
//
//        username.sendKeys("nchedanova");
//        email.sendKeys("chedanova21@gmail.com");
//        password.sendKeys("kvokka26rnana");
//        button.submit();


//
//        if (button.getText().equals("Sign up for GitHub")) {
//            System.out.print("The button is " + button.getText() + '.');
//            System.out.println(" Test passed.");
//        } else System.out.println("Test failed. Text '" + button.getText() + "' not equals to 'Sign up for GitHub'");
//      //  button.submit(); // только для элементов которые имеют type=submit на самом сайте
//
//
//        driver.findElement(By.xpath("//a [@class='HeaderMenu-link no-underline mr-3']")).click();


//        WebDriver driver1 = new FirefoxDriver();
//        driver.get("https://onequestiontr.simplesite.com");
//        WebElement info = driver.findElement(By.linkText("Полезная информация"));
//        WebElement tricks = driver.findElement(By.xpath("//a[text()='Тонкости']"));
//        WebElement tricks = driver.findElement(By.cssSelector(".dropdown-menu > li:nth-child(3) > a:nth-child(1)"));
//        WebElement prices = driver.findElement(By.partialLinkText("Цены в Мерсине"));

//        info.isDisplayed();
//        info.click();
//        tricks.isDisplayed();
//        tricks.click();
//        prices.click();


        //   driver.quit();

        //TODO оси XPath

        //ancestor:: - возвращает предков какого-то элемента
        //ancestor or self
        //following-sibling:: - ищет соседний элемент ниже нашего элемента
        //preceding-sibling:: - ищет соседний элемент выше нашего элемента
        //parent - возвращает родительский элемент

        // //table[id='element']

        //TODO Функции Xpath

        // //table[id='element']//tr[last()] - вернет последнюю строку из таблицы
        // //table[id='element']//tr[first()] - вернет первую строку из таблицы
        // //a[text()='View source'] - поиск по тексту находящемуся между тегами
        // //p[contains(text(), 'use Github']
        // //p[contains(@class, '_mk24_58f_5'] - содержится этот текст в названии класса или в тексте
        // //input[starts-with(@title, 'Go to')]


//        driver1.get("https://www.google.com/");
    }

    public static void selectCheckbox(String name) {
        String nameOfCheckbox = "//span[text()='%s']//parent::div";
        if (!driver.findElement(By.xpath(String.format(nameOfCheckbox, name))).isSelected())
            driver.findElement(By.xpath(String.format(nameOfCheckbox, name))).click();

    }

    public static void selectFood(String name) {
        String nameOfCheckbox = "//a[text()='%s']";
        if (!driver.findElement(By.xpath(String.format(nameOfCheckbox, name))).isSelected())
            driver.findElement(By.xpath("//a[@id='bx_2662763187_7969_buy_link']")).click();
      //      driver.findElement(By.xpath(String.format(nameOfCheckbox, name))).click();

    }
}
