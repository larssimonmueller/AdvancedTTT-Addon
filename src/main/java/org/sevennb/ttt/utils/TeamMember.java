package org.sevennb.ttt.utils;

import net.labymod.main.LabyMod;
import org.sevennb.ttt.TTTAddon;
import org.sevennb.ttt.utils.data.WebHandler;

import java.util.TimerTask;

public class TeamMember extends TimerTask {
    @Override
    public void run() {
        TTTAddon.DEVELOPERS.clear();
        TTTAddon.DEVELOPERS = WebHandler.readDevelopers();
        if(TTTAddon.DEVELOPERS.contains(LabyMod.getInstance().getPlayerName())){
            try {
                LabyMod.getInstance().displayMessageInChat("§3Advanced§4§lTTT§7> §7Neue Admins geladen!");
            }catch (Exception e){}
        }
    }
}
