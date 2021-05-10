/***package com.jass;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import pl.maciejwalkowiak.drools.DroolsJUnitRunner;
import pl.maciejwalkowiak.drools.annotations.DroolsFiles;
import pl.maciejwalkowiak.drools.annotations.DroolsSession;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(DroolsJUnitRunner.class)
@DroolsFiles(value = "rules.drl", location = "/rules/")
public class DroolsRulesTests {

    KieServices kieServices = KieServices.Factory.get();
    KieContainer kContainer = kieServices.getKieClasspathContainer();
    @DroolsSession
    public KieSession ksession = kContainer.newKieSession();


    @Disabled
    @Test
    @DisplayName("First Drools Test")
    public static void droolsTest()    {




        //ksession.insert(purchase);
        //ksession.fireAllRules();
    assertEquals("1","1");

    }

}
**/