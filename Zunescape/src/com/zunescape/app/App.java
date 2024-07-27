package com.zunescape.app;

import java.util.Scanner;

import com.zunescape.app.util.AppPlayerFactory;
import com.zunescape.arenas.Arenas;
import com.zunescape.arenas.Forge;
import com.zunescape.arenas.Tourneys;
import com.zunescape.character.CharacterMenu;
import com.zunescape.market.GameStore;
import com.zunescape.market.PlayerExchange;
import com.zunescape.market.util.PlayerDb;
import com.zunescape.player.Player;
import com.zunescape.player.util.AbstractPlayerFactory;
import com.zunescape.royale.BattleMatcher;
import com.zunescape.royale.BattleQueue;
import com.zunescape.royale.BattleRoyale;
import com.zunescape.royale.Chat;
import com.zunescape.royale.util.Contestant;
import com.zunescape.royale.util.RangeValidator;

public class App {
    Scanner scan = new Scanner(System.in);
    public static void main (String[] args){
        Scanner scan = new Scanner(System.in);
        Arenas arenas = new Arenas();
        Tourneys tourneys = new Tourneys();
        Forge forge = new Forge(arenas, tourneys);
        RangeValidator rangeValidator = new RangeValidator();
        Chat chat = new Chat(rangeValidator);
        BattleRoyale battleRoyale = new BattleRoyale(arenas, tourneys, chat);
        ///BattleQueue battleQueue = new BattleQueue(arenas, battleRoyale);
        PlayerDb playerDb = new PlayerDb();
        GameStore gamestore = new GameStore(playerDb);
        PlayerExchange playerExchange = new PlayerExchange(playerDb);
        CharacterMenu charactermenu = new CharacterMenu(playerDb);
        //AppPlayerFactory appPlayerFactory = playerFactory.getPrimaryPlayer();
        String answer = "null";
        AbstractPlayerFactory playerFactory = new AppPlayerFactory();
        Player primaryPlayer = playerFactory.getPrimaryPlayer();
        BattleMatcher battleMatcher = new BattleMatcher(primaryPlayer, playerFactory);
        BattleQueue battleQueue = new BattleQueue(battleMatcher, battleRoyale);
        BattleQueue bq = new BattleQueue(arenas,battleMatcher, battleRoyale);
        System.out.println("Primary Player: " + primaryPlayer);
        System.out.println("PUID: " + primaryPlayer.getPUID());
        System.out.println("Username: " + primaryPlayer.getUsername());

        //some additional actions//////////////////

        //////////////////////////////////////////
        while (!answer.equals("6") && !answer.equals("Quit")){
            System.out.println("Welcome to Ze Wilds of Zunescape!\nWhat would you like do?\n1)	Battle\n2)	Forge\n3)	Purchase\n4)	Trade\n5)	Accessorize\n6)	Quit");
            answer = scan.nextLine();
            if (answer.equals("1") || answer.equals("Battle")){
                battleQueue.enqueue();
            }
            else if (answer.equals("2" ) || answer.equals("Forge")){
                forge.enter();
            }
            else if (answer.equals("3") || answer.equals("Purchase")){
                gamestore.enter();
            }
            else if (answer.equals("4") || answer.equals("Trade")){
                playerExchange.enter();
            }
            else if (answer.equals("5") || answer.equals("Accessorize")){
                charactermenu.open();
            }
        }
        scan.close();
    }
    
}
