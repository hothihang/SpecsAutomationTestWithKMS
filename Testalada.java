package selenium.webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Testalada {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", "E://Softs/geckodriver/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void TC_01_Register_Empty_Data() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		
		driver.findElement(By.id("txtFirstname")).sendKeys("");
		driver.findElement(By.id("txtEmail")).sendKeys("");
		driver.findElement(By.id("txtCEmail")).sendKeys("");
		driver.findElement(By.id("txtPassword")).sendKeys("");
		driver.findElement(By.id("txtCPassword")).sendKeys("");
		driver.findElement(By.id("txtPhone")).sendKeys("");
		driver.findElement(By.xpath("//form[@id='frmLogin']//button[text()='ĐĂNG KÝ'] ")).click();
		sleepInSecond(2);
		
		//kiểm tra dữ liệu trả về đúng/sai
		//Assert.assertFalse(false)/(true);
		//Verify error message as expected
		
		Assert.assertEquals(driver.findElement(By.id("txtFirstname-error")).getText(), "Vui lòng nhập họ tên");
		Assert.assertEquals(driver.findElement(By.id("txtEmail-error")).getText(), "Vui lòng nhập email");
		Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(), "Vui lòng nhập lại địa chỉ email");
		Assert.assertEquals(driver.findElement(By.id("txtPassword-error")).getText(), "Vui lòng nhập mật khẩu");
		Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(), "Vui lòng nhập lại mật khẩu");
		Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(), "Vui lòng nhập số điện thoại.");
		
	}

	@Test
	public void TC_02_Register_Invalid_Email() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		driver.findElement(By.id("txtFirstname")).sendKeys("hang ho");
		driver.findElement(By.id("txtEmail")).sendKeys("hangho");
		driver.findElement(By.id("txtCEmail")).sendKeys("hangho");
		driver.findElement(By.id("txtPassword")).sendKeys("1111111111");
		driver.findElement(By.id("txtCPassword")).sendKeys("1111111111");
		driver.findElement(By.id("txtPhone")).sendKeys("0917432543");
		driver.findElement(By.xpath("//form[@id='frmLogin']//button[text()='ĐĂNG KÝ'] ")).click();
		sleepInSecond(2);
		
		//kiểm tra dữ liệu trả về đúng/sai
		//Assert.assertFalse(false)/(true);
		//Verify error message as expected
		
		Assert.assertEquals(driver.findElement(By.id("txtEmail-error")).getText(), "Vui lòng nhập email hợp lệ");
		Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(), "Email nhập lại không đúng");
		
	}

	@Test
	public void TC_03_Register_Incorrect_Email() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		driver.findElement(By.id("txtFirstname")).sendKeys("hang ho");
		driver.findElement(By.id("txtEmail")).sendKeys("hangho@gmail.com");
		driver.findElement(By.id("txtCEmail")).sendKeys("hang@gmail.com");
		driver.findElement(By.id("txtPassword")).sendKeys("1111111111");
		driver.findElement(By.id("txtCPassword")).sendKeys("1111111111");
		driver.findElement(By.id("txtPhone")).sendKeys("0917432543");
		driver.findElement(By.xpath("//form[@id='frmLogin']//button[text()='ĐĂNG KÝ'] ")).click();
		sleepInSecond(2);
		
		//kiểm tra dữ liệu trả về đúng/sai
		//Assert.assertFalse(false)/(true);
		//Verify error message as expected
		
		Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(), "Email nhập lại không đúng");
	}

	@Test
	public void TC_04_Register_Password_Less_Than_6_Chars() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		driver.findElement(By.id("txtFirstname")).sendKeys("hang ho");
		driver.findElement(By.id("txtEmail")).sendKeys("hangho@gmail.com");
		driver.findElement(By.id("txtCEmail")).sendKeys("hangho@gmail.com");
		driver.findElement(By.id("txtPassword")).sendKeys("11111");
		driver.findElement(By.id("txtCPassword")).sendKeys("11111");
		driver.findElement(By.id("txtPhone")).sendKeys("0917432543");
		driver.findElement(By.xpath("//form[@id='frmLogin']//button[text()='ĐĂNG KÝ'] ")).click();
		sleepInSecond(2);
		
		//kiểm tra dữ liệu trả về đúng/sai
		//Assert.assertFalse(false)/(true)
		//Verify error message as expected
		
		Assert.assertEquals(driver.findElement(By.id("txtPassword-error")).getText(), "Mật khẩu phải có ít nhất 6 ký tự");
		Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(), "Mật khẩu phải có ít nhất 6 ký tự");
	}

	@Test
	public void TC_05_Register_Incorrect_Password() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		driver.findElement(By.id("txtFirstname")).sendKeys("hang ho");
		driver.findElement(By.id("txtEmail")).sendKeys("hangho@gmail.com");
		driver.findElement(By.id("txtCEmail")).sendKeys("hangho@gmail.com");
		driver.findElement(By.id("txtPassword")).sendKeys("1111111111");
		driver.findElement(By.id("txtCPassword")).sendKeys("1111122222");
		driver.findElement(By.id("txtPhone")).sendKeys("0917432543");
		driver.findElement(By.xpath("//form[@id='frmLogin']//button[text()='ĐĂNG KÝ'] ")).click();
		sleepInSecond(2);
		
		//kiểm tra dữ liệu trả về đúng/sai
		//Assert.assertFalse(false)/(true)
		//Verify error message as expected

		Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(), "Mật khẩu bạn nhập không khớp");
	}

	@Test
	public void TC_06_Register_Invalid_Phone() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		driver.findElement(By.id("txtFirstname")).sendKeys("hang ho");
		driver.findElement(By.id("txtEmail")).sendKeys("hangho@gmail.com");
		driver.findElement(By.id("txtCEmail")).sendKeys("hangho@gmail.com");
		driver.findElement(By.id("txtPassword")).sendKeys("1111111111");
		driver.findElement(By.id("txtCPassword")).sendKeys("1111111111");
		driver.findElement(By.id("txtPhone")).sendKeys("0217432543");
		driver.findElement(By.xpath("//form[@id='frmLogin']//button[text()='ĐĂNG KÝ'] ")).click();
		sleepInSecond(2);
		
		//kiểm tra dữ liệu trả về đúng/sai
		//Assert.assertFalse(false)/(true)
		//Verify error message as expected
		
		Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(), "Số điện thoại bắt đầu bằng: 09 - 03 - 012 - 016 - 018 - 019"
				+ "");
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public void sleepInSecond(long second) {
		try {
			Thread.sleep(second * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
