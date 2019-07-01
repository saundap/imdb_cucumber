package IMDB;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources",
        glue="src/test/IMDB",
        tags={"@Run"}
        )
public class RunCukesTest {

}