import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class Restaurant_Search {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\sqa\\chromedriver-win64\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.foodpanda.com.bd/");

        String title = driver.getTitle();
        System.out.println("Homepage Title: " + title);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        WebElement locationInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[contains(@placeholder, 'delivery')]")));
        locationInput.sendKeys("Gulshan", Keys.ENTER);

        WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@placeholder, 'Search')]")));
        searchInput.sendKeys("Madchef", Keys.ENTER);

        WebElement firstResult = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[contains(@href, 'restaurant')])[1]")));
        firstResult.click();

        WebElement restNameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1")));
        String restName = restNameElement.getText();
        System.out.println("Restaurant Name: " + restName);

        driver.quit();
    }
}