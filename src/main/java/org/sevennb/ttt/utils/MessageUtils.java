package org.sevennb.ttt.utils;

import net.labymod.main.LabyMod;
import net.minecraft.client.Minecraft;
import org.sevennb.ttt.TTTAddon;
import org.sevennb.ttt.modules.FalleModule;
import org.sevennb.ttt.modules.RolleModule;

public class MessageUtils {

    public static boolean execute(String message){
        if(TTTAddon.STATUS){
            String[] args = message.split(" ");
                String detectMessage = "";

                if(message.contains("Du wurdest von")){
                    if(message.contains("getötet")){
                        FalleModule.falle = "-";
                        TTTAddon.testlevel.clear();
                        ListUtils.tests.clear();
                        RolleModule.rolle = "-";
                        TTTAddon.LASTKILL = args[4];
                        LabyMod.getInstance().displayMessageInChat("§3Advanced§4§lTTT§7> §eLatest-Killer: §c" + TTTAddon.LASTKILL);
                        LabyMod.getInstance().displayMessageInChat("§3Advanced§4§lTTT§7> §eRandomkilling? -> §c-r");
                    }
                }

                if(message.contains("Das Spiel beginnt!")){
                    FalleModule.falle = "§a§lNein";
                    TTTAddon.testlevel.clear();
                    ListUtils.tests.clear();
                    RolleModule.rolle = "-";
                    TTTAddon.LASTKILL = "";
                }

                if(message.contains("Du bist ein Innocent")){
                    RolleModule.rolle = "§aInnocent";
                }
                if(message.contains("Du bist ein Traitor")){
                    RolleModule.rolle = "§4Traitor";
                }
                if(message.contains("Du bist ein Detective")){
                    RolleModule.rolle = "§9Detective";
                }

                if(message.contains("Die Traitor haben alle Innocents eliminiert")){
                    FalleModule.falle = "-";
                    TTTAddon.testlevel.clear();
                    ListUtils.tests.clear();
                    RolleModule.rolle = "-";
                    TTTAddon.LASTKILL = "";
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
            TTTAddon.LASTKILL = "";
            return true;
        }else if(message.startsWith("-r")){
            if(TTTAddon.LASTKILL != ""){
                Minecraft.getMinecraft().thePlayer.sendChatMessage("/report "+TTTAddon.LASTKILL+" randomkilling confirm");
                TTTAddon.LASTKILL = "";
            }else{
                LabyMod.getInstance().displayMessageInChat("§3Advanced§4§lTTT§7> §3Du wurdest in letzter Zeit von keinem Spieler getötet!");
            }
            return true;
        }
        return false;
    }
}
