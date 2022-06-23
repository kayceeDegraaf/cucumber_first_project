package steps;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utils.Driver;

public class RandomSteps {

    //EXAMPLE FROM CLASS
    //JUST HOW TO USE FAKER

    @Test
    public void getRandomGoogleSearch(){
        Faker faker = new Faker();

        Driver.getDriver().get("http://www.google.com");

        Driver.getDriver().findElement(By.name("q")).sendKeys(faker.gameOfThrones().character() + Keys.ENTER);

        Driver.quitDriver();
    }
}
