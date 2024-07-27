package com.zunescape.market;

import java.util.Scanner;
import java.util.Set;

import com.zunescape.market.util.PlayerDb;

public class GameStore {
    Scanner scan = new Scanner(System.in);
    private PlayerDb playerDb = new PlayerDb();
    public GameStore(PlayerDb playerdb){
        this.playerDb = playerDb;
    }

    public void enter(){
        Set<String> items = playerDb.getItems();
        if (playerDb == null){
            System.out.println("PlayerDb is null");
        }
        System.out.println("Select one of the following items: " + items);
        String equippedItem = scan.nextLine();
        if (items.contains(equippedItem)){
            System.out.println("Equipped " + equippedItem);
            playerDb.addItem(equippedItem);
        }
        else{
            System.out.println("Item not found.");
        }
        
    }
}
