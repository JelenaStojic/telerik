import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

//Napisati dva smoke testa za https://www.telerik.com/support/demos:
//Proveriti da klikom na Desktop odlazimo na tu sekciju
//Proveriti da klikom na Mobile odlazimo na tu sekciju
//Koristiti TestNG, asserte.


    public class Domaci {
        private WebDriver driver;

        @BeforeClass
        public void setUp() {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\ThinkPad\\IdeaProjects\\chromedriver_win32\\chromedriver.exe");
            driver = new ChromeDriver();
        }

        @BeforeMethod
        public void beforeMethod() {
            driver.navigate().to("https://www.telerik.com/support/demos");
            //driver.navigate().refresh();
        }

        @AfterClass
        public void afterMethod() {
            driver.close();
        }

        @Test
        public void testDesktopTitle() {
            WebElement desktopMenu = driver.findElement(By.xpath("//*[@id=\"ContentPlaceholder1_T53129E6C012_Col00\"]/nav/div/div[2]/a[2]"));
            desktopMenu.click();
            WebElement desktop = driver.findElement(By.id("desktop"));
            String excpectedTitle ="Desktop";
            String actualTitle = desktop.getText();
            Assert.assertEquals(actualTitle, excpectedTitle);
        }
        @Test
        public void testMobileTitle() {
            WebElement desktopMenu = driver.findElement(By.xpath("//*[@id=\"ContentPlaceholder1_T53129E6C012_Col00\"]/nav/div/div[2]/a[3]"));
            desktopMenu.click();
            WebElement desktop = driver.findElement(By.id("mobile"));
            String excpectedTitle ="Mobile";
            String actualTitle = desktop.getText();
            Assert.assertEquals(actualTitle, excpectedTitle);
        }
    }

