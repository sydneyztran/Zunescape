package com.zunescape.player.util;

import java.util.Set;

import com.zunescape.app.util.AppPlayerFactory;
import com.zunescape.arenas.Arenas;
import com.zunescape.arenas.Tourneys;
import com.zunescape.player.Player;
import com.zunescape.royale.BattleQueue;
import com.zunescape.royale.BattleRoyale;
import com.zunescape.royale.Chat;
import com.zunescape.royale.util.Contestant;
import com.zunescape.royale.util.RangeValidator;

public interface AbstractPlayerFactory {
    Player getPrimaryPlayer();
    //Set<Player> selectPlayersWhere(String[] params);

    default public Set<Contestant> selectPlayersWhere(String[] params){
        return Set.of();
    }
}
