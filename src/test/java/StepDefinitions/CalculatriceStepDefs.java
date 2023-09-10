package StepDefinitions;

import PageObjectModels.CalculatricePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CalculatriceStepDefs {
    WebDriver driver;
    CalculatricePage calculatricePage;
     String actualTime;

    public CalculatriceStepDefs() {
      driver=Hooks.driver;
      calculatricePage=new CalculatricePage(driver);
    }

    @Given("J'accède à l'application via l'url {string}")
    public void j_accède_à_l_application_via_l_url(String url) {
        driver.get(url);
    }
    @When("J'additionne les chiffres {int} et {int}")
    public void j_additionne_les_chiffres_et(Integer int1, Integer int2) {

        calculatricePage.clickbutton1();
        calculatricePage.clickadd();
        calculatricePage.clickbutton2();
        calculatricePage.clickequalbutton();
       /* LocalTime currentTime = LocalTime.now();
        int hour =currentTime.getHour();
        int minutes=currentTime.getMinute();
        int seconds=currentTime.getSecond();
        actualTime= hour+":"+minutes;
        System.out.println("actualTime>>>>>>>>>>>>>>>>>>>>>"+actualTime);*/
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String formattedTime = sdf.format(new Date());

        Date parsedTime = null;
        try {
            parsedTime = sdf.parse(formattedTime);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        SimpleDateFormat hourMinuteFormat = new SimpleDateFormat("HH:mm");
        String actualTime = hourMinuteFormat.format(parsedTime);
        System.out.println("actualTime>>>>>>>>>>>"+actualTime);

    }
    @Then("Je trouve le resulat {int}")
    public void je_trouve_le_resulat(Integer int1) {

        int actualresult=Integer.parseInt(calculatricePage.getfinalresult());
        Assertions.assertEquals(int1,actualresult);
        String actualoperationtime=calculatricePage.getoperationtime();
        System.out.println("actualoperationtime>>>>>>>>>>>>>>>>>"+ actualoperationtime);
        String[] parts = actualoperationtime.split(":");
        String extractedTime = parts[0] + ":" + parts[1];
        assert extractedTime.contains(actualTime) : "Assertion failed: actualoperationtime does not contain actualTime";



    }
}
