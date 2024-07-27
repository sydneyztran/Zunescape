package com.zunescape.market.util;

import java.util.HashSet;
import java.util.Set;

public class PlayerDb {
    private Set<String> items;

    public boolean addItem(String item) {
        return items.add(item);
    }

    public PlayerDb(){
        this.items = new HashSet<>();
        items.add("gato treats");
        items.add("gato toys");
        items.add("gato house");
    }
    
    public Set<String> getItems(){
        return items;
    }


}
