import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.time.Duration;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleFiles {
    
    public static void main(String args[]) throws InterruptedException{
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.foundit.in/upload");

        driver.findElement(By.xpath("//div[contains(text(),'Upload Resume')]")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@id='file-upload']")).sendKeys("C:\\Users\\Lenovo\\Downloads\\SDET_Saiteja.pdf");
        Thread.sleep(2000);

        driver.findElement((By.xpath("//input[@id='pop_upload']"))).click();
        Thread.sleep(2000);
        
        driver.close();


    }
}
