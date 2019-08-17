package org.sevennb.ttt.utils;

import net.labymod.utils.ModColor;
import org.sevennb.ttt.TTTAddon;
import org.sevennb.ttt.modules.RolleModule;

import java.util.TimerTask;

public class ActionbarManager extends TimerTask {

    @Override
    public void run() {
        if(TTTAddon.ACTION){
            if(RolleModule.rolle != "-"){
                TTTAddon.ACTIONBAR = ModColor.cl('7')+"Du bist ein "+RolleModule.rolle+"§7!";
            }else{
                if(TTTAddon.UPDATE){
                    TTTAddon.ACTIONBAR = ModColor.cl('3') + "Advanced"+ModColor.cl('4')+ModColor.cl('l')+"TTT "+ModColor.cl('8')+ModColor.cl('l')+"↠ "+ModColor.cl("3")+ TTTAddon.VERSION+" §7- §eEs ist ein Update verfügbar! ("+TTTAddon.CURRENT +")";
                }else{
                    TTTAddon.ACTIONBAR = ModColor.cl('3') + "Advanced"+ModColor.cl('4')+ModColor.cl('l')+"TTT "+ModColor.cl('8')+ModColor.cl('l')+"↠ "+ModColor.cl("3")+ TTTAddon.VERSION;
                }
            }
        }else{
            TTTAddon.ACTIONBAR = "";
        }
    }
}
