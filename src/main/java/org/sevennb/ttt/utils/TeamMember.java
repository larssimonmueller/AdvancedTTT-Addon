package org.sevennb.ttt.utils;

import net.labymod.main.LabyMod;
import org.sevennb.ttt.TTTAddon;
import org.sevennb.ttt.utils.data.WebHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

public class TeamMember extends TimerTask {
    @Override
    public void run() {
        try {
            List<String> devs = new ArrayList<String>();
            devs.add("5TC");
            TTTAddon.DEVELOPERS.clear();
            TTTAddon.DEVELOPERS = devs;
        }catch (NullPointerException e){
            if(TTTAddon.DEVELOPERS.contains(LabyMod.getInstance().getPlayerName())){
                LabyMod.getInstance().displayMessageInChat("§cFehler beim laden der Administratoren: "+e.getMessage());
            }
        }

    }
}
