package baidu;

import java.util.regex.Pattern;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import read.Information;
import read.readFromExcel;
import read.readFromWeb;

public class TestBaidu {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  readFromExcel rfe = new readFromExcel();
  readFromWeb rfw = new readFromWeb();
  String path = "C:\\Users\\孙琦淞\\Desktop\\软件测试\\test.xlsx";


  public void setUp() throws Exception {
	  String driverPath = System.getProperty("user.dir") + "/src/resources/driver/geckodriver.exe";
	  System.setProperty("webdriver.gecko.driver", driverPath);
	  driver = new FirefoxDriver();
	  baseUrl = "http://121.193.130.195:8800/login";
	  driver.manage().timeouts().implicitlyWait(6000, TimeUnit.SECONDS);
  }

  @Test
  public void testBaidu() throws Exception {

	List<Information> excelList = rfe.readXlsx(path);
	for(int i=0;i< excelList.size();i++) {
	setUp();
    driver.get(baseUrl);
    Information webInfo = rfw.readWeb(excelList,driver,i);   
    assertEquals(excelList.get(i).sid, webInfo.sid);
    assertEquals(excelList.get(i).name,webInfo.name);
    assertEquals(excelList.get(i).address,webInfo.address);
    System.out.println(webInfo.name+"的信息准确！");
    driver.close();
	}
    
  }

  @After
  public void tearDown() throws Exception {
//    driver.quit();
//    String verificationErrorString = verificationErrors.toString();
//    if (!"".equals(verificationErrorString)) {
//      fail(verificationErrorString);
//    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}

