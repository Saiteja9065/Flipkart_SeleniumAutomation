import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingAlerts {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//button[normalize-space()='Click for JS Alert']")).click();
        Thread.sleep(5000);

        Alert myalert = driver.switchTo().alert();
        System.out.println(myalert.getText());
        myalert.accept();

        driver.findElement(By.xpath("//button[normalize-space()='Click for JS Confirm']")).click();
        Thread.sleep(5000);
        Alert myalert1 = driver.switchTo().alert();
        System.out.println(myalert1.getText());
        myalert1.accept();
        String s = driver.findElement(By.id("result")).getText();
        System.out.println(s);

        Thread.sleep(2000);

        driver.findElement(By.xpath("//button[normalize-space()='Click for JS Prompt']")).click();
        Thread.sleep(5000);
        Alert myalert2 = driver.switchTo().alert();
        System.out.println(myalert2.getText());
        myalert2.sendKeys("Hello World");
        myalert2.accept();
        String s1 = driver.findElement(By.id("result")).getText();
        System.out.println(s1);

        driver.quit();
    }
}
