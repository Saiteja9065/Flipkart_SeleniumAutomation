package baseClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Library {
    public static WebDriver driver;
    public static Properties prop;
    public void launchapplication() throws IOException {

        FileInputStream inputStream = new FileInputStream("src/test/resources/config/config.properties");
        prop = new Properties();
        prop.load(inputStream);
        try{
            if(prop.getProperty("browser").equalsIgnoreCase("chrome")){
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            } else if (prop.getProperty("browser").equalsIgnoreCase("firefox")) {
                WebDriverManager.firefoxdriver();
                driver = new FirefoxDriver();
            }
            driver.manage().window().maximize();
            driver.get(prop.getProperty("url"));
            driver.manage().timeouts().implicitlyWait(20, java.util.concurrent.TimeUnit.SECONDS);

        }
        catch(Exception e){
            System.out.println("Browser not found");
            e.printStackTrace();
        }
    }
}
