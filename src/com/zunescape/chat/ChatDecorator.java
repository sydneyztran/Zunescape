package com.zunescape.chat;

import java.util.Set;

import com.zunescape.royale.util.Contestant;

public interface ChatDecorator {
    void post (Set<Contestant> contestants, Contestant speaker, String msg);

    Set<Contestant> withinRange(Set<Contestant> contestants, Contestant speaker);
}
