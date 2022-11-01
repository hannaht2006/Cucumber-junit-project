package com.cydeo.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(

        plugin = {
                "html:target/cucumber-report.html",
                "me.jvt.cucumber.report.PrettyReports:target/cucumber",
                "rerun:target/rerun.txt"
        },
 //for having report in html file location in target folder
//rerun: for re run fail scenarios

        features ="src/test/resources/features",//at package feature->right click->copy path->click->path from content/root : where to find the feature file

        glue = "com/cydeo/step_definitions" ,//at package step_definitions->right click->copy path->click->path from source/root
        //provide path of the step-definition

        dryRun = false , //determine if we want to execute step-definitions package (true: run the feature, false: run the step-definitions)

        tags = "@femaleScientist"//"@librarian or @student and not @admin"
        //if leave the tags empty: tags = "" --> will run everything in feature file
        //wip: work in progress: when see this tag we know where we are working on
)
//when we run cokesRunner: glue will run all class in step_definitions package: will run Hooks first(@Before will run now), then feature file looking for annotation (example: @smoke) to run the test, but will run background (of the feature file) first , then go to closing of the @After in Hooks class. and another round will repeat for next scenario in feature and go on the next scenario

public class cukesRunner {
}
