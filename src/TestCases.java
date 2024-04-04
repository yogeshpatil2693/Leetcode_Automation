package demo;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.logging.Level;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCases {
    ChromeDriver driver;

    public TestCases() {
        System.out.println("Constructor: TestCases");

        WebDriverManager.chromedriver().timeout(30).setup();
        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        // Set log level and type
        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);

        // Set path for log file
        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "chromedriver.log");

        driver = new ChromeDriver(options);

        // Set browser to maximize and wait
        driver.manage().window().maximize();
        // driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest() {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    public void testCase01() {
        System.out.println("Start Test case: testCase01");
        driver.get("https://leetcode.com/");
        String cURL = driver.getCurrentUrl();
        if (cURL.contains("leetcode")) {
            System.out.println("Test case is Pass");
        }
        System.out.println("end Test case: testCase01");
    }

    public void testCase02() throws InterruptedException {
        System.out.println("Start Test case: testCase02");
        driver.get("https://leetcode.com/");
        WebElement viewQuestions = driver.findElement(By.xpath("//p[text()='View Questions ']"));
        viewQuestions.click();
        Thread.sleep(2000);
        if (driver.getCurrentUrl().contains("problemset")) {
            System.out.println("You are on problemset URL");
        }
        List<WebElement> questionList = driver.findElements(By.xpath(
                "//a[@class='h-5 hover:text-blue-s dark:hover:text-dark-blue-s'][not(@href='/problems/linked-list-cycle/?envType=daily-question&envId=2024-03-06')]"));
        for (WebElement questionText : questionList) {
            System.out.println(questionText.getText());
            if (questionText.getText().contains("Longest Palindromic Substring"))
                break;
        }

        WebElement firstProblem = driver.findElement(By.xpath("//a[text()='Two Sum']"));
        firstProblem.click();
        Webdriverwait("Two Sum");
        String titleFirstProblem = driver.getTitle();
        if (titleFirstProblem.contains("Two Sum")) {
            System.out.println("Title of the first problem is correct");
        } else {
            System.out.println("Test case fail");
        }

        driver.get("https://leetcode.com/problemset/");
        WebDriverwaitvisiblityofele("Add Two Numbers");
        driver.findElement(By.xpath("//a[text()='Add Two Numbers']")).click();
        Webdriverwait("Add Two Numbers");
        String titleSecondProblem = driver.getTitle();
        if (titleSecondProblem.contains("Add Two Numbers")) {
            System.out.println("Title of the second problem is correct");
        } else {
            System.out.println("Test case fail");
        }

        driver.get("https://leetcode.com/problemset/");
        WebDriverwaitvisiblityofele("Longest Substring Without Repeating Characters");
        driver.findElement(By.xpath("//a[text()='Longest Substring Without Repeating Characters']")).click();
        Webdriverwait("Longest Substring Without Repeating Characters");
        String titleThirdProblem = driver.getTitle();
        if (titleThirdProblem.contains("Longest Substring Without Repeating Characters")) {
            System.out.println("Title of the Third problem is correct");
        } else {
            System.out.println("Test case fail");
        }

        driver.get("https://leetcode.com/problemset/");
        WebDriverwaitvisiblityofele("Median of Two Sorted Arrays");
        driver.findElement(By.xpath("//a[text()='Median of Two Sorted Arrays']")).click();
        Webdriverwait("Median of Two Sorted Arrays");
        String titleFourthProblem = driver.getTitle();
        if (titleFourthProblem.contains("Median of Two Sorted Arrays")) {
            System.out.println("Title of the Fourth problem is correct");
        } else {
            System.out.println("Test case fail");
        }

        driver.get("https://leetcode.com/problemset/");
        WebDriverwaitvisiblityofele("Longest Palindromic Substring");
        driver.findElement(By.xpath("//a[text()='Longest Palindromic Substring']")).click();
        Webdriverwait("Longest Palindromic Substring");
        String titleFifthProblem = driver.getTitle();
        if (titleFifthProblem.contains("Longest Palindromic Substring")) {
            System.out.println("Title of the Fifth problem is correct");
        } else {
            System.out.println("Test case fail");
        }

        System.out.println("end Test case: testCase02");
    }

    public void testCase03() throws InterruptedException {
        System.out.println("Start Test case: testCase03");
        driver.get("https://leetcode.com/");
        WebElement viewQuestions = driver.findElement(By.xpath("//p[text()='View Questions ']"));
        viewQuestions.click();
        Thread.sleep(2000);
        WebElement twoSum = driver.findElement(By.xpath("//a[text()='Two Sum']"));
        twoSum.click();
        String twoSumUrl = driver.getCurrentUrl();
        if (twoSumUrl.contains("two-sum")) {
            System.out.println("Test Case is pass");
        }
        System.out.println("end Test case: testCase03");
    }

    public void testCase04() throws InterruptedException {
        System.out.println("Start Test case: testCase04");
        driver.get("https://leetcode.com/");
        WebElement viewQuestions = driver.findElement(By.xpath("//p[text()='View Questions ']"));
        viewQuestions.click();
        WebDriverwaitvisiblityofele("Two Sum");
        WebElement twoSum = driver.findElement(By.xpath("//a[text()='Two Sum']"));
        twoSum.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("submissions_tab")));
        WebElement submissionButton = driver.findElement(By.id("submissions_tab"));
        submissionButton.click();
        Thread.sleep(2000);
        WebElement registerButton = driver.findElement(By.xpath("//a[text()='Register or Sign In']"));
        String regiButton = registerButton.getText();
        if (regiButton.equals("Register or Sign In")) {
            System.out.println("Test Case is PASS");
        }
        System.out.println("end Test case: testCase04");
    }

    public void Webdriverwait(String problemName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.titleContains(problemName));

    }

    public void WebDriverwaitvisiblityofele(String question) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='" + question + "']")));
    }

}
