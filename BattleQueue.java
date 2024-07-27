package com.zunescape.royale;
import java.util.Scanner;
import java.util.Set;

import com.zunescape.app.util.AppPlayerFactory;
//import com.zunescape.royale.BattleMatcher;
import com.zunescape.arenas.Arenas;
import com.zunescape.player.Player;
import com.zunescape.player.util.AbstractPlayerFactory;
import com.zunescape.royale.util.Contestant;
import com.zunescape.royale.BattleMatcher;


public class BattleQueue {
    private Arenas arenas;
    private AbstractPlayerFactory playerFactory = new AppPlayerFactory();
    static Scanner scan = new Scanner(System.in);
    private BattleRoyale battleroyale;
    private BattleMatcher battleMatcher;

    public void enqueue(){
        //Player primaryPlayer = playerFactory.getPrimaryPlayer(); //error1
        String selectedArena = selectArena();
        Set<Contestant> matchedPlayer = playerFactory.selectPlayersWhere(new String[]{String.format("ARENA=%s", selectedArena)});
        Set<Contestant> matchedPlay = BattleMatcher.findContestants(Contestant.From(playerFactory.getPrimaryPlayer()), selectedArena);
        if (!matchedPlay.isEmpty()){
            battleroyale.battle(matchedPlay, selectedArena);
        }
        else{
            System.out.println("No contestants found for selected arena.");
        }
    }
    public BattleQueue (Arenas arenas, BattleMatcher battleMatcher, BattleRoyale battleRoyale){
        this.arenas = arenas;
        this.battleMatcher = battleMatcher;
        this.battleroyale = battleRoyale;
    }
    public BattleQueue(BattleMatcher battleMatcher, BattleRoyale battleRoyale) {
        this.battleMatcher = battleMatcher;
        this.battleroyale = battleRoyale;
        this.arenas = new Arenas();
    }

    private String selectArena(){
        if (arenas == null){
            throw new IllegalStateException("Arenas object is not initialized");
        }
        Set<String> availableArenas = arenas.getArenas();
        System.out.println("Do you have a tourney code?\n1) Yes\n2) No");
        String code = scan.nextLine();
        if (code.equals("Yes")||code.equals("1")){
            System.out.println("Please enter your tourney code:");
            //something should be here lol
            String enteredCode = scan.nextLine();
        }
        else if (code.equals("No") || code.equals("2")){
          System.out.println("New Tourney Code: " + (int)(Math.random()*1000000));
        }
        System.out.println("Please select an arena from among the following:");
        for (String arena : availableArenas){
            System.out.println(arena);
        }
        String sArena = scan.nextLine();
        return sArena;
    }
}
