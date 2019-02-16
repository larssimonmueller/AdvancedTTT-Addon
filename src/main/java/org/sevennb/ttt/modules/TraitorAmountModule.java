package org.sevennb.ttt.modules;

import net.labymod.core.LabyModCore;
import net.labymod.ingamegui.modules.OnlinePlayersModule;
import net.labymod.ingamegui.moduletypes.SimpleModule;
import net.labymod.settings.elements.ControlElement;
import net.labymod.utils.Material;

public class TraitorAmountModule extends SimpleModule {
    @Override
    public String getDisplayName() {
        return "Traitor";
    }

    @Override
    public String getDisplayValue() {
        if(LabyModCore.getMinecraft().getConnection() == null){
            return "";
        }
        if(RolleModule.rolle != "-"){
            if(RolleModule.rolle == "§4Traitor"){
                return "-";
            }else{
                return getTraitorsAlive()+"/"+ new OnlinePlayersModule().getDisplayValue();
            }
        }else{
            return "-";
        }
    }

    @Override
    public String getDefaultValue() {
        return "-";
    }

    @Override
    public ControlElement.IconData getIconData() {
        return new ControlElement.IconData(Material.STICK);
    }

    @Override
    public void loadSettings() {

    }

    @Override
    public String getSettingName() {
        return "Traitor";
    }

    @Override
    public String getDescription() {
        return "Zeigt die möglichen Traitor an";
    }

    @Override
    public int getSortingId() {
        return 2;
    }

    public static Integer getTraitorsAlive(){
        int players = Integer.valueOf(new OnlinePlayersModule().getDisplayValue());
        switch (players){
            case 1:
                return 0;
            case 2:
                return 1;
            case 3:
                return 1;
            case 4:
                return 1;
            case 5:
                return 2;
            case 6:
                return 2;
            case 7:
                return 3;
            case 8:
                return 3;
            case 9:
                return 3;
            case 10:
                return 3;
            case 11:
                return 4;
            case 12:
                return 4;
        }
        return 0;
    }
}
