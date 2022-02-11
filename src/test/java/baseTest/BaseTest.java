package baseTest;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    WebDriver webDriver; // объявляем драйвер
    Logger logger = Logger.getLogger(getClass());

    protected MainPage mainPage;
    protected BooksPageBeforeLogin booksPageBeforeLogin;
    protected LoginToBookAppPage loginToBookAppPage;
    protected ProfilePage profilePage;
    protected StorePage storePage;
    protected BookPage bookPage;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup(); // стягиваем нужный исполняемый файл для хромдрайвера
        webDriver= new ChromeDriver(); //реализация интерфейса вебрайвера
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        logger.info("browser was opened");

        mainPage = new MainPage(webDriver);
        booksPageBeforeLogin = new BooksPageBeforeLogin(webDriver);
        loginToBookAppPage =new LoginToBookAppPage(webDriver);
        profilePage = new ProfilePage(webDriver);
        storePage = new StorePage(webDriver);
        bookPage = new BookPage(webDriver);

    }

    protected void validLogin(){
        mainPage.openBookAppLoginPage();
        loginToBookAppPage.clickOnLogInButton();
        booksPageBeforeLogin.clickOnLoginButtonToLogInUser();
        loginToBookAppPage.logInToBookAppWithValidCred();
    }



    @After
    public void turnDown(){
        webDriver.quit();
        logger.info("Browser was closed");


    }
}
