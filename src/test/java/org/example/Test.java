package org.example;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalculatorTest {
    @Test
    public void testBasicCalculator() {
        System.setProperty("webdriver.chrome.driver",
                "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://testsheepnz.github.io/BasicCalculator.html");

        // Проскролливаем вниз до конца страницы
        driver.findElement(By.cssSelector(".main-content")).sendKeys(
                Keys.PAGE_DOWN);

        while (driver.findElements(By.className("build")).size() != 2) {
            driver.findElement(By.xpath(“//div[text()=‘Prototype’]”)).click();
        }

        driver.findElement(By.name("firstNumber")).sendKeys("2");
        driver.findElement(By.name("secondNumber")).sendKeys("3");
        driver.findElement(By.name("operation")).click();

        if (driver.findElement(By.id("answer")).getText().equals("-1")) {
            System.out.println("The answer is correct!");
        } else {
            throw new AssertionError("The answer is incorrect!");
        }
    }

