package read;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class readFromWeb {
	
	
	public Information readWeb(List<Information> list, WebDriver driver, int i) throws Exception {

		Information webInfo = new Information();
		driver.findElement(By.name("id")).sendKeys(list.get(i).sid);
		driver.findElement(By.name("password")).sendKeys(list.get(i).sid.substring(4, 10));
		driver.findElement(By.id("btn_login")).sendKeys(Keys.ENTER);
		WebElement id_we = driver.findElement(By.id("student-id"));
		WebElement name_we = driver.findElement(By.id("student-name"));
		WebElement git_we = driver.findElement(By.id("student-git"));

		String sid = id_we.getText();
		String name = name_we.getText();
		String git = git_we.getText();
		webInfo.sid = sid;
		webInfo.name = name;
		webInfo.address = git;

		return webInfo;

	}

}
