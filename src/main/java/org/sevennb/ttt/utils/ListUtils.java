package org.sevennb.ttt.utils;

import org.sevennb.ttt.TTTAddon;

import java.util.ArrayList;
import java.util.List;

public class ListUtils {

    public static List<String> tests = new ArrayList<String>();

    public static String getListAsString(TestLevel testLevel){
        String output = "";
        if(testLevel == TestLevel.ONE){
            for(String out : tests){
                String playername = out;
                int lvl = TTTAddon.testlevel.get(playername);
                if(lvl == 0){
                    output = output+"§c"+playername+"§f, ";
                }else if(lvl == 1){
                    output = output+"§a"+playername+"§f, ";
                }
            }
            if (output == ""){
                return "-";
            }
            return output;
        }else if(testLevel == TestLevel.TWO){
            for(String out : tests){
                String playername = out;
                int lvl = TTTAddon.testlevel.get(playername);
                if(lvl >= 2){
                    output = output+"§2"+playername+"§f, ";
                }
            }
            if (output == ""){
                return "-";
            }
            return output;
        }
        return "Keine";
    }

    public static String getRole(String playername){
        if(TTTAddon.NAMETAGS){
            if(tests.contains(playername)){
                int lvl = TTTAddon.testlevel.get(playername);
                if(tests.size() != 0){
                    if(lvl == 1){
                        return "§8- §eTester §a"+lvl;
                    }else if(lvl > 1){
                        return "§8- §eTester §2"+lvl;
                    }
                }
            }
        }
        return "";
    }
}
