package com.zunescape.royale.util;

import java.util.HashSet;
import java.util.Set;

import com.zunescape.chat.ChatDecorator;

public class RangeValidator implements ChatDecorator{
    public Set<Contestant> withinRange(Set<Contestant> contestants, Contestant primary){
        return new HashSet<>(contestants);
    }

    @Override
    public void post(Set<Contestant> contestants, Contestant speaker, String msg) {
        Set<Contestant> contestantsInRange = withinRange(contestants, speaker);
        if(!contestantsInRange.isEmpty()){
           System.out.println(speaker.getPlayerId() + ": " + msg);
        } 
    }
}
