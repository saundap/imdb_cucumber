package IMDB;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import cucumber.api.java.en.Given;
import Support.Action;
import Support.Check;

public class IMDB_Steps {
    WebDriver driver;
    Action action = null;
    Check check = new Check();
    String genre = null;
    String sortCategory = null;

    private static boolean beforeSuite = true;
    private static boolean afterSuite = true;
    private static String executablePath;
    static Properties prop;

    @Before
    public void beforeAll() {
        System.out.println("This will run before the Scenario");
        if(beforeSuite) {
            System.setProperty("webdriver.chrome.driver", "C:\\workspace\\SeleniumDrivers\\chromedriver_win32_75\\chromedriver.exe");
            //To make it execute only once
            beforeSuite = false;
            //If you wish to launch browser only once , you can have that code here.
        }

        //Here you can keep code to be execute before each scenario
    }

    @After
    public void afterAll() {
        System.out.println("This will run after the Scenario");
        if(afterSuite) {
            driver.close();
        }
        //Here you can keep code to be execute after each scenario
    }

    @Given("I load the Top Rated Movies page$")
    public void load_the_Top_Rated_Movies_page() throws Throwable {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.imdb.com/chart/top");
        driver.manage().window().maximize();

        action = new Action(driver);
    }

    @Given("I refine by Genre \"([^\"]*)\"")
    public void refine_by_genre(String genre) throws Throwable {
        this.genre = genre;
        action.clickElementByXPath(genre);
    }

    @Given("I sort the list by \"([^\"]*)\"")
    public void sort_list_by(String sortCategory) throws Throwable {
        this.sortCategory = sortCategory;
        action.dropDownListSelect("sort", sortCategory);
    }

    @Then("the list of movies should only contain relevant results")
    public void list_of_movies_contain_relevant_results(){
        ArrayList<String> actual = action.returnElementList("//*[@id=\"main\"]/div/div[3]/div/div[*]/div[3]/h3/a");
        ArrayList<String> relevant = new ArrayList<String>(Arrays.asList("The Chaos Class","Life Is Beautiful","Untouchable","Back to the Future","The Great Dictator"));
        ArrayList<String> not_relevant = new ArrayList<String>(Arrays.asList("Avengers","IT","Pulp Fiction","Citizen Kane"));
        check.containsInAnyOrderString(relevant, not_relevant, actual,true);
    }

    @Then("the list of movies should be displayed in order of release date")
    public void list_display_order_of_release_date(){
        ArrayList<String> result = action.returnElementList("//*[@id=\"main\"]/div/span/div/div/div[3]/table/tbody/tr[*]/td[2]/span");
        int[] years = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            years[i] = Integer.parseInt(result.get(i).replaceAll("[()]", ""));
        }
        //*[@id="main"]/div/span/div/div/div[3]/table/tbody/tr[*]/td[2]/a
        //*[@id="main"]/div/span/div/div/div[3]/table/tbody/tr[*]/td[2]/span
        check.assertSequentialOrder(years, true);
    }


}



