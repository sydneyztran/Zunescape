package com.zunescape.arenas;

import java.util.Scanner;
import com.zunescape.arenas.Arenas;

public class Forge {
    Scanner scan = new Scanner(System.in);
    private Arenas arenas;
    private Tourneys tourneys;

    //ensure its using the same area stuff lol 
    public Forge(Arenas arenas, Tourneys tourneys){
        this.arenas = arenas;
        this.tourneys = tourneys;
    }
    public void enter(){
        String answer = "null";
        while (!answer.equals("3") && !answer.equals("Quit")){
            System.out.println("Welcome to the Forge!\nWhat would you like to create?\n1)	Arena\n2)	Tourney\n3)	Quit");
            answer = scan.nextLine();
            if (answer.equals("1") || answer.equals("Arena")){
                System.out.println("What is the name of the Arena you would like to create?");
                String aName = scan.nextLine();
                arenas.addArena(aName);
            }
            else if(answer.equals("2") || answer.equals("Tourney")){
                System.out.println("What is the name of the Tourney you would like to create?");
                String tName = scan.nextLine();
                String invite = tourneys.addTourney(tName);
                System.out.println(invite);
            }
        }
    }
}
