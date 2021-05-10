package com.jass;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import java.util.Scanner;

public class Jass {

    public static String trumpColour;

    public Jass(String trumpColour){
        this.trumpColour = trumpColour;
    }

    public static int startGame(String trumpColour){

        String theTrumpColour = trumpColour;


        int points = 0;
        return points;
    }


    public static String setTrumpColour() {

        // load up the knowledge base
        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.getKieClasspathContainer();
        KieSession kSession = kContainer.newKieSession("ksession-rules");

        System.out.println("Choose the colour of trump :");
        listCardColours();

        Scanner sc = new Scanner(System.in);

        String chosenCardColour = sc.nextLine();

        switch (chosenCardColour){
            case "HEART":
                trumpColour = CardColours.HEART.name();
                break;
            case "CHECK":
                trumpColour = CardColours.CHECK.name();
                break;
            case "SPADE":
                trumpColour = CardColours.SPADE.name();
                break;
            case "CROSS":
                trumpColour = CardColours.CROSS.name();
                break;
            default:
                System.out.println("Default is chosen! Invalid entry!");
                trumpColour = CardColours.HEART.name();
                break;
        }

        System.out.println("Colour of trump is: " + trumpColour);

        kSession.insert(trumpColour);
        kSession.fireAllRules();

        return trumpColour;

    }

    public static void listCardColours() {
        for (CardColours cardColour : CardColours.values()) {
            System.out.println(cardColour);
        }
    }


}
