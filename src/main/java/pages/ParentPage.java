package pages;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;


public class ParentPage {
    Logger logger = Logger.getLogger(getClass());
    WebDriver webDriver;

    public ParentPage( WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    public void printErrorAndStopTest(Exception e) {
        logger.error("Can't work with element "+e);
        Assert.fail("Can't work with element "+e );
    }
}
