package org.sevennb.ttt.utils;

import org.sevennb.ttt.TTTAddon;

public class MessageUtils {

    public static boolean execute(String message){
        if(TTTAddon.STATUS){
            String[] args = message.split(" ");
                String detectMessage = "";

                if(args.length == 6){
                    for(int i = 2; i < 6; i++){
                        if(args[i] == null){
                            break;
                        }else{
                            detectMessage = detectMessage+args[i]+" ";
                        }
                    }
                }else{
                    return false;
                }
                if(detectMessage.equalsIgnoreCase("hat den Traitor-Tester betreten ")) {
                    String playername = args[1];
                    System.out.println(TextColor.ANSI_RED + "Spieler im Tester: " + playername + TextColor.ANSI_RESET);

                    int lvl = TTTAddon.testlevel.get(playername);
                    TTTAddon.testlevel.remove(playername);
                    TTTAddon.testlevel.put(playername, lvl + 1);
                }
            }
            return false;
    }
}
