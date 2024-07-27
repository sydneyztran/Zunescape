package com.zunescape.app.util;

import com.zunescape.auth.AuthSession;
import com.zunescape.player.Player;
import com.zunescape.player.util.AbstractPlayerFactory;

public class AppPlayerFactory implements AbstractPlayerFactory{
    public Player getPrimaryPlayer() { 
        AuthSession as = AuthSession.getSession();
        Player player = as.auth();
        return player;
    }
    
}
