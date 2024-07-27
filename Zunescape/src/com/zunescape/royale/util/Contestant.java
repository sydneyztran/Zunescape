package com.zunescape.royale.util;

import com.zunescape.player.Player;

//The Contestant class needs a constructor, which will take a String playerId and an int elo. 
//It should store these on two private instance fields, and we should define a getter for each.

public class Contestant implements Player {
    private String username;
    private int elo;

    public Contestant(String playerId, int elo){
        this.username = playerId;
        this.elo = elo;
    }

    public String getPlayerId(){
        return username;
    }

    

    
    public int getElo(){
        return elo;
    }

	@Override
	public String getPUID() {
        return String.valueOf(username.hashCode());
    }

	@Override
	public String getUsername() {
        return username;
	}

    public static Contestant From(Player player){
        if (player instanceof Contestant){
            return (Contestant) player;
        }
        else{
            String username = player.getUsername();
            int elo = 800;
            return new Contestant(username, elo);
        }
    }

}
