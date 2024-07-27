package com.zunescape.arenas;

import java.util.HashSet;
import java.util.Set;

import com.zunescape.royale.BattleMatcher;
import com.zunescape.royale.BattleRoyale;

public class Arenas{
    private Set<String> arenas;
    private BattleMatcher battleMatcher;
    private BattleRoyale battleRoyale;

    //arenas = Set.of("Gato Arena","Gian Arena", "Sydney Arena");

    public Set<String> getArenas(){
        return arenas;
    }
    



    public void enterForge(){
        System.out.println("Welcome to the Forge!");
    }
    public void Arenas(BattleMatcher battleMatcher, BattleRoyale battleRoyale) {

        this.battleMatcher = battleMatcher;
        this.battleRoyale = battleRoyale;

    }
    public Arenas(){
        this.arenas = new HashSet<>();
        arenas.add("Gian Arena");
        arenas.add("Sydney Arena");
        arenas.add("Gato Arena");
    }

    public void addArena(String arena) {
        // TODO Auto-generated method stub
        if (!arenas.contains(arena)){
            arenas.add(arena);
            System.out.println("Arena added: " + arena);
        }
        else{
            System.out.println("Error. This arena already exists.");
        }


    }

    public boolean loadArena(String arena){
        return true;
    }
    private void joinTourney(){
        System.out.println("What is your tourney invite code?");
    } 
}
