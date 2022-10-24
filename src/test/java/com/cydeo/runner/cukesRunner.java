package com.cydeo.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features ="src/test/resources/features",//at package feature->right click->copy path->click->path from content/root
        glue = "com/cydeo/step_definitions",//at package step_definitions->right click->copy path->click->path from source/root
        tags = "@smoke"
)

public class cukesRunner {

}
