package utilities;


import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.EyesRunner;
import com.applitools.eyes.TestResultsSummary;
import com.applitools.eyes.selenium.ClassicRunner;
import com.applitools.eyes.selenium.Configuration;
import com.applitools.eyes.selenium.Eyes;
import driver.driverCreator;
import io.cucumber.core.gherkin.Feature;
import io.cucumber.java.*;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class cucumberHooks {
    public static EyesRunner runner;
    public static Eyes eyes;
    private Scenario scenario;
    private Feature feature;
    public static WebDriver driver=null;
    private static final Logger logger = LoggerFactory
            .getLogger(cucumberHooks.class);

    @BeforeAll
    public static void beforeAllInitializations()
    {

        //TODO Get the Driver Init
        String applitToolKey="nYPNgP0ugIs6kiyxYQbXpYcSQTPztx0WMi2xDbY106sFs110";
        BatchInfo batch = new BatchInfo("ApplitTools Tests");
        runner = new ClassicRunner();
        Configuration config = new Configuration();
        config.setApiKey(applitToolKey);
        config.setBatch(batch);
        eyes = new Eyes(runner);
        eyes.setConfiguration(config);
        driverCreator getDriver=new driverCreator();
        driver= getDriver.createDriver("Edge");

        eyes.open(driver);
        logger.info("---------This is Before All Hook-------");
    }

    @Before
    public void beforeScenario()
    {
        //TODO Get the Driver Init
        eyes.open(driver, "Testing the New Feature","This is my first Test");

    }

    @After
    public void afterScenario()
    {
        //TODO Get the Driver
        eyes.closeAsync();
        driver.quit();
    }
    @AfterAll
    public static void afterAllCleanups()
    {
        logger.info("This is After All Hook");
        TestResultsSummary allTestResults = runner.getAllTestResults();
        logger.info("-----------------ApplitTools Test Results--------------------------");
        try {
            logger.info(allTestResults.toString());
        }
        catch (NullPointerException e) {
            logger.info("No Test Results Found");
        }

    }

}
