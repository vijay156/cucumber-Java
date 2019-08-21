package io.cucumber.skeleton;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Stepdefs {
    @Given("^I have (\\d+) cukes in my belly$")
    public void I_have_cukes_in_my_belly(int cukes) {
        Belly belly = new Belly();
        belly.eat(cukes);
    }
    
    @When("^I wait 1 hour$")
    public void i_wait_1_hour() {
    	System.out.println("Vijayaragavan K");
    }

    @Then("^my belly should growl$")
    public void my_belly_should_growl() {
    	System.out.println("Vijayaragavan Kanagaraj");
    }
}
