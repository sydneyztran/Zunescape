package com.zunescape.character;

import java.util.Scanner;
import java.util.Set;

import com.zunescape.market.util.PlayerDb;

public class CharacterMenu {
    private PlayerDb playerDb;
    Scanner scan = new Scanner(System.in);
    public void open(){
        Set<String> items = playerDb.getItems();
        System.out.println("Items Owned: " + items + "\nSelect an item to equip.");
        String equippedItem = scan.nextLine();
        if (items.contains(equippedItem)){
            System.out.println("Equipped " + equippedItem);
        }
        else{
            System.out.println("Item not found.");
        }
        
    }

    public CharacterMenu(PlayerDb playerDb){
        this.playerDb = playerDb;
    }
}
