package CucumRunner;

import Util.MyLogger;
import Util.SeleniumBase;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class CucumberHooksTest {


   public static Scenario scenario;

   public static Scenario getScenario(){
       return scenario;
   }

    @Before
    public void  prepare(Scenario scenario){
       this.scenario=scenario;
    }

    @After
    public void cleanup(Scenario scenario){

        this.scenario=scenario;

        if (scenario.isFailed()){
            MyLogger.info(SeleniumBase.driver.getCurrentUrl());
            byte[] screenshot=SeleniumBase.takeScreenshot();
            scenario.embed(screenshot, "image/png");
            SeleniumBase.tearDown();

        }
    }

}
