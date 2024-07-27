package com.zunescape.royale;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import com.zunescape.arenas.Arenas;
import com.zunescape.arenas.Tourneys;
import com.zunescape.player.Player;
import com.zunescape.royale.util.Contestant;

public class BattleRoyale {

    private Arenas arenas; 
    private Tourneys tourneys;
    private Chat chat;
    private BattleMatcher battleMatcher;
    public BattleRoyale(Arenas arenas, Tourneys tourneys, Chat chat){
        this.arenas = arenas;
        this.tourneys = tourneys;
        this.chat = chat;
    }

    public void battle(Set<Contestant> matchedCon, String arenaOrInvite){
        Tourneys tourneys = new Tourneys();

        if(tourneys.hasInvite(arenaOrInvite)){
            //its a tourney!
            tourneys.loadTourney(arenaOrInvite);
            System.out.println("You Win!");
        }
        else{ //why!!!!!!!!!!!
            //its an arena
            System.out.println("Welcome to " + arenaOrInvite);
            Contestant randomContestant = getRandomContestant(matchedCon); //y no longer working 
            for (Contestant contestant : matchedCon){
                chat.post(matchedCon, contestant, "Hello World!"); //WHY CHAT WHYYYY
            }
            Contestant winner = getRandomContestant(matchedCon);
            System.out.println(winner.getPlayerId() + " wins!");
        }
    }
    private static Contestant getRandomContestant(Set<Contestant> contestants) {
        if (contestants.isEmpty()){
            throw new IllegalArgumentException("Contestant is empty");
        }
        Contestant [] arrayOfContestants = contestants.toArray(new Contestant[0]);
        
        Random r = new Random();
        int i = r.nextInt(arrayOfContestants.length);
        return arrayOfContestants[i];
    }
}
