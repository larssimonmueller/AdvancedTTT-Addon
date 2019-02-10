package org.sevennb.ttt.utils;

import net.labymod.utils.ModColor;
import org.sevennb.ttt.TTTAddon;
import org.sevennb.ttt.modules.RolleModule;

import java.util.TimerTask;

public class ActionbarManager extends TimerTask {

    @Override
    public void run() {
        if(RolleModule.rolle != "-"){
            TTTAddon.ACTIONBAR = ModColor.cl('7')+"Du bist ein "+RolleModule.rolle+"§7!";
        }else{
            if(TTTAddon.UPDATE){
                TTTAddon.ACTIONBAR = ModColor.cl('9') + "Advanced"+ModColor.cl('4')+ModColor.cl('l')+"TTT "+ModColor.cl('8')+ModColor.cl('l')+"↠ "+ModColor.cl("9")+ TTTAddon.VERSION+" §7- §eEs ist ein Update verfügbar!";
            }else{
                TTTAddon.ACTIONBAR = ModColor.cl('9') + "Advanced"+ModColor.cl('4')+ModColor.cl('l')+"TTT "+ModColor.cl('8')+ModColor.cl('l')+"↠ "+ModColor.cl("9")+ TTTAddon.VERSION;
            }
        }
    }
}
