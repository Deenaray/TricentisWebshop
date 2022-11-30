package TWebshop;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.io.IOException;

public class MyStepdefs {
    WebClass wc=new WebClass();
    @Given("Url")
    public void url() throws InterruptedException {
        wc.openURL();

    }

    @And("End to end test")
    public void endToEndTest() throws InterruptedException, IOException {
        wc.lapTop();
        wc.book();
        wc.registerPage();
    }

    @Then("Close the website")
    public void closeTheWebsite() {
    }
}
