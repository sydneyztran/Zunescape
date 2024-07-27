package com.zunescape.arenas;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Tourneys {
    Scanner scan = new Scanner(System.in);
    private Map <String, String> tMap;

    public boolean hasInvite(String invite){
        return tMap.containsKey(invite);
    }

    public Set<String> getTourneys(){
        return Set.of("Gato Tourney", "Gian Tourney", "Sydney Tourney");
    }
    
    public Tourneys() {
        this.tMap = new HashMap<>();
        tMap.put("08252004", "Sydney Map");
        tMap.put("07252003", "Gian Map");
        tMap.put("04212021", "Gato Map");
    }
//last left off on this. 
    public String addTourney(String tourney){
        String inviteCode = inviteCode(tourney);
        tMap.put(inviteCode, tourney);
        return ("Invite Code for " + tourney + ": " + inviteCode(tourney));
    }

    private String inviteCode(String tourney) {
        // TODO Auto-generated method stub
        int hashCode = tourney.hashCode();
        return String.valueOf(hashCode);
        //lol should i add "gato" to the invite code haha... unless
        //throw new UnsupportedOperationException("Unimplemented method 'inviteCode'");
    }

    public String loadTourney(String invite){
        if (tMap.containsKey(invite)){
            return ("Welcome to the Tournament" + tMap.get(invite));
        }
        else{
            throw new IllegalArgumentException(invite);
        }
    }

}
