package baseTest;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.BookStoreAppLoginPage;

import pages.HomePageForBookStore;
import pages.LoginToBookAppPage;
import pages.MainPage;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    WebDriver webDriver; // объявляем драйвер
    Logger logger = Logger.getLogger(getClass());

    protected MainPage mainPage;
    protected BookStoreAppLoginPage bookStoreAppLoginPage;
    protected LoginToBookAppPage loginToBookAppPage;
    protected HomePageForBookStore homePageForBookStore;


    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup(); // стягиваем нужный исполняемый файл для хромдрайвера
        webDriver= new ChromeDriver(); //реализация интерфейса вебрайвера
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        logger.info("browser was opened");

        mainPage = new MainPage(webDriver);
        bookStoreAppLoginPage = new BookStoreAppLoginPage(webDriver);
        loginToBookAppPage =new LoginToBookAppPage(webDriver);
        homePageForBookStore = new HomePageForBookStore(webDriver);


    }
    @After
    public void turnDown(){
        webDriver.quit();
        logger.info("Browser was closed");


    }
}
