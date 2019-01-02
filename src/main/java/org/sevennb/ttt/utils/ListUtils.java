package org.sevennb.ttt.utils;

import org.sevennb.ttt.TTTAddon;

import java.util.ArrayList;
import java.util.List;

public class ListUtils {

    public static List<String> tests = new ArrayList<String>();

    public static String getListAsString(){
        String output = "";
        for(String out : tests){
            String playername = out;
            int lvl = TTTAddon.testlevel.get(playername);
            if(lvl == 0){
                output = output+TextColor.ANSI_RED+playername+TextColor.ANSI_RESET+"\n";
            }else if(lvl == 1){
                output = output+TextColor.ANSI_YELLOW+playername+TextColor.ANSI_RESET+"\n";
            }else if(lvl >= 2){
                output = output+TextColor.ANSI_RED+playername+TextColor.ANSI_GREEN+"\n";
            }
        }
        return output;
    }

}
