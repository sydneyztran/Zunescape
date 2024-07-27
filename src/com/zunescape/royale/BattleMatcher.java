package com.zunescape.royale;

import java.util.HashSet;
import java.util.Set;

import com.zunescape.player.Player;
import com.zunescape.player.util.AbstractPlayerFactory;
import com.zunescape.royale.util.Contestant;

public class BattleMatcher implements AbstractPlayerFactory {
    private Player primary;
    private AbstractPlayerFactory pF;

    public BattleMatcher(Player primary, AbstractPlayerFactory playerFactory){
        this.primary = primary;
        this.pF = playerFactory;
    }

    public static Set<Contestant> findContestants(Contestant primaryPlayer, String arena){
        Set<Contestant> matchedCon = new HashSet<>();
        if (arena.equals("Gato Arena")){
        matchedCon.add(new Contestant("Keys", primaryPlayer.getElo()));
        matchedCon.add(new Contestant("Gato", primaryPlayer.getElo()));
        matchedCon.add(new Contestant("Bato", primaryPlayer.getElo()));
        matchedCon.add(primaryPlayer);
        }
        else if (arena.equals("Gian Arena")){
        matchedCon.add(new Contestant("Morpheus", primaryPlayer.getElo()));
        matchedCon.add(new Contestant("Bradley", primaryPlayer.getElo()));
        matchedCon.add(new Contestant("Chloe", primaryPlayer.getElo()));
        matchedCon.add(primaryPlayer);
        }
        else{
        matchedCon.add(new Contestant("Sydney", primaryPlayer.getElo()));
        matchedCon.add(new Contestant("Leo", primaryPlayer.getElo()));
        matchedCon.add(new Contestant("Mac", primaryPlayer.getElo()));
        matchedCon.add(primaryPlayer);
        }
        return matchedCon;
    }

    public Player getPrimaryPlayer() {
        return primary;
    }

    public Set<Contestant> selectPlayersWhere(String[] params){
        String aName = "";
        for (String param : params){
            if (param.startsWith("ARENA=")){
                aName = param.split("=")[1];
                break;
            }
        } 
        Set<Player> players = new HashSet<>();
        Set<Contestant>contestants = findContestants(Contestant.From(this.getPrimaryPlayer()),aName);
        for (Contestant contestant : contestants){
            players.add(contestant);
        }
        //return players;
        Set<Contestant> matchedCon = new HashSet<>();
        Contestant primaryPlayer = Contestant.From(this.getPrimaryPlayer());
        return findContestants(primaryPlayer, aName);
    }
}
