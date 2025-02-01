package Academy;

import static org.junit.Assert.assertEquals;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class IndexPageTest {

    @Test
    public void validateIndexPageContent() {
        // Set up ChromeDriver
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        try {
            // Navigate to the index.jsp page
            driver.get("https://rahylshettyacademy.azurewebsites.net/webapp/index.jsp");

            // Verify H1 Tag
            String h1Text = driver.findElement(By.tagName("h1")).getText();
            System.out.println("H1 Text: " + h1Text);
            Assert.assertEquals("Preetham Darshanala", h1Text);

            // Verify First H2 Tag
            String h2Text1 = driver.findElement(By.xpath("(//h2)[1]")).getText();
            System.out.println("H2 First Line: " + h2Text1);
            Assert.assertEquals("Software Developer @Amdocs | Devops | Cloud | Azure | AWS Certified", h2Text1);

            // Verify Second H2 Tag
            String h2Text2 = driver.findElement(By.xpath("(//h2)[2]")).getText();
            System.out.println("H2 Second Line: " + h2Text2);
            Assert.assertEquals("Pune, Maharashtra, India.", h2Text2);

            // Verify Page Contains 'DevOps Engineer' Text
            String pageSource = driver.getPageSource();
            Assert.assertTrue("DevOps Engineer text is missing", pageSource.contains("Devops Engineer"));

        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
