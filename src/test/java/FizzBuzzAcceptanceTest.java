import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "classpath:features/fizzbuzz.feature",
    plugin = {"pretty", "html:target/cucumber/fizzbuzz.html"}
)
public class FizzBuzzAcceptanceTest {
}
