package org.sevennb.ttt.utils;

import org.sevennb.ttt.TTTAddon;
import org.sevennb.ttt.modules.FalleModule;
import org.sevennb.ttt.modules.RolleModule;
import org.sevennb.ttt.utils.data.WebHandler;

public class MessageUtils {

    public static boolean execute(String message){
        if(TTTAddon.STATUS){
            String[] args = message.split(" ");
                String detectMessage = "";

                if(message.contains("Du wurdest von")){
                    FalleModule.falle = "§aNein";
                    TTTAddon.testlevel.clear();
                    ListUtils.tests.clear();
                    RolleModule.rolle = "-";
                }

                if(message.contains("Das Spiel beginnt!")){
                    FalleModule.falle = "§aNein";
                    TTTAddon.testlevel.clear();
                    ListUtils.tests.clear();
                    RolleModule.rolle = "-";
                }

                if(message.contains("Du bist ein Innocent")){
                    RolleModule.rolle = "§aInnocent";
                    WebHandler.send("Innocent");
                }
                if(message.contains("Du bist ein Traitor")){
                    RolleModule.rolle = "§4Traitor";
                    WebHandler.send("Traitor");
                }
                if(message.contains("Du bist ein Detective")){
                    RolleModule.rolle = "§9Detective";
                    WebHandler.send("Detective");
                }

                if(message.contains("Die Traitor haben alle Innocents eliminiert")){
                    FalleModule.falle = "-";
                    TTTAddon.testlevel.clear();
                    ListUtils.tests.clear();
                    RolleModule.rolle = "-";
                }

                if(message.contains("Die Innocents haben den Anschlag der Terroristen überlebt")){
                    FalleModule.falle = "-";
                    TTTAddon.testlevel.clear();
                    ListUtils.tests.clear();
                    RolleModule.rolle = "-";
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
            FalleModule.falle = "-";
            TTTAddon.testlevel.clear();
            ListUtils.tests.clear();
            RolleModule.rolle = "-";
            return true;
        }
        return false;
    }
}
