package com.zunescape.royale;
import java.util.Set;

import com.zunescape.chat.ChatDecorator;
import com.zunescape.royale.util.Contestant;
import com.zunescape.royale.util.RangeValidator;

public class Chat {
    //private RangeValidator rangeValidator;
    private ChatDecorator decorator;


    public Chat(ChatDecorator decorator){
        //this.rangeValidator = rangeValidator;
        this.decorator = decorator;
    }

    public void setDecorator(ChatDecorator decorator){
        this.decorator = decorator;
    }

    public void post(Set<Contestant> contestants, Contestant speaker, String msg){
        Set<Contestant> contestantsInRange = decorator.withinRange(contestants, speaker);
        if(!contestantsInRange.isEmpty()){
           System.out.println(speaker.getPlayerId() + ": " + msg);
        } 

    }

}
