package org.sevennb.ttt.utils;

import net.minecraft.client.Minecraft;
import org.sevennb.ttt.TTTAddon;
import org.sevennb.ttt.modules.FalleModule;
import org.sevennb.ttt.modules.RolleModul;

public class MessageUtils {

    public static boolean execute(String message){
        if(TTTAddon.STATUS){
            String[] args = message.split(" ");
                String detectMessage = "";

                if(message.contains("Du wurdest von")){
                    FalleModule.falle = false;
                    TTTAddon.testlevel.clear();
                    ListUtils.tests.clear();
                    RolleModul.rolle = "";
                }

                if(message.contains("Du bist ein Innocent")){
                    RolleModul.rolle = "§aInnocent";
                }
                if(message.contains("Du bist ein Traitor")){
                    RolleModul.rolle = "§4Traitor";
                }
                if(message.contains("Du bist ein Detective")){
                    RolleModul.rolle = "§9Detective";
                }

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
                    int lvl;
                    try {
                        lvl = TTTAddon.testlevel.get(playername);
                    }catch (NullPointerException e){
                        lvl = 0;
                    }
                    TTTAddon.testlevel.remove(playername);
                    TTTAddon.testlevel.put(playername, lvl + 1);
                    if(!ListUtils.tests.contains(playername)){
                        ListUtils.tests.add(playername);
                    }
                }
            }
            return false;
    }

    public static boolean command(String message){
        if(message.startsWith("-c")){
            FalleModule.falle = false;
            TTTAddon.testlevel.clear();
            ListUtils.tests.clear();
            RolleModul.rolle = "";
            return true;
        }
        return false;
    }
}
