package org.sevennb.ttt.utils;

import ibxm.Player;
import net.minecraft.server.MinecraftServer;
import org.sevennb.ttt.TTTAddon;

public class MessageUtils {

    public static boolean test(String message){
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
            return false;
        }
        return false;
    }

    public static boolean command(String message){
        String[] args = message.split(" ");
        if(args[0].equalsIgnoreCase("/hub") || args[0].equalsIgnoreCase("/l") || args[0].equalsIgnoreCase("/lobby")){
            TTTAddon.testlevel.clear();
            System.out.println(TextColor.ANSI_RED+"Leere die Liste!"+TextColor.ANSI_RESET);
        }
        return false;
    }

    public static boolean start(String message){
        String[] args = message.split(" ");
        String output = "";
        if(args.length == 12){
            for(int i = 0; i < 12; i++){
                if(args != null){
                    output = output+args[i]+" ";
                }else{
                    return false;
                }
            }
        }else{
            return false;
        }
        if(output.equalsIgnoreCase("[TTT] Das Spiel beginnt! Sammle Waffen und rüste dich für den Kampf ")){
            String[] players = MinecraftServer.getServer().getConfigurationManager().getAllUsernames();
            for(String player : players){
                ListUtils.tests.add(player);
                TTTAddon.testlevel.put(player, 0);
            }
            System.out.println(ListUtils.getListAsString());
        }
        return false;
    }
}
