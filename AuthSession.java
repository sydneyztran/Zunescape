package com.zunescape.auth;

import java.util.Scanner;

import com.zunescape.player.Player;

public class AuthSession {
    Scanner scan = new Scanner(System.in);
    private static AuthSession session;

    //private AuthSession(){
        //is this needed?
    //}
    public static AuthSession getSession(){
        if (session == null){
           session = new AuthSession(); 
        }
        return session;
    }

    public Player auth(){
        System.out.println("Enter your username: ");
        String username = scan.nextLine();
        return new Player(){
            @Override
            public String getPUID(){
                int userHash = username.hashCode();
                return String.valueOf(userHash);
            }
            @Override
            public String getUsername(){
                return username;
            }

        };
    }

}
