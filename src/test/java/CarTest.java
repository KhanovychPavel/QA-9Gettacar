import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class CarTest {
   WebDriver driver;

   @BeforeMethod
   public void initTest() {
      driver = new ChromeDriver();
      driver.get("https://www.gettacar.com/");
      driver.manage().window().maximize();
   }

   @Test
   public void gettaCarTest() throws InterruptedException {
      Thread.sleep(3000);
      driver.findElement(By.xpath("//span/a[contains(.,'Choose your car')]")).click();
      Thread.sleep(3000);
      driver.findElement(By.xpath("//h5[contains(.,'Body type')]")).click();
      Thread.sleep(3000);
      driver.findElement(By.xpath("//a[contains(text(),'Pickup')]")).click();
      Thread.sleep(3000);
      driver.findElements(By.xpath("//div[contains(@class,'cars-grid_car-card')]")).get(0).click();
      Thread.sleep(3000);
      String price = driver.findElement(By.className
              ("price-box-details_carPrice__2OTPp")).getText().split(" ")[0]
              .substring(1).replaceAll(",","");
      int priceInt = Integer.parseInt(price);
      if(priceInt >= 20000) {
         System.out.println("High");
      }else {
         System.out.println("Low");
      }
   }

   @AfterMethod
   public void tearDown() {
      driver.quit();
   }

}
