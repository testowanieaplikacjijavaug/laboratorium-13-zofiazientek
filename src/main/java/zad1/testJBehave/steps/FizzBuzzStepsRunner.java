package zad1.testJBehave.steps;

import org.jbehave.core.annotations.*;
import org.jbehave.core.steps.Steps;
import zad1.testJBehave.FizzBuzz;

import static org.junit.jupiter.api.Assertions.*;

public class FizzBuzzStepsRunner  extends Steps{
    private FizzBuzz fizzbuzz;

    @BeforeScenario(uponType = ScenarioType.ANY)
    public void beforeAnyScenario() {
        System.out.println("Another scenario...");
    }
    
    @Given("Fizz buzz class")
    public void givenClassIHave() {
        fizzbuzz = new FizzBuzz();
    }
    @Then("result I get: FizzBuzz")
    @Aliases(values={"result I get - FizzBuzz","result received: FizzBuzz","result received - FizzBuzz"})
    public void thenFizzBuzzAsResult(@Named("number") int number) {
        assertEquals("FizzBuzz",fizzbuzz.check(number));
    }
    @Then("result I get: number value")
    public void thenValueAsResult(@Named("number") int number) {
        assertEquals(number, Integer.parseInt(fizzbuzz.check(number)));
    }
    @Then("error message")
    public void thenErrorMessage(@Named("number") int number) {
        assertThrows(Exception.class, () -> fizzbuzz.check(number));
    }
    @When("number = $number")
    public void whenNumber(@Named("number") int number) {
        fizzbuzz.setNumber(number);
    }
    
    @AfterScenario(uponType = ScenarioType.NORMAL, uponOutcome = Outcome.SUCCESS)
    public void success() {
        System.out.println("Scenario success!");
    }
    @AfterScenario(uponType = ScenarioType.NORMAL, uponOutcome = Outcome.FAILURE)
    public void fail() {
        System.out.println("Scenario fail!");
    }
}
